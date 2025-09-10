import java.util.*;
import java.lang.*;

class Solution {
    /**
    The Fib4 number sequence is a sequence similar to the Fibbonacci sequnece that's defined as follows:
    fib4(0) -> 0
    fib4(1) -> 0
    fib4(2) -> 2
    fib4(3) -> 0
    fib4(n) -> fib4(n-1) + fib4(n-2) + fib4(n-3) + fib4(n-4).
    Please write a function to efficiently compute the n-th element of the fib4 number sequence.  Do not use recursion.
    >>> fib4(5)
    4
    >>> fib4(6)
    8
    >>> fib4(7)
    14
     */
    public int fib4(int n) {
        // Let's think step by step
        // Input: n, an integer
        // Output: fib4(n), an integer
        // 1. Handle base cases: n = 0, 1, 2, 3
        // 2. If n <= 3, return the corresponding base value
        // 3. For n >= 4, use a loop to iteratively compute fib4(n)
        // 4. Initialize variables for the last 4 values: a=0, b=0, c=2, d=0
        // 5. For i from 4 to n:
        // 6.   Calculate next = a + b + c + d
        // 7.   Shift values: a = b, b = c, c = d, d = next
        // 8. Return the final value (d)
        if (n == 0 || n == 1 || n == 3) return 0;
        if (n == 2) return 2;
        
        int a = 0, b = 0, c = 2, d = 0;
        for (int i = 4; i <= n; i++) {
            int next = a + b + c + d;
            a = b;
            b = c;
            c = d;
            d = next;
        }
        return d;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fib4(5) == 4,
                s.fib4(8) == 28,
                s.fib4(10) == 104,
                s.fib4(12) == 386
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}