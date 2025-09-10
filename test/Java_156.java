import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer, obtain its roman numeral equivalent as a string,
    and return it in lowercase.
    Restrictions: 1 <= num <= 1000

    Examples:
    >>> intToMiniRoman(19) == "xix"
    >>> intToMiniRoman(152) == "clii"
    >>> intToMiniRoman(426) == "cdxxvi"
     */
    public String intToMiniRoman(int number) {
        // Let's think step by step
        // Input: number, an integer between 1 and 1000
        // Output: roman numeral string in lowercase
        // 1. Create arrays for roman numeral symbols and their corresponding values
        // 2. Initialize a StringBuilder to build the result
        // 3. Iterate through the values from largest to smallest
        // 4. While the current number is >= current value, subtract the value and append the symbol
        // 5. Return the result converted to lowercase
        
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                result.append(romans[i]);
            }
        }
        
        return result.toString().toLowerCase();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.intToMiniRoman(19), "xix"),
                Objects.equals(s.intToMiniRoman(152), "clii"),
                Objects.equals(s.intToMiniRoman(251), "ccli"),
                Objects.equals(s.intToMiniRoman(426), "cdxxvi"),
                Objects.equals(s.intToMiniRoman(500), "d"),
                Objects.equals(s.intToMiniRoman(1), "i"),
                Objects.equals(s.intToMiniRoman(4), "iv"),
                Objects.equals(s.intToMiniRoman(43), "xliii"),
                Objects.equals(s.intToMiniRoman(90), "xc"),
                Objects.equals(s.intToMiniRoman(94), "xciv"),
                Objects.equals(s.intToMiniRoman(532), "dxxxii"),
                Objects.equals(s.intToMiniRoman(900), "cm"),
                Objects.equals(s.intToMiniRoman(994), "cmxciv"),
                Objects.equals(s.intToMiniRoman(1000), "m")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}