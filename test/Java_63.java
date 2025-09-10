import java.util.*;
import java.lang.*;

class Solution {
    /**
    The FibFib number sequence is a sequence similar to the Fibbonacci sequnece that's defined as follows:
    fibfib(0) == 0
    fibfib(1) == 0
    fibfib(2) == 1
    fibfib(n) == fibfib(n-1) + fibfib(n-2) + fibfib(n-3).
    Please write a function to efficiently compute the n-th element of the fibfib number sequence.
    >>> fibfib(1)
    0
    >>> fibfib(5)
    4
    >>> fibfib(8)
    24
     */
    public int fibfib(int n) {
        // Let's think step by step
        // Input: n, an integer
        // Output: fibfib(n), an integer
        // 1. Handle base cases: n=0, n=1, n=2
        // 2. For n >= 3, use dynamic programming to avoid recursion
        // 3. Initialize variables for the first three values
        // 4. Use a loop to calculate fibfib(n) iteratively
        // 5. Return the result
        
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        
        int a = 0, b = 0, c = 1;
        int result = 0;
        
        for (int i = 3; i <= n; i++) {
            result = a + b + c;
            a = b;
            b = c;
            c = result;
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fibfib(2) == 1,
                s.fibfib(1) == 0,
                s.fibfib(5) == 4,
                s.fibfib(8) == 24,
                s.fibfib(10) == 81,
                s.fibfib(12) == 274,
                s.fibfib(14) == 927
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}