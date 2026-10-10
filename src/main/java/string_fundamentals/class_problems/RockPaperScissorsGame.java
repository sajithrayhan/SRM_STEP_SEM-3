package string_fundamentals.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    static String randomComputerMove(Random random) {
        return MOVES[random.nextInt(MOVES.length)];
    }

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        boolean playerWins = (playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        // Player moves come from a predefined list (live demo); the computer's moves are random.
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int rounds = playerMoves.length;
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;
        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = randomComputerMove(random);
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            if (results[i].equals("Player Wins")) wins++;
            else if (results[i].equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + "     | " + playerMoves[i] + " | " + computerMoves[i] + " | " + results[i]);
        }
        double winPercent = wins * 100.0 / rounds;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + String.format("%.1f", winPercent) + "%");
    }
}
