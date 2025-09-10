import java.util.*;
import java.lang.*;

class Solution {
    /**
    primeFib returns n-th number that is a Fibonacci number and it's also prime.
    >>> primeFib(1)
    2
    >>> primeFib(2)
    3
    >>> primeFib(3)
    5
    >>> primeFib(4)
    13
    >>> primeFib(5)
    89
     */
    public int primeFib(int n) {
        // Let's think step by step
        // Input: n, an integer
        // Output: the n-th Fibonacci number that is also prime
        // Sequential structure:
        // 1. Initialize Fibonacci seeds a = 0, b = 1 and a counter count = 0.
        // Loop structure:
        // 2. Repeatedly generate next Fibonacci number c = a + b.
        //    Update a = b, b = c for next iteration.
        // Branch structure:
        // 3. If c is prime, increment count.
        // 4. If count == n, return c.
        // 5. Continue looping until result is found or overflow occurs.

        if (n <= 0) {
            return -1;
        }

        int a = 0, b = 1;
        int count = 0;

        while (true) {
            int c = a + b;
            a = b;
            b = c;

            if (c > 1 && isPrime(c)) {
                count++;
                if (count == n) {
                    return c;
                }
            }

            // Prevent infinite loop in case of integer overflow
            if (c <= 0) {
                break;
            }
        }

        return -1;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; (long) i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.primeFib(1) == 2,
                s.primeFib(2) == 3,
                s.primeFib(3) == 5,
                s.primeFib(4) == 13,
                s.primeFib(5) == 89,
                s.primeFib(6) == 233,
                s.primeFib(7) == 1597,
                s.primeFib(8) == 28657,
                s.primeFib(9) == 514229,
                s.primeFib(10) == 433494437
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}