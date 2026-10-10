package inheritance_polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationQuestionGrader {

    static abstract class Question {
        protected final String correctAnswer, studentAnswer;
        protected final double points;

        Question(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract String type();

        abstract double score();
    }

    static class McqQuestion extends Question {
        McqQuestion(String c, String s, double p) { super(c, s, p); }
        String type() { return "MCQ"; }
        double score() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }

    static class TrueFalseQuestion extends Question {
        TrueFalseQuestion(String c, String s, double p) { super(c, s, p); }
        String type() { return "TF"; }
        double score() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String c, String s, double p) { super(c, s, p); }
        String type() { return "ESSAY"; }

        double score() {
            String answer = studentAnswer.toLowerCase();
            int matched = 0;
            for (String keyword : correctAnswer.split(",")) {
                String k = keyword.trim().toLowerCase();
                if (!k.isEmpty() && answer.contains(k)) {
                    matched++;
                }
            }
            if (matched >= 2) return points * 0.75;
            if (matched == 1) return points * 0.50;
            return 0;
        }
    }

    static List<String> tokens(String line) {
        List<String> out = new ArrayList<>();
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (m.find()) {
            out.add(m.group(1) != null ? m.group(1) : m.group(2));
        }
        return out;
    }

    // Tokens: TYPE "question" "correct" "student" points
    static Question create(List<String> t) {
        String correct = t.get(2), student = t.get(3);
        double points = Double.parseDouble(t.get(4));
        switch (t.get(0)) {
            case "MCQ":   return new McqQuestion(correct, student, points);
            case "TF":    return new TrueFalseQuestion(correct, student, points);
            case "ESSAY": return new EssayQuestion(correct, student, points);
            default: throw new IllegalArgumentException("Unknown question type: " + t.get(0));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            questions.add(create(tokens(sc.nextLine())));
        }
        double total = 0;
        for (Question q : questions) {
            double s = q.score();
            total += s;
            System.out.println(String.format(Locale.US, "%s: %.2f", q.type(), s));
        }
        System.out.println(String.format(Locale.US, "Total Score: %.2f", total));
    }
}
