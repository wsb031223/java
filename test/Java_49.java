import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return 2^n modulo p (be aware of numerics).
    >>> modp(3, 5)
    3
    >>> modp(1101, 101)
    2
    >>> modp(0, 101)
    1
    >>> modp(3, 11)
    8
    >>> modp(100, 101)
    1
     */
    public int modp(int n, int p) {
        // Let's think step by step
        // Input: n (exponent), p (modulus)
        // Output: 2^n mod p
        // 1. If n is 0, return 1 (since 2^0 = 1)
        // 2. Initialize result to 1
        // 3. Use exponentiation by squaring to compute 2^n mod p efficiently
        // 4. While n > 0:
        //    - If n is odd, multiply result by 2 and take mod p
        //    - Square 2 and take mod p
        //    - Divide n by 2 (integer division)
        // 5. Return result
        
        if (n == 0) {
            return 1;
        }
        long result = 1;
        long base = 2;
        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * base) % p;
            }
            base = (base * base) % p;
            n = n / 2;
        }
        return (int) result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.modp(3, 5) == 3,
                s.modp(1101, 101) == 2,
                s.modp(0, 101) == 1,
                s.modp(3, 11) == 8,
                s.modp(100, 101) == 1,
                s.modp(30, 5) == 4,
                s.modp(31, 5) == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}