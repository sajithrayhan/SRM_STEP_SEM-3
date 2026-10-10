package encapsulation.class_problems;

public class Scorecard {
    private final boolean[] results;
    private int recorded;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recorded = 0;
    }

    // Returns false (ignored) if the fixed number of questions has been reached.
    public boolean recordAnswer(boolean correct) {
        if (recorded >= results.length) {
            return false;
        }
        results[recorded++] = correct;
        return true;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score = " + sc.getScore());
        System.out.println("Extra answer accepted? " + sc.recordAnswer(true));
        System.out.println("Score still = " + sc.getScore());
    }
}
