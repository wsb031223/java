import java.util.*;
import java.lang.*;

class Solution {
    /**
    The Brazilian factorial is defined as:
    brazilian_factorial(n) = n! * (n-1)! * (n-2)! * ... * 1!
    where n > 0

    For example:
    >>> specialFactorial(4)
    288

    The function will receive an integer as input and should return the special
    factorial of this integer.
     */
    public long specialFactorial(int n) {
        // Let's think step by step
        // Input: n, an integer
        // Output: the product of factorials from 1! to n!
        // Sequential structure:
        // 1) Initialize variables to hold the running factorial and the final result.
        // Branch structure:
        // 2) If n <= 0, return 1 (by convention, empty product equals 1).
        // Loop structure:
        // 3) For k from 1 to n:
        //    - Update running factorial: fact = fact * k
        //    - Multiply into result: result = result * fact
        // 4) Return result.

        long result = 1L;      // Holds the final brazilian factorial
        if (n <= 0) {          // Branch: handle non-positive input safely
            return 1L;
        }

        long fact = 1L;        // Running factorial k!
        for (int k = 1; k <= n; k++) {   // Loop: accumulate factorials and multiply into result
            fact *= k;         // Compute k!
            result *= fact;    // Multiply current factorial into the final product
        }

        return result;         // Sequential: return the accumulated result
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.specialFactorial(4) == 288,
                s.specialFactorial(5) == 34560,
                s.specialFactorial(7) == 125411328000L,
                s.specialFactorial(1) == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}