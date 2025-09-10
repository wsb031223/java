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
        // Output: List<Integer> of prime factors in non-decreasing order
        // Sequential structure:
        // 1. Initialize an empty list "factors".
        // 2. If n < 2, return empty list (no prime factors).
        // 3. Repeatedly divide out factor 2 and append it to the list.
        // 4. For odd candidate factors from 3 up to sqrt(n), repeatedly divide them out and append.
        // 5. If after the loop n > 1, it is a prime factor; append it.
        // 6. Return the list "factors".
        // Branch structure:
        // - If n < 2, return immediately.
        // - If n % 2 == 0, handle factor 2.
        // - If at the end n > 1, append remaining n.
        // Loop structure:
        // - While loops to extract repeated factors.
        // - For loop to try odd candidate factors.
        List<Integer> factors = new ArrayList<>();
        if (n < 2) {
            return factors;
        }
        // Extract factor 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        // Extract odd factors up to sqrt(n)
        for (int f = 3; f <= n / f; f += 2) {
            while (n % f == 0) {
                factors.add(f);
                n /= f;
            }
        }
        // If remaining n is > 1, it is a prime factor
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