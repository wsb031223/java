import java.util.*;
import java.lang.*;

class Solution {
    /**
    Task
    We are given two strings s and c, you have to deleted all the characters in s that are equal to any character in c
    then check if the result string is palindrome.
    A string is called palindrome if it reads the same backward as forward.
    You should return a tuple containing the result string and true/false for the check.
    Example
    For s = "abcde", c = "ae", the result should be ("bcd",false)
    For s = "abcdef", c = "b"  the result should be ("acdef",false)
    For s = "abcdedcba", c = "ab", the result should be ("cdedc",true)
     */
    public List<Object> reverseDelete(String s, String c) {
        // Let's think step by step
        // Input: s, c - strings
        // Output: [filteredString, isPalindrome]
        // Sequential steps:
        // 1) Create a set of characters from c to delete.
        // 2) Build the filtered string by scanning s.
        // 3) Check if the filtered string is a palindrome.
        // Branching:
        // - If current character should be deleted, skip appending; else append.
        // - While checking palindrome, if mismatch found, decide result as false.
        // Looping:
        // - Loop over characters of c to fill the set.
        // - Loop over characters of s to build filtered string.
        // - Loop with two pointers to verify palindrome.

        // Write your code here
        Set<Character> del = new HashSet<>();
        for (int i = 0; i < c.length(); i++) {
            del.add(c.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!del.contains(ch)) { // branch
                sb.append(ch);
            }
        }

        String filtered = sb.toString();

        boolean isPal = true;
        int l = 0, r = filtered.length() - 1;
        while (l < r) { // loop
            if (filtered.charAt(l) != filtered.charAt(r)) { // branch
                isPal = false;
                break;
            }
            l++;
            r--;
        }

        List<Object> res = new ArrayList<>();
        res.add(filtered);
        res.add(isPal);
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.reverseDelete("abcde", "ae" ).equals(Arrays.asList("bcd", false)),
                s.reverseDelete("abcdef", "b" ).equals(Arrays.asList("acdef", false)),
                s.reverseDelete("abcdedcba", "ab" ).equals(Arrays.asList("cdedc", true)),
                s.reverseDelete("dwik", "w" ).equals(Arrays.asList("dik", false)),
                s.reverseDelete("a", "a" ).equals(Arrays.asList("", true)),
                s.reverseDelete("abcdedcba", "" ).equals(Arrays.asList("abcdedcba", true)),
                s.reverseDelete("abcdedcba", "v" ).equals(Arrays.asList("abcdedcba", true)),
                s.reverseDelete("vabba", "v" ).equals(Arrays.asList("abba", true)),
                s.reverseDelete("mamma", "mia" ).equals(Arrays.asList("", true))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}