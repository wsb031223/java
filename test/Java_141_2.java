import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function which takes a string representing a file's name, and returns
    "Yes" if the the file's name is valid, and returns "No" otherwise.
    A file's name is considered to be valid if and only if all the following conditions
    are met:
    - There should not be more than three digits ('0'-'9') in the file's name.
    - The file's name contains exactly one dot '.'
    - The substring before the dot should not be empty, and it starts with a letter from
    the latin alphapet ('a'-'z' and 'A'-'Z').
    - The substring after the dot should be one of these: ["txt", "exe", "dll"]
    Examples:
    file_name_check("example.txt") # => "Yes"
    file_name_check("1example.dll") # => "No" (the name should start with a latin alphapet letter)
     */
    public String filenameCheck(String file_name) {
        // Let's think step by step
        // Input: file_name, a string
        // Output: "Yes" if valid, otherwise "No"
        // Sequential structure:
        // 1) Validate basic presence of the input string.
        // 2) Initialize counters for dots and digits.
        // Loop structure:
        // 3) Iterate over each character in file_name:
        //    - If it's a dot '.', increase dot counter.
        //    - If it's a digit '0'..'9', increase digit counter.
        // Branch structure:
        // 4) If there is not exactly one dot or there are more than three digits, return "No".
        // 5) Locate the dot and split into name and extension parts.
        // 6) If the name part is empty or its first character is not a latin letter [A-Za-z], return "No".
        // 7) If the extension is not one of {"txt", "exe", "dll"}, return "No".
        // 8) Otherwise, return "Yes".
        // Write your code here
        if (file_name == null || file_name.isEmpty()) {
            return "No";
        }
        int dotCount = 0;
        int digitCount = 0;
        for (int i = 0; i < file_name.length(); i++) {
            char ch = file_name.charAt(i);
            if (ch == '.') {
                dotCount++;
            } else if (ch >= '0' && ch <= '9') {
                digitCount++;
            }
        }
        if (dotCount != 1 || digitCount > 3) {
            return "No";
        }
        int dotIndex = file_name.indexOf('.');
        String name = file_name.substring(0, dotIndex);
        String ext = file_name.substring(dotIndex + 1);
        if (name.isEmpty()) {
            return "No";
        }
        char first = name.charAt(0);
        boolean isLatinLetter = (first >= 'a' && first <= 'z') || (first >= 'A' && first <= 'Z');
        if (!isLatinLetter) {
            return "No";
        }
        if (!(ext.equals("txt") || ext.equals("exe") || ext.equals("dll"))) {
            return "No";
        }
        return "Yes";
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.filenameCheck("example.txt" ), "Yes" ),
                Objects.equals(s.filenameCheck("1example.dll" ), "No" ),
                Objects.equals(s.filenameCheck("s1sdf3.asd" ), "No" ),
                Objects.equals(s.filenameCheck("K.dll" ), "Yes" ),
                Objects.equals(s.filenameCheck("MY16FILE3.exe" ), "Yes" ),
                Objects.equals(s.filenameCheck("His12FILE94.exe" ), "No" ),
                Objects.equals(s.filenameCheck("_Y.txt" ), "No" ),
                Objects.equals(s.filenameCheck("?aREYA.exe" ), "No" ),
                Objects.equals(s.filenameCheck("/this_is_valid.dll" ), "No" ),
                Objects.equals(s.filenameCheck("this_is_valid.wow" ), "No" ),
                Objects.equals(s.filenameCheck("this_is_valid.txt" ), "Yes" ),
                Objects.equals(s.filenameCheck("this_is_valid.txtexe" ), "No" ),
                Objects.equals(s.filenameCheck("#this2_i4s_5valid.ten" ), "No" ),
                Objects.equals(s.filenameCheck("@this1_is6_valid.exe" ), "No" ),
                Objects.equals(s.filenameCheck("this_is_12valid.6exe4.txt" ), "No" ),
                Objects.equals(s.filenameCheck("all.exe.txt" ), "No" ),
                Objects.equals(s.filenameCheck("I563_No.exe" ), "Yes" ),
                Objects.equals(s.filenameCheck("Is3youfault.txt" ), "Yes" ),
                Objects.equals(s.filenameCheck("no_one#knows.dll" ), "Yes" ),
                Objects.equals(s.filenameCheck("1I563_Yes3.exe" ), "No" ),
                Objects.equals(s.filenameCheck("I563_Yes3.txtt" ), "No" ),
                Objects.equals(s.filenameCheck("final..txt" ), "No" ),
                Objects.equals(s.filenameCheck("final132" ), "No" ),
                Objects.equals(s.filenameCheck("_f4indsartal132." ), "No" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}