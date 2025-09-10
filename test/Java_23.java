import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return length of given string
    >>> strlen("")
    0
    >>> strlen("abc")
    3
     */
    public int strlen(String string) {
        // Let's think step by step
        // Input: string (String)
        // Output: length (int)
        // Sequential structure:
        // 1. Initialize a counter to 0.
        // 2. Prepare to traverse the characters of the string.
        // Branch structure:
        // - If string is null, return 0 (treat as empty).
        // - Otherwise, proceed to count characters.
        // Loop structure:
        // - For each character in the string, increment the counter by 1.
        // - After the loop finishes, return the counter.
        if (string == null) {
            return 0;
        }
        int count = 0;
        for (char c : string.toCharArray()) {
            count++;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.strlen("") == 0,
                s.strlen("x") == 1,
                s.strlen("asdasnakj") == 9
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}