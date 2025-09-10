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
        // Input: lst (List<List<Integer>>), x (int)
        // Output: List<List<Integer>> of coordinates [row, col]
        // Sequential:
        // 1) Initialize an empty result list to store coordinates.
        // Loop:
        // 2) For each row index i from 0 to lst.size()-1:
        //    2a) For each column index j from 0 to lst.get(i).size()-1:
        // Branch:
        //    2b) If the element at (i, j) equals x, add [i, j] to result.
        // Sequential:
        // 3) Sort result by row ascending, and within the same row by column descending.
        // 4) Return the result.

        List<List<Integer>> result = new ArrayList<>();
        if (lst == null || lst.isEmpty()) {
            return result;
        }

        for (int i = 0; i < lst.size(); i++) {
            List<Integer> row = lst.get(i);
            if (row == null) continue;
            for (int j = 0; j < row.size(); j++) {
                Integer val = row.get(j);
                if (val != null && val == x) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        Collections.sort(result, (a, b) -> {
            int ra = a.get(0), rb = b.get(0);
            if (ra != rb) return Integer.compare(ra, rb);
            return Integer.compare(b.get(1), a.get(1));
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