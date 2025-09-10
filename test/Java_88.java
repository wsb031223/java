import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given an array of non-negative integers, return a copy of the given array after sorting,
    you will sort the given array in ascending order if the sum( first index value, last index value) is odd,
    or sort it in descending order if the sum( first index value, last index value) is even.

    Note:
    * don't change the given array.

    Examples:
    * sortArray(Arrays.asList()) => []
    * sortArray(Arrays.asList(5)) => [5]
    * sortArray(Arrays.asList(2, 4, 3, 0, 1, 5)) => [0, 1, 2, 3, 4, 5]
    * sortArray(Arrays.asList(2, 4, 3, 0, 1, 5, 6)) => [6, 5, 4, 3, 2, 1, 0]
     */
    public List<Integer> sortArray(List<Integer> array) {
        // Let's think step by step
        // Input: array, a List<Integer> of non-negative integers
        // Output: a new List<Integer> sorted per rule without modifying the original list
        // Sequential:
        // 1. If the input list is empty, return a new empty list.
        // 2. Create a new list "copy" and copy all elements from "array" using a loop (to avoid modifying the original).
        // 3. If the list has size 0 or 1, return the copy as-is.
        // Branch:
        // 4. Read the first and last values of the original list.
        // 5. Determine if the sum is odd by comparing parity bits (avoids overflow): odd iff one is odd and the other is even.
        // 6. If odd, sort ascending; else, sort descending.
        // Loop:
        // - Use a for-each loop to copy elements from the input list into the new list.
        // 7. Return the sorted copy.

        if (array == null || array.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> copy = new ArrayList<>(array.size());
        for (Integer v : array) { // loop structure for copying
            copy.add(v);
        }

        if (copy.size() <= 1) { // branch for trivial sizes
            return copy;
        }

        int first = array.get(0);
        int last = array.get(array.size() - 1);

        // sum is odd iff the parity of first and last differs
        boolean oddSum = ((first & 1) != (last & 1));

        if (oddSum) { // branch: ascending if odd
            Collections.sort(copy);
        } else { // descending if even
            copy.sort(Collections.reverseOrder());
        }

        return copy;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortArray(new ArrayList<>(List.of())).equals(List.of()),
                s.sortArray(new ArrayList<>(List.of(5))).equals(List.of(5)),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 4, 3, 0, 1, 5))).equals(Arrays.asList(0, 1, 2, 3, 4, 5)),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 4, 3, 0, 1, 5, 6))).equals(Arrays.asList(6, 5, 4, 3, 2, 1, 0)),
                s.sortArray(new ArrayList<>(Arrays.asList(2, 1))).equals(Arrays.asList(1, 2)),
                s.sortArray(new ArrayList<>(Arrays.asList(15, 42, 87, 32 ,11, 0))).equals(Arrays.asList(0, 11, 15, 32, 42, 87)),
                s.sortArray(new ArrayList<>(Arrays.asList(21, 14, 23, 11))).equals(Arrays.asList(23, 21, 14, 11))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}