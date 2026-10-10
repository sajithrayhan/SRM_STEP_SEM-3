package arrays_methods.assigment_problems;

import java.util.Arrays;

public class FantasyLeagueAutoDraft {

    static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Established players qualify on experience alone.
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Newer players need some experience AND to be fit.
        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        boolean draftable() {
            return isDraftable(matchesPlayed) || isDraftable(matchesPlayed, injured);
        }

        double fantasyPoints() {
            return battingAverage;
        }

        // Descending by fantasy points, so Arrays.sort alone does the ranking.
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.fantasyPoints(), this.fantasyPoints());
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;
        for (Player p : players) {
            if (p.draftable()) {
                draftable[count++] = p;
            }
        }
        draftable = Arrays.copyOf(draftable, count);
        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(i + 1).append(". ").append(draftable[i].name);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
