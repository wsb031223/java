import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given an array arr of integers and you need to return
    sum of magnitudes of integers multiplied by product of all signs
    of each number in the array, represented by 1, -1 or 0.
    Note: return None for empty arr.

    Example:
    >>> prodSigns(Arrays.asList(1, 2, 2, -4)) == -9
    >>> prodSigns(Arrays.asList(0, 1)) == 0
    >>> prodSigns(Arrays.asList()) == None
     */
    public Optional<Integer> prodSigns(List<Integer> arr) {
        // Let's think step by step
        // Input: arr, a list of integers
        // Output: Optional<Integer> result
        // Sequential:
        // 1. Initialize sumAbs = 0 and signProd = 1.
        // Branch:
        // 2. If arr is null or empty, return Optional.empty().
        // Loop:
        // 3. For each number x in arr:
        //    a. Add absolute value of x to sumAbs.
        //    b. Update signProd by multiplying with sign of x:
        //       - if x == 0 => sign is 0
        //       - else if x < 0 => sign is -1
        //       - else => sign is 1
        // Sequential:
        // 4. Compute result = sumAbs * signProd.
        // 5. Return Optional.of(result).

        if (arr == null || arr.isEmpty()) {
            return Optional.empty();
        }

        int sumAbs = 0;
        int signProd = 1;

        for (Integer x : arr) {
            // Assuming non-null elements as per typical constraints
            sumAbs += Math.abs(x);
            if (x == 0) {
                signProd = 0;
            } else if (x < 0) {
                signProd *= -1;
            } else {
                // x > 0 => multiply by 1 (no change)
            }
        }

        int result = sumAbs * signProd;
        return Optional.of(result);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.prodSigns(Arrays.asList(1, 2, 2, -4)).get() == -9,
                s.prodSigns(Arrays.asList(0, 1)).get() == 0,
                s.prodSigns(Arrays.asList(1, 1, 1, 2, 3, -1, 1)).get() == -10,
                s.prodSigns(List.of()).isEmpty(),
                s.prodSigns(Arrays.asList(2, 4,1, 2, -1, -1, 9)).get() == 20,
                s.prodSigns(Arrays.asList(-1, 1, -1, 1)).get() == 4,
                s.prodSigns(Arrays.asList(-1, 1, 1, 1)).get() == -4,
                s.prodSigns(Arrays.asList(-1, 1, 1, 0)).get() == 0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}