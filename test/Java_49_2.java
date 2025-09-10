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
        // Input: n (exponent), p (modulus), both integers
        // Output: (2^n) mod p as an integer
        //
        // Sequential structure:
        // 1) Handle trivial cases:
        //    - If p == 1, answer is 0 (everything modulo 1 is 0).
        //    - If n == 0, answer is 1 % p.
        // 2) Initialize:
        //    - result = 1 (accumulator)
        //    - base = 2 % p
        //    - exp = n
        //
        // Loop structure:
        // 3) While exp > 0:
        //    - Branch structure:
        //      a) If current bit of exp is 1 (exp is odd), multiply result by base modulo p.
        //    - Square the base modulo p.
        //    - Shift exp right by 1 (divide by 2).
        //
        // 4) Return result as int.
        //
        // Be aware of numerics: use long to avoid overflow during multiplication before modulo.

        if (p == 1) {
            return 0;
        }
        if (n == 0) {
            return 1 % p;
        }

        long mod = p;             // promote to long for safe arithmetic
        long result = 1L;
        long base = 2L % mod;
        int exp = n;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return (int) (result % mod);
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