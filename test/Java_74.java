import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that accepts two lists of strings and returns the list that has
    total number of chars in the all strings of the list less than the other list.

    if the two lists have the same number of chars, return the first list.

    Examples
    totalMatch(Arrays.asList(), Arrays.asList()) -> []
    totalMatch(Arrays.asList("hi", "admin"), Arrays.asList("hI", "Hi")) -> ["hI", "Hi"]
    totalMatch(Arrays.asList("hi", "admin"), Arrays.asList("hi", "hi", "admin", "project")) -> ["hi", "admin"]
    totalMatch(Arrays.asList("hi", "admin"), Arrays.asList("hI", "hi", "hi")) -> ["hI", "hi", "hi"]
    totalMatch(Arrays.asList("4"), Arrays.asList("1", "2", "3", "4", "5")) -> ["4"]
     */
    public List<String> totalMatch(List<String> lst1, List<String> lst2) {
        // Let's think step by step
        // Input: lst1, lst2 - two lists of strings
        // Output: the list whose total character count is less; if equal, return lst1
        // Sequential: initialize sums and handle potential null lists
        if (lst1 == null) lst1 = Collections.emptyList();
        if (lst2 == null) lst2 = Collections.emptyList();
        int sum1 = 0;
        int sum2 = 0;
        // Loop: accumulate total lengths of strings in each list
        for (String s : lst1) {
            if (s != null) {
                sum1 += s.length();
            }
        }
        for (String s : lst2) {
            if (s != null) {
                sum2 += s.length();
            }
        }
        // Branch: compare totals and decide which list to return
        if (sum1 <= sum2) {
            return lst1;
        } else {
            return lst2;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.totalMatch(new ArrayList<>(List.of()), new ArrayList<>(List.of())).equals(List.of()),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hi", "hi"))).equals(Arrays.asList("hi", "hi")),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hi", "hi", "admin", "project"))).equals(Arrays.asList("hi", "admin")),
                s.totalMatch(new ArrayList<>(List.of("4")), new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"))).equals(List.of("4")),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hI", "Hi"))).equals(Arrays.asList("hI", "Hi")),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hI", "hi", "hi"))).equals(Arrays.asList("hI", "hi", "hi")),
                s.totalMatch(new ArrayList<>(Arrays.asList("hi", "admin")), new ArrayList<>(Arrays.asList("hI", "hi", "hii"))).equals(Arrays.asList("hi", "admin")),
                s.totalMatch(new ArrayList<>(List.of()), new ArrayList<>(List.of("this"))).equals(List.of()),
                s.totalMatch(new ArrayList<>(List.of("this")), new ArrayList<>(List.of())).equals(List.of())
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}