import java.util.*;
import java.lang.*;

class Solution {
    /**
    This function takes a list l and returns a list l' such that
    l' is identical to l in the indicies that are not divisible by three, while its values at the indicies that are divisible by three are equal
    to the values of the corresponding indicies of l, but sorted.
    >>> sortThird(Arrays.asList(1, 2, 3))
    [1, 2, 3]
    >>> sortThird(Arrays.asList(5, 6, 3, 4, 8, 9, 2))
    [2, 6, 3, 4, 8, 9, 5]
     */
    public List<Integer> sortThird(List<Integer> l) {
        // Let's think step by step
        // Input: l, a List<Integer>
        // Output: a new List<Integer> where elements at indices divisible by 3 are sorted ascending,
        //         while elements at other indices remain in their original positions.
        //
        // Sequential structure:
        // 1. Handle trivial cases (null or size <= 1).
        // 2. Create a mutable copy of the input list to build the result.
        // 3. Collect indices i where i % 3 == 0 and their corresponding values from l.
        // 4. Sort the collected values.
        // 5. Place the sorted values back into the copied list at the collected indices.
        //
        // Branch structure:
        // - If l is null, return null.
        // - If l has length 0 or 1, simply return a copy (already "sorted").
        //
        // Loop structure:
        // - Loop over indices to collect values at indices divisible by 3.
        // - Loop over the collected indices to put sorted values back.

        // Branch: handle null or very small list
        if (l == null) {
            return null;
        }
        if (l.size() <= 1) {
            return new ArrayList<>(l);
        }

        // Sequential: create a mutable copy for the result
        List<Integer> result = new ArrayList<>(l);

        // Loop: collect indices divisible by 3 and their corresponding values
        List<Integer> indices = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (i % 3 == 0) { // Branch: check divisibility by 3
                indices.add(i);
                values.add(l.get(i));
            }
        }

        // Sequential: sort the collected values
        Collections.sort(values);

        // Loop: place sorted values back into their respective positions
        for (int j = 0; j < indices.size(); j++) {
            result.set(indices.get(j), values.get(j));
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sortThird(new ArrayList<>(Arrays.asList(5, 6, 3, 4, 8, 9, 2))).equals(Arrays.asList(2, 6, 3, 4, 8, 9, 5)),
                s.sortThird(new ArrayList<>(Arrays.asList(5, 8, 3, 4, 6, 9, 2))).equals(Arrays.asList(2, 8, 3, 4, 6, 9, 5)),
                s.sortThird(new ArrayList<>(Arrays.asList(5, 6, 9, 4, 8, 3, 2))).equals(Arrays.asList(2, 6, 9, 4, 8, 3, 5)),
                s.sortThird(new ArrayList<>(Arrays.asList(5, 6, 3, 4, 8, 9, 2, 1))).equals(Arrays.asList(2, 6, 3, 4, 8, 9, 5, 1))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}