import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that accepts a list of strings as a parameter,
    deletes the strings that have odd lengths from it,
    and returns the resulted list with a sorted order,
    The list is always a list of strings and never an array of numbers,
    and it may contain duplicates.
    The order of the list should be ascending by length of each word, and you
    should return the list sorted by that rule.
    If two words have the same length, sort the list alphabetically.
    The function should return a list of strings in sorted order.
    You may assume that all words will have the same length.
    For example:
    assert listSort(Arrays.asList("aa", "a", "aaa")) => ["aa"]
    assert listSort(Arrays.asList("ab", "a", "aaa", "cd")) => ["ab", "cd"]
     */
    public List<String> listSort(List<String> lst) {
        // Let's think step by step
        // Input: list of strings
        // Output: filtered and sorted list
        // 1. Create a new list to store strings with even lengths
        // 2. Iterate through each string in the input list
        // 3. For each string, check if its length is even
        // 4. If even, add it to the new list
        // 5. Sort the new list first by length (ascending), then alphabetically
        // 6. Return the sorted list
        
        List<String> result = new ArrayList<>();
        for (String str : lst) {
            if (str.length() % 2 == 0) {
                result.add(str);
            }
        }
        
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return Integer.compare(s1.length(), s2.length());
                } else {
                    return s1.compareTo(s2);
                }
            }
        });
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.listSort(new ArrayList<>(Arrays.asList("aa", "a", "aaa"))).equals(List.of("aa")),
                s.listSort(new ArrayList<>(Arrays.asList("school", "AI", "asdf", "b"))).equals(Arrays.asList("AI", "asdf", "school")),
                s.listSort(new ArrayList<>(Arrays.asList("d", "b", "c", "a"))).equals(List.of()),
                s.listSort(new ArrayList<>(Arrays.asList("d", "dcba", "abcd", "a"))).equals(Arrays.asList("abcd", "dcba")),
                s.listSort(new ArrayList<>(Arrays.asList("AI", "ai", "au"))).equals(Arrays.asList("AI", "ai", "au")),
                s.listSort(new ArrayList<>(Arrays.asList("a", "b", "b", "c", "c", "a"))).equals(List.of()),
                s.listSort(new ArrayList<>(Arrays.asList("aaaa", "bbbb", "dd", "cc"))).equals(Arrays.asList("cc", "dd", "aaaa", "bbbb"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}