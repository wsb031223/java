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
        // 1. Count the number of digits in the file name
        // 2. Check if there is exactly one dot in the file name
        // 3. Split the file name into name and extension parts
        // 4. Check if the name part is not empty and starts with a letter
        // 5. Check if the extension is one of the allowed values
        // 6. Return "Yes" if all conditions are met, otherwise "No"
        
        int digitCount = 0;
        for (char c : file_name.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        if (digitCount > 3) {
            return "No";
        }
        
        int dotCount = 0;
        for (char c : file_name.toCharArray()) {
            if (c == '.') {
                dotCount++;
            }
        }
        if (dotCount != 1) {
            return "No";
        }
        
        String[] parts = file_name.split("\\.");
        if (parts.length != 2) {
            return "No";
        }
        
        String namePart = parts[0];
        String extension = parts[1];
        
        if (namePart.isEmpty()) {
            return "No";
        }
        
        char firstChar = namePart.charAt(0);
        if (!Character.isLetter(firstChar)) {
            return "No";
        }
        
        if (!extension.equals("txt") && !extension.equals("exe") && !extension.equals("dll")) {
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