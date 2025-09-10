import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a rectangular grid of wells. Each row represents a single well,
    and each 1 in a row represents a single unit of water.
    Each well has a corresponding bucket that can be used to extract water from it,
    and all buckets have the same capacity.
    Your task is to use the buckets to empty the wells.
    Output the number of times you need to lower the buckets.

    Example 1:
        Input:
            grid : [[0,0,1,0], [0,1,0,0], [1,1,1,1]]
            bucket_capacity : 1
        Output: 6

    Example 2:
        Input:
            grid : [[0,0,1,1], [0,0,0,0], [1,1,1,1], [0,1,1,1]]
            bucket_capacity : 2
        Output: 5

    Example 3:
        Input:
            grid : [[0,0,0], [0,0,0]]
            bucket_capacity : 5
        Output: 0

    Constraints:
        * all wells have the same length
        * 1 <= grid.length <= 10^2
        * 1 <= grid[:,1].length <= 10^2
        * grid[i][j] -> 0 | 1
        * 1 <= capacity <= 10
     */
    public int maxFill(List<List<Integer>> grid, int capacity) {
        // Let's think step by step
        // Input: grid (list of rows/wells with 0/1 cells), capacity (bucket capacity per well)
        // Output: total number of times buckets are lowered across all wells

        // Sequential structure:
        // 1) Initialize a counter for total lowerings.
        // 2) For each well (row), count the number of water units.
        // 3) Compute the number of lowerings for that well as ceil(waterUnits / capacity).
        // 4) Accumulate into the total and return it.

        // Branch structure:
        // - While counting, if a cell is 1, increment the water count, else skip.
        // - If a well has 0 water units, it contributes 0 lowerings.

        // Loop structure:
        // - Loop over all rows (wells).
        // - Nested loop over all cells in each row.

        int totalLowerings = 0;

        for (int i = 0; i < grid.size(); i++) {
            List<Integer> row = grid.get(i);
            int waterUnits = 0;

            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == 1) { // branch
                    waterUnits++;
                }
            }

            if (waterUnits > 0) { // branch
                int lowers = (waterUnits + capacity - 1) / capacity; // ceil division
                totalLowerings += lowers;
            }
        }

        return totalLowerings;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.maxFill(Arrays.asList(Arrays.asList(0, 0, 1, 0), Arrays.asList(0, 1, 0, 0), Arrays.asList(1, 1, 1, 1)), 1) == 6,
                s.maxFill(Arrays.asList(Arrays.asList(0, 0, 1, 1), Arrays.asList(0, 0, 0, 0), Arrays.asList(1, 1, 1, 1), Arrays.asList(0, 1, 1, 1)), 2) == 5,
                s.maxFill(Arrays.asList(Arrays.asList(0, 0, 0), Arrays.asList(0, 0, 0)), 5) == 0,
                s.maxFill(Arrays.asList(Arrays.asList(1, 1, 1, 1), Arrays.asList(1, 1, 1, 1)), 2) == 4,
                s.maxFill(Arrays.asList(Arrays.asList(1, 1, 1, 1), Arrays.asList(1, 1, 1, 1)), 9) == 2
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}