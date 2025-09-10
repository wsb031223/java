import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a 2 dimensional data, as a nested lists,
    which is similar to matrix, however, unlike matrices,
    each row may contain a different number of columns.
    Given lst, and integer x, find integers x in the list,
    and return list of lists, [[x1, y1], [x2, y2] ...] such that
    each list is a coordinate - (row, columns), starting with 0.
    Sort coordinates initially by rows in ascending order.
    Also, sort coordinates of the row by columns in descending order.

    Examples:
    getRow([
      [1,2,3,4,5,6],
      [1,2,3,4,1,6],
      [1,2,3,4,5,1]
    ], 1) == [[0, 0], [1, 4], [1, 0], [2, 5], [2, 0]]
    getRow([], 1) == []
    getRow([[], [1], [1, 2, 3]], 3) == [[2, 2]]
     */
    public List<List<Integer>> getRow(List<List<Integer>> lst, int x) {
        // Let's think step by step
        // Input: lst (nested list), x (integer to find)
        // Output: list of coordinates [row, column]
        // 1. Initialize an empty result list
        // 2. Loop through each row (sequential + loop)
        // 3. For each row, loop through each column (nested loop)
        // 4. If element equals x, add coordinate to result (branch)
        // 5. Sort the result: first by row ascending, then by column descending
        // 6. Return the result
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Iterate through each row
        for (int i = 0; i < lst.size(); i++) {
            List<Integer> row = lst.get(i);
            // Iterate through each column in the current row
            for (int j = 0; j < row.size(); j++) {
                if (row.get(j) == x) {
                    // Add coordinate as [row, column]
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    result.add(coord);
                }
            }
        }
        
        // Sort the result: first by row ascending, then by column descending
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                int rowCompare = Integer.compare(a.get(0), b.get(0));
                if (rowCompare != 0) {
                    return rowCompare;
                }
                // For same row, sort by column in descending order
                return Integer.compare(b.get(1), a.get(1));
            }
        });
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 1, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 1)
                ), 1).equals(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 4), Arrays.asList(1, 0), Arrays.asList(2, 5), Arrays.asList(2, 0))),
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                ), 2).equals(Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 1), Arrays.asList(2, 1), Arrays.asList(3, 1), Arrays.asList(4, 1), Arrays.asList(5, 1))),
                s.getRow(Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 1, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 1, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 1, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 1, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 1)
                ), 1).equals(Arrays.asList(Arrays.asList(0, 0), Arrays.asList(1, 0), Arrays.asList(2, 1), Arrays.asList(2, 0), Arrays.asList(3, 2), Arrays.asList(3, 0), Arrays.asList(4, 3), Arrays.asList(4, 0), Arrays.asList(5, 4), Arrays.asList(5, 0), Arrays.asList(6, 5), Arrays.asList(6, 0))),
                s.getRow(List.of(), 1).equals(List.of()),
                s.getRow(List.of(List.of(1)), 2).equals(List.of()),
                s.getRow(Arrays.asList(List.of(), List.of(1), Arrays.asList(1, 2, 3)), 3).equals(List.of(Arrays.asList(2, 2)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}