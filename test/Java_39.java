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
        // Output: n-th Fibonacci number that is also prime
        // 1. Initialize variables for Fibonacci sequence
        // 2. Initialize counter for prime Fibonacci numbers found
        // 3. Loop through Fibonacci numbers until we find n prime ones
        // 4. For each Fibonacci number, check if it's prime
        // 5. If prime, increment counter
        // 6. When counter reaches n, return the current Fibonacci number
        
        if (n <= 0) return 0;
        if (n == 1) return 2;
        
        int count = 0;
        int a = 0, b = 1, c;
        
        while (count < n) {
            c = a + b;
            a = b;
            b = c;
            
            if (isPrime(c)) {
                count++;
                if (count == n) {
                    return c;
                }
            }
        }
        return -1; // Should not reach here
    }
    
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
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