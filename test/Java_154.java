import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given 2 words. You need to return true if the second word or any of its rotations is a substring in the first word
    cycpatternCheck("abcd","abd") => false
    cycpatternCheck("hello","ell") => true
    cycpatternCheck("whassup","psus") => false
    cycpatternCheck("abab","baa") => true
    cycpatternCheck("efef","eeff") => false
    cycpatternCheck("himenss","simen") => true
     */
    public boolean cycpatternCheck(String a, String b) {
        // Let's think step by step
        // Input: a, b - strings
        // Output: boolean indicating if b or any rotation of b is a substring of a
        // Sequential steps:
        // 1. Handle null and trivial cases.
        // 2. If b is empty, return true (empty string is a substring of any string).
        // 3. If b is longer than a, it cannot be a substring; return false.
        // Loop structure:
        // 4. For each rotation index i from 0 to b.length()-1:
        //    - Construct the rotation: rot = b.substring(i) + b.substring(0, i)
        // Branch structure:
        //    - If a contains rot, return true immediately.
        // 5. After checking all rotations, return false.

        if (a == null || b == null) return false;
        int n = a.length();
        int m = b.length();
        if (m == 0) return true;
        if (m > n) return false;

        for (int i = 0; i < m; i++) {
            String rot = b.substring(i) + b.substring(0, i);
            if (a.contains(rot)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.cycpatternCheck("xyzw", "xyw") == false,
                s.cycpatternCheck("yello", "ell") == true,
                s.cycpatternCheck("whattup", "ptut") == false,
                s.cycpatternCheck("efef", "fee") == true,
                s.cycpatternCheck("abab", "aabb") == false,
                s.cycpatternCheck("winemtt", "tinem") == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}