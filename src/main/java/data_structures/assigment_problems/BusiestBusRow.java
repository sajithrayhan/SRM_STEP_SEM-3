package data_structures.assigment_problems;

/**
 * Problem 10: Busiest Bus Row.
 *
 * <p>Finds the row of a seat grid with the largest total number of students. If two rows tie,
 * the row with the smaller index wins, because the best row is only replaced when a total is
 * strictly larger.
 *
 * <p>Complexity: time O(r * c), because every cell is visited exactly once. Additional space O(1),
 * because only the running row total and the best row so far are stored.
 */
public class BusiestBusRow {

    /** Returns {rowIndex, total} of the busiest row. */
    static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;
        for (int row = 0; row < grid.length; row++) {
            int rowTotal = 0;
            for (int seat : grid[row]) {
                rowTotal += seat;
            }
            if (rowTotal > bestTotal) {
                bestTotal = rowTotal;
                bestRow = row;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
