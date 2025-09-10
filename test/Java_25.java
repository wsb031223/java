import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return list of prime factors of given integer in the order from smallest to largest.
    Each of the factors should be listed number of times corresponding to how many times it appeares in factorization.
    Input number should be equal to the product of all factors
    >>> factorize(8)
    [2, 2, 2]
    >>> factorize(25)
    [5, 5]
    >>> factorize(70)
    [2, 5, 7]
     */
    public List<Integer> factorize(int n) {
        // Let's think step by step
        // Input: n, an integer
        // Output: list of prime factors
        // 1. Initialize an empty list for factors
        // 2. Start with the smallest prime factor (2)
        // 3. While n is divisible by 2, add 2 to the list and divide n by 2
        // 4. Check for odd factors starting from 3
        // 5. While i*i <= n, if n is divisible by i, add i to list and divide n by i
        // 6. If n becomes a prime number greater than 2, add it to the list
        // 7. Return the list of factors
        List<Integer> factors = new ArrayList<>();
        int i = 2;
        while (n % i == 0) {
            factors.add(i);
            n /= i;
        }
        i = 3;
        while (i * i <= n) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
            i += 2;
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.factorize(2).equals(List.of(2)),
                s.factorize(4).equals(Arrays.asList(2, 2)),
                s.factorize(8).equals(Arrays.asList(2, 2, 2)),
                s.factorize(3 * 19).equals(Arrays.asList(3, 19)),
                s.factorize(3 * 19 * 3 * 19).equals(Arrays.asList(3, 3, 19, 19)),
                s.factorize(3 * 19 * 3 * 19 * 3 * 19).equals(Arrays.asList(3, 3, 3, 19, 19, 19)),
                s.factorize(3 * 19 * 19 * 19).equals(Arrays.asList(3, 19, 19, 19)),
                s.factorize(3 * 2 * 3).equals(Arrays.asList(2, 3, 3))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}