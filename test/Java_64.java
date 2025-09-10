import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function vowelsCount which takes a string representing
    a word as input and returns the number of vowels in the string.
    Vowels in this case are 'a', 'e', 'i', 'o', 'u'. Here, 'y' is also a
    vowel, but only when it is at the end of the given word.

    Example:
    >>> vowelsCount("abcde")
    2
    >>> vowelsCount("ACEDY")
    3
     */
    public int vowelsCount(String s) {
        // Let's think step by step
        // Input: s, a string
        // Output: count, an integer
        // 1. Convert the string to lowercase for case-insensitive comparison
        // 2. Initialize a counter variable to 0
        // 3. Loop through each character in the string (sequential + loop)
        // 4. For each character, check if it's a standard vowel (branch)
        // 5. If the character is 'y' and it's at the end of the string, count it as vowel (branch)
        // 6. Return the total count
        
        String lowerS = s.toLowerCase();
        int count = 0;
        int length = lowerS.length();
        
        for (int i = 0; i < length; i++) {
            char c = lowerS.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            } else if (c == 'y' && i == length - 1) {
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
                s.vowelsCount("abcde") == 2,
                s.vowelsCount("Alone") == 3,
                s.vowelsCount("key") == 2,
                s.vowelsCount("bye") == 1,
                s.vowelsCount("keY") == 2,
                s.vowelsCount("bYe") == 1,
                s.vowelsCount("ACEDY") == 3
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}