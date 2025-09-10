import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return a string containing space-delimited numbers starting from 0 upto n inclusive.
    >>> stringSequence(0)
    "0"
    >>> stringSequence(5)
    "0 1 2 3 4 5"
     */
    public String stringSequence(int n) {
        // Let's think step by step
        // Input: n, an integer
        // Output: string containing numbers from 0 to n separated by spaces
        // 1. Check if n is negative (edge case)
        // 2. Use a loop to iterate from 0 to n
        // 3. Append each number to a StringBuilder with a space
        // 4. Convert to string and trim any trailing space
        if (n < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.stringSequence(0).equals("0"),
                s.stringSequence(3).equals("0 1 2 3"),
                s.stringSequence(10).equals("0 1 2 3 4 5 6 7 8 9 10")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}