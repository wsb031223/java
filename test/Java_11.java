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
        // Output: XOR result as a string
        // 1. Check if strings have different lengths, handle by padding with zeros if needed
        // 2. Initialize an empty StringBuilder for result
        // 3. Loop through each character position from left to right
        // 4. For each position, compare characters from both strings
        // 5. If characters are different, append '1' to result
        // 6. If characters are same, append '0' to result
        // 7. Return the result string
        
        int maxLength = Math.max(a.length(), b.length());
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < maxLength; i++) {
            char charA = (i < a.length()) ? a.charAt(a.length() - 1 - i) : '0';
            char charB = (i < b.length()) ? b.charAt(b.length() - 1 - i) : '0';
            
            if (charA != charB) {
                result.insert(0, '1');
            } else {
                result.insert(0, '0');
            }
        }
        
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