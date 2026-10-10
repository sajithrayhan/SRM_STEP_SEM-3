package arrays_methods.assigment_problems;

public class MatchDayGridAnalyzer {

    // Only computes one match's average.
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int v : row) {
            sum += v;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);         // once per match
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append("Match ").append(i).append(": ").append(avg >= threshold ? "Power Surge" : "Normal");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(runs, 8));
    }
}
