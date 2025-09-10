import java.util.*;
import java.lang.*;

class Solution {
    /**
    Your task is to write a function that returns true if a number x is a simple
    power of n and false in other cases.
    x is a simple power of n if n**int=x
    For example:
    isSimplePower(1, 4) => true
    isSimplePower(2, 2) => true
    isSimplePower(8, 2) => true
    isSimplePower(3, 2) => false
    isSimplePower(3, 1) => false
    isSimplePower(5, 3) => false
     */
    public boolean isSimplePower(int x, int n) {
        // Let's think step by step
        // Input: x and n as integers
        // Output: true if exists integer k >= 0 such that n^k == x, else false
        // Sequential structure:
        // 1) Handle straightforward edge cases for n and x (0, 1, -1).
        // 2) For the general case, iteratively reduce x by dividing by n.
        // Branch structure:
        // - If x == 1 -> true (n^0 = 1)
        // - If n == 1 -> true only when x == 1
        // - If n == 0 -> true only when x == 0 (since 0^k = 0 for k>=1)
        // - If n == -1 -> true when x is 1 or -1
        // - If x == 0 and n != 0 -> false
        // - If x < 0 and n > 0 -> false (no positive base power yields negative)
        // Loop structure:
        // - While x is divisible by n, divide x by n.
        // - After the loop, if x reduced to 1, then it is a simple power.

        // Edge cases
        if (x == 1) return true;
        if (n == 1) return x == 1;
        if (n == 0) return x == 0;
        if (n == -1) return x == 1 || x == -1;
        if (x == 0) return false;
        if (x < 0 && n > 0) return false;

        // Iteratively divide x by n
        while (x % n == 0) {
            x /= n;
            if (x == 1) return true;
        }
        return x == 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isSimplePower(1, 4),
                s.isSimplePower(2, 2),
                s.isSimplePower(8, 2),
                !s.isSimplePower(3, 2),
                !s.isSimplePower(3, 1),
                !s.isSimplePower(5, 3),
                s.isSimplePower(16, 2),
                !s.isSimplePower(143214, 16),
                s.isSimplePower(4, 2),
                s.isSimplePower(9, 3),
                s.isSimplePower(16, 4),
                !s.isSimplePower(24, 2),
                !s.isSimplePower(128, 4),
                !s.isSimplePower(12, 6),
                s.isSimplePower(1, 1),
                s.isSimplePower(1, 12)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}