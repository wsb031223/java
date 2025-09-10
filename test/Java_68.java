import java.util.*;
import java.lang.*;

class Solution {
    /**
    "Given an array representing a branch of a tree that has non-negative integer nodes
    your task is to pluck one of the nodes and return it.
    The plucked node should be the node with the smallest even value.
    If multiple nodes with the same smallest even value are found return the node that has smallest index.

    The plucked node should be returned in a list, [ smalest_value, its index ],
    If there are no even values or the given array is empty, return [].

    Example 1:
        Input: [4,2,3]
        Output: [2, 1]
        Explanation: 2 has the smallest even value, and 2 has the smallest index.

    Example 2:
        Input: [1,2,3]
        Output: [2, 1]
        Explanation: 2 has the smallest even value, and 2 has the smallest index.

    Example 3:
        Input: []
        Output: []

    Example 4:
        Input: [5, 0, 3, 0, 4, 2]
        Output: [0, 1]
        Explanation: 0 is the smallest value, but  there are two zeros,
                     so we will choose the first zero, which has the smallest index.

    Constraints:
        * 1 <= nodes.length <= 10000
        * 0 <= node.value
     */
    public List<Integer> pluck(List<Integer> arr) {
        // Let's think step by step
        // Input: arr, a list of non-negative integers
        // Output: a list [smallest_even_value, its index] or [] if none exists
        // Sequential structure:
        // 1. If arr is null or empty, return [].
        // 2. Initialize minVal to +infinity (Integer.MAX_VALUE) and minIdx to -1.
        // Loop structure:
        // 3. For i from 0 to arr.size()-1:
        //    a. Read val = arr.get(i).
        // Branch structure:
        //    b. If val is even (val % 2 == 0):
        //       i. If val < minVal, update minVal = val and minIdx = i.
        // Branch structure:
        // 4. After the loop, if minIdx == -1, return [] (no even values found).
        // 5. Else return [minVal, minIdx].

        if (arr == null || arr.isEmpty()) {
            return new ArrayList<>();
        }

        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            if (val % 2 == 0) {
                if (val < minVal) {
                    minVal = val;
                    minIdx = i;
                }
            }
        }

        if (minIdx == -1) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>(2);
        result.add(minVal);
        result.add(minIdx);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.pluck(new ArrayList<>(Arrays.asList(4, 2, 3))).equals(Arrays.asList(2, 1)),
                s.pluck(new ArrayList<>(Arrays.asList(1, 2, 3))).equals(Arrays.asList(2, 1)),
                s.pluck(new ArrayList<>(List.of())).equals(List.of()),
                s.pluck(new ArrayList<>(Arrays.asList(5, 0, 3, 0, 4, 2))).equals(Arrays.asList(0, 1)),
                s.pluck(new ArrayList<>(Arrays.asList(1, 2, 3, 0, 5, 3))).equals(Arrays.asList(0, 3)),
                s.pluck(new ArrayList<>(Arrays.asList(5, 4, 8, 4, 8))).equals(Arrays.asList(4, 1)),
                s.pluck(new ArrayList<>(Arrays.asList(7, 6, 7, 1))).equals(Arrays.asList(6, 1)),
                s.pluck(new ArrayList<>(Arrays.asList(7, 9, 7, 1))).equals(List.of())
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}