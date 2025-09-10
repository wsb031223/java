import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string, find out how many distinct characters (regardless of case) does it consist of
    >>> countDistinctCharacters("xyzXYZ")
    3
    >>> countDistinctCharacters("Jerry")
    4
     */
    public int countDistinctCharacters(String string) {
        // Let's think step by step
        // Input: string, a String
        // Output: count, an integer representing number of distinct characters (case-insensitive)
        // 1. Convert the string to lowercase to make it case-insensitive
        // 2. Create a Set to store distinct characters (Set automatically handles uniqueness)
        // 3. Loop through each character in the string
        // 4. Add each character to the Set
        // 5. Return the size of the Set
        // Write your code here
        String lowerCaseString = string.toLowerCase();
        Set<Character> distinctChars = new HashSet<>();
        for (char c : lowerCaseString.toCharArray()) {
            distinctChars.add(c);
        }
        return distinctChars.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.countDistinctCharacters("") == 0,
                s.countDistinctCharacters("abcde") == 5,
                s.countDistinctCharacters("abcde" + "cade" + "CADE") == 5,
                s.countDistinctCharacters("aaaaAAAAaaaa") == 1,
                s.countDistinctCharacters("Jerry jERRY JeRRRY") == 5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}