package arrays_methods.class_problems;

import java.util.Arrays;

public class PlacementDriveRankingEngine {

    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // Quick filter: a strong CGPA alone is enough.
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        // Borderline CGPA can still qualify through a good coding score.
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        boolean qualifies() {
            return isEligible(cgpa) || isEligible(cgpa, codingScore);
        }

        // Composite score = CGPA x 10 + half of the coding score.
        double composite() {
            return cgpa * 10 + codingScore * 0.5;
        }

        // Descending by composite score, so Arrays.sort alone ranks the array.
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.composite(), this.composite());
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;
        for (Candidate c : candidates) {
            if (c.qualifies()) {
                shortlisted[count++] = c;
            }
        }
        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ").append(shortlisted[i].name)
              .append(" (").append(shortlisted[i].composite()).append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(batch));
    }
}
