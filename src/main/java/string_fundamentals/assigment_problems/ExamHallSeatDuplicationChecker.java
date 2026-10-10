package string_fundamentals.assigment_problems;

public class ExamHallSeatDuplicationChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            // Skip if this value already appeared earlier (so each duplicate is reported once).
            boolean seenBefore = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    seenBefore = true;
                    break;
                }
            }
            if (seenBefore) {
                continue;
            }
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
