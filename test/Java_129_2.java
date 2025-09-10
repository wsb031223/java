import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a grid with N rows and N columns (N >= 2) and a positive integer k,
    each cell of the grid contains a value. Every integer in the range [1, N * N]
    inclusive appears exactly once on the cells of the grid.

    You have to find the minimum path of length k in the grid. You can start
    from any cell, and in each step you can move to any of the neighbor cells,
    in other words, you can go to cells which share an edge with you current
    cell.
    Please note that a path of length k means visiting exactly k cells (not
    necessarily distinct).
    You CANNOT go off the grid.
    A path A (of length k) is considered less than a path B (of length k) if
    after making the ordered lists of the values on the cells that A and B go
    through (let's call them lst_A and lst_B), lst_A is lexicographically less
    than lst_B, in other words, there exist an integer index i (1 <= i <= k)
    such that lst_A[i] < lst_B[i] and for any j (1 <= j < i) we have
    lst_A[j] = lst_B[j].
    It is guaranteed that the answer is unique.
    Return an ordered list of the values on the cells that the minimum path go through.

    Examples:

        Input: grid = [ [1,2,3], [4,5,6], [7,8,9]], k = 3
        Output: [1, 2, 1]

        Input: grid = [ [5,9,3], [4,1,6], [7,8,2]], k = 1
        Output: [1]
     */
    public List<Integer> minPath(List<List<Integer>> grid, int k) {
        // Let's think step by step
        // Input: grid (N x N), k
        // Output: List<Integer> of length k, the lexicographically smallest path values.
        // Problem-solving process using three programming structures:
        // Sequential structure:
        // 1) Scan the entire grid to find the cell with the minimum value; this is the optimal starting cell.
        // 2) Initialize the answer list and set the current position to that cell.
        // Loop structure:
        // 3) Repeat for each step from 1 to k:
        //    - Add the current cell's value to the answer list.
        //    - If we've added k values, stop.
        //    - Otherwise, among all valid neighbors (up, down, left, right), choose the neighbor with the smallest value and move there.
        // Branch structure:
        // - While scanning neighbors, check bounds (if statements) and update the best neighbor when a smaller value is found.
        // - The loop naturally handles k == 1 by not moving after the first addition.

        int n = grid.size();

        // 1) Find the position of the global minimum value in the grid.
        int minVal = Integer.MAX_VALUE;
        int startR = 0, startC = 0;
        for (int r = 0; r < n; r++) {
            List<Integer> row = grid.get(r);
            for (int c = 0; c < n; c++) {
                int v = row.get(c);
                if (v < minVal) {
                    minVal = v;
                    startR = r;
                    startC = c;
                }
            }
        }

        // 2) Initialize answer list and current position.
        List<Integer> ans = new ArrayList<>(k);
        int r = startR, c = startC;

        // Neighbor direction vectors: up, down, left, right
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 3) Build the path greedily.
        for (int step = 0; step < k; step++) {
            ans.add(grid.get(r).get(c));
            if (step == k - 1) break;

            // Find the neighbor with the smallest value.
            int bestR = r, bestC = c;
            int bestVal = Integer.MAX_VALUE;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                // Branch: check bounds
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int nv = grid.get(nr).get(nc);
                    if (nv < bestVal) {
                        bestVal = nv;
                        bestR = nr;
                        bestC = nc;
                    }
                }
            }
            // Move to the best neighbor.
            r = bestR;
            c = bestC;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), 3).equals(Arrays.asList(1, 2, 1)),
                s.minPath(Arrays.asList(Arrays.asList(5, 9, 3), Arrays.asList(4, 1, 6), Arrays.asList(7, 8, 2)), 1).equals(List.of(1)),
                s.minPath(Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8), Arrays.asList(9, 10, 11, 12), Arrays.asList(13, 14, 15, 16)), 4).equals(Arrays.asList(1, 2, 1, 2)),
                s.minPath(Arrays.asList(Arrays.asList(6, 4, 13, 10), Arrays.asList(5, 7, 12, 1), Arrays.asList(3, 16, 11, 15), Arrays.asList(8, 14, 9, 2)), 7).equals(Arrays.asList(1, 10, 1, 10, 1, 10, 1)),
                s.minPath(Arrays.asList(Arrays.asList(8, 14, 9, 2), Arrays.asList(6, 4, 13, 15), Arrays.asList(5, 7, 1, 12), Arrays.asList(3, 10, 11, 16)), 5).equals(Arrays.asList(1, 7, 1, 7, 1)),
                s.minPath(Arrays.asList(Arrays.asList(11, 8, 7, 2), Arrays.asList(5, 16, 14, 4), Arrays.asList(9, 3, 15, 6), Arrays.asList(12, 13, 10, 1)), 9).equals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1)),
                s.minPath(Arrays.asList(Arrays.asList(12, 13, 10, 1), Arrays.asList(9, 3, 15, 6), Arrays.asList(5, 16, 14, 4), Arrays.asList(11, 8, 7, 2)), 12).equals(Arrays.asList(1, 6, 1, 6, 1, 6, 1, 6, 1, 6, 1, 6)),
                s.minPath(Arrays.asList(Arrays.asList(2, 7, 4), Arrays.asList(3, 1, 5), Arrays.asList(6, 8, 9)), 8).equals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3)),
                s.minPath(Arrays.asList(Arrays.asList(6, 1, 5), Arrays.asList(3, 8, 9), Arrays.asList(2, 7, 4)), 8).equals(Arrays.asList(1, 5, 1, 5, 1, 5, 1, 5)),
                s.minPath(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4)), 10).equals(Arrays.asList(1, 2, 1, 2, 1, 2, 1, 2, 1, 2)),
                s.minPath(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 2)), 10).equals(Arrays.asList(1, 3, 1, 3, 1, 3, 1, 3, 1, 3))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}