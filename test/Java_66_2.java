import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes a string as input and returns the sum of the upper characters only'
    ASCII codes.

    Examples:
        digitSum("") => 0
        digitSum("abAB") => 131
        digitSum("abcCd") => 67
        digitSum("helloE") => 69
        digitSum("woArBld") => 131
        digitSum("aAaaaXa") => 153
     */
    public int digitSum(String s) {
        // Let's think step by step
        // Input: s, a string
        // Output: sum, an integer
        // 1. Initialize sum to 0. (sequential)
        // 2. If s is null or empty, return 0. (branch)
        // 3. Loop through each character in s: (loop)
        //    - If the character is an uppercase letter 'A' to 'Z', add its ASCII value to sum. (branch)
        // 4. Return sum. (sequential)
        int sum = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sum += (int) c;
            }
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.digitSum("") == 0,
                s.digitSum("abAB") == 131,
                s.digitSum("abcCd") == 67,
                s.digitSum("helloE") == 69,
                s.digitSum("woArBld") == 131,
                s.digitSum("aAaaaXa") == 153,
                s.digitSum(" How are yOu?") == 151,
                s.digitSum("You arE Very Smart") == 327
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}