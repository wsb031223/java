import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input are two strings a and b consisting only of 1s and 0s.
    Perform binary XOR on these inputs and return result also as a string.
    >>> stringXor("010", "110")
    "100"
     */
    public String stringXor(String a, String b) {
        // Let's think step by step
        // Input: two binary strings a and b
        // Output: a binary string representing their bitwise XOR
        // Sequential steps:
        // 1) Normalize lengths by left-padding the shorter string with '0's.
        // 2) Initialize a StringBuilder for the result.
        // Loop + Branch:
        // 3) For each index i from 0 to length-1:
        //    - If a[i] == b[i], append '0' to result; else append '1'.
        // 4) Return the result string.

        // 1) Normalize lengths (sequential + branch + loop)
        int lenA = a.length();
        int lenB = b.length();
        if (lenA < lenB) { // branch
            int diff = lenB - lenA;
            StringBuilder pad = new StringBuilder();
            for (int i = 0; i < diff; i++) { // loop
                pad.append('0');
            }
            a = pad.append(a).toString();
        } else if (lenB < lenA) { // branch
            int diff = lenA - lenB;
            StringBuilder pad = new StringBuilder();
            for (int i = 0; i < diff; i++) { // loop
                pad.append('0');
            }
            b = pad.append(b).toString();
        }

        // 2) Initialize result (sequential)
        int n = a.length(); // now equal to b.length()
        StringBuilder result = new StringBuilder(n);

        // 3) Compute XOR (loop + branch)
        for (int i = 0; i < n; i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (ca == cb) { // branch
                result.append('0');
            } else {
                result.append('1');
            }
        }

        // 4) Return result (sequential)
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.stringXor("111000", "101010"), "010010"),
                Objects.equals(s.stringXor("1", "1"), "0"),
                Objects.equals(s.stringXor("0101", "0000"), "0101")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}