import java.util.*;
import java.lang.*;

class Solution {
    /**
    Find how many times a given substring can be found in the original string. Count overlaping cases.
    >>> howManyTimes("", "a")
    0
    >>> howManyTimes("aaa", "a")
    3
    >>> howManyTimes("aaaa", "aa")
    3
     */
    public int howManyTimes(String string, String substring) {
        // Let's think step by step
        // Input: string, substring
        // Output: integer count
        // Sequential structure:
        // 1. Prepare lengths and initial count.
        // Branch structure:
        // 2. If string or substring is null, return 0.
        // 3. If substring length is 0, return 0.
        // 4. If substring length > string length, return 0.
        // Loop structure:
        // 5. Iterate over all possible starting indices and compare; count overlaps.
        // 6. Return the count.
        // Write your code here
        if (string == null || substring == null) {
            return 0;
        }
        int n = string.length();
        int m = substring.length();
        if (m == 0) {
            return 0;
        }
        if (m > n) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= n - m; i++) {
            if (string.startsWith(substring, i)) {
                count++;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.howManyTimes("", "x") == 0,
                s.howManyTimes("xyxyxyx", "x") == 4,
                s.howManyTimes("cacacacac", "cac") == 4,
                s.howManyTimes("john doe", "john") == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}