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
        // Input: n (integer > 1 and composite)
        // Output: largest prime factor (integer)
        // Sequential structure:
        // 1. Initialize a variable "largest" to track the current largest prime factor.
        // 2. Remove the factor 2 from n repeatedly and update "largest".
        // 3. Check odd factors starting from 3 up to sqrt(n); for each factor, divide it out completely and update "largest".
        // 4. If after removing all small factors n > 1, then n itself is a prime and is the largest factor.
        // Branch structure:
        // - If n is even, handle factor 2.
        // - If n is divisible by an odd i, divide it out.
        // - If leftover n > 1, update "largest".
        // Loop structure:
        // - While loop to strip factor 2.
        // - While loop over odd i where i*i <= n.
        // - Inner while loop to divide out each found factor completely.
        int largest = 1;

        // Remove factor 2
        while ((n & 1) == 0) {
            largest = 2;
            n >>= 1;
        }

        // Check odd factors
        int i = 3;
        while (i * i <= n) {
            if (n % i == 0) {
                largest = i;
                while (n % i == 0) {
                    n /= i;
                }
            }
            i += 2;
        }

        // If n is now a prime greater than 1, it's the largest prime factor
        if (n > 1) {
            if (n > largest) {
                largest = n;
            }
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