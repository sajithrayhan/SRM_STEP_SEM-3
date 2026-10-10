package inheritance_polymorphism.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryItemDueDateCalculator {

    // "Current date" fixed by the problem statement.
    static final LocalDate TODAY = LocalDate.of(2023, 10, 26);

    static abstract class LibraryItem {
        protected final String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int borrowDays();

        LocalDate dueDate() {
            return TODAY.plusDays(borrowDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        int borrowDays() { return 14; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) { super(title); }
        int borrowDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        int borrowDays() { return 3; }
    }

    static LibraryItem create(String type, String title) {
        switch (type) {
            case "BOOK":     return new Book(title);
            case "DVD":      return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    // Splits a line into tokens, treating "quoted text" as one token (quotes removed).
    static List<String> tokens(String line) {
        List<String> out = new ArrayList<>();
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (m.find()) {
            out.add(m.group(1) != null ? m.group(1) : m.group(2));
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> t = tokens(sc.nextLine());
            items.add(create(t.get(0), t.get(1)));
        }
        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.dueDate());
        }
    }
}
