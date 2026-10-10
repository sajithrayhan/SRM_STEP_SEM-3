package string_operations.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StopWordFilteredWordFrequency {

    private static final Set<String> STOP_WORDS =
            new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> counts = new LinkedHashMap<>();     // keeps first-seen order for ties
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());     // descending by count (stable)
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public static void main(String[] args) {
        try {
            printFilteredWordFrequency("The mentor was great, the session was great and clear.");
        } catch (RuntimeException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
