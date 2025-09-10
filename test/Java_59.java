import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return the largest prime factor of n. Assume n > 1 and is not a prime.
    >>> largestPrimeFactor(13195)
    29
    >>> largestPrimeFactor(2048)
    2
     */
    public int largestPrimeFactor(int n) {
        // Let's think step by step
        // Input: n, an integer greater than 1 and not prime
        // Output: largest prime factor of n
        // 1. Initialize a variable to store the largest prime factor
        // 2. Start with the smallest prime factor (2)
        // 3. While n is divisible by 2, divide n by 2 and update largest factor
        // 4. Check for odd factors starting from 3
        // 5. While i*i <= n, if n is divisible by i, divide n by i and update largest factor
        // 6. If n becomes a prime number greater than 2, it's the largest factor
        // 7. Return the largest prime factor
        
        int largest = -1;
        
        // Handle factor 2
        while (n % 2 == 0) {
            largest = 2;
            n /= 2;
        }
        
        // Handle odd factors
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                largest = i;
                n /= i;
            }
        }
        
        // If remaining n is a prime number greater than 2
        if (n > 2) {
            largest = n;
        }
        
        return largest;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.largestPrimeFactor(15) == 5,
                s.largestPrimeFactor(27) == 3,
                s.largestPrimeFactor(63) == 7,
                s.largestPrimeFactor(330) == 11,
                s.largestPrimeFactor(13195) == 29
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}