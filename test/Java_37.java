import java.util.*;
import java.lang.*;

class Solution {
    /**
    This function takes a list l and returns a list l' such that
    l' is identical to l in the odd indicies, while its values at the even indicies are equal
    to the values of the even indicies of l, but sorted.
    >>> sortEven(Arrays.asList(1, 2, 3))
    [1, 2, 3]
    >>> sortEven(Arrays.asList(5, 6, 3, 4))
    [3, 6, 5, 4]
     */
    public List<Integer> sortEven(List<Integer> l) {
        // Let's think step by step
        // Input: l, a list of integers
        // Output: a new list l' meeting the specification
        // Sequential structure:
        // 1. Handle edge cases and prepare a mutable copy of the list.
        // 2. Collect elements at even indices into a separate list.
        // 3. Sort that list in non-decreasing order.
        // 4. Place the sorted even-index elements back into their original even positions.
        // Branch structure:
        // - If the input list is null or has fewer than 2 elements, simply return a copy as is.
        // Loop structure:
        // - Use loops to collect even-indexed elements and to write them back after sorting.

        // Write your code here
        if (l == null) {
            return null;
        }
        int n = l.size();
        if (n <= 1) {
            return new ArrayList<>(l);
        }

        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            evens.add(l.get(i));
        }

        Collections.sort(evens);

        List<Integer> result = new ArrayList<>(l);

        int idx = 0;
        for (int i = 0; i < n; i += 2) {
            result.set(i, evens.get(idx));
            idx++;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortEven(new ArrayList<>(Arrays.asList(1, 2, 3))).equals(Arrays.asList(1, 2, 3)),
                s.sortEven(new ArrayList<>(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10))).equals(Arrays.asList(-10, 3, -5, 2, -3, 3, 5, 0, 9, 1, 123)),
                s.sortEven(new ArrayList<>(Arrays.asList(5, 8, -12, 4, 23, 2, 3, 11, 12, -10))).equals(Arrays.asList(-12, 8, 3, 4, 5, 2, 12, 11, 23, -10))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}