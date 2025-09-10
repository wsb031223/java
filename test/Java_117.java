import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a string s and a natural number n, you have been tasked to implement
    a function that returns a list of all words from string s that contain exactly
    n consonants, in order these words appear in the string s.
    If the string s is empty then the function should return an empty list.
    Note: you may assume the input string contains only letters and spaces.
    Examples:
    selectWords("Mary had a little lamb", 4) ==> ["little"]
    selectWords("Mary had a little lamb", 3) ==> ["Mary", "lamb"]
    selectWords("simple white space", 2) ==> []
    selectWords("Hello world", 4) ==> ["world"]
    selectWords("Uncle sam", 3) ==> ["Uncle"]
     */
    public List<String> selectWords(String s, int n) {
        // Let's think step by step
        // Input: s (string containing only letters and spaces), n (natural number)
        // Output: list of words with exactly n consonants, preserving order
        // Sequential: prepare result container
        List<String> result = new ArrayList<>();

        // Branch: handle null or empty string
        if (s == null) {
            return result;
        }
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return result;
        }

        // Sequential: split the string into words (handle multiple spaces)
        String[] words = trimmed.split("\\s+");

        // Loop: iterate over each word
        for (String word : words) {
            int consonants = 0;

            // Loop: iterate over characters of the word to count consonants
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                char lc = Character.toLowerCase(c);

                // Branch: count if the character is a consonant (a letter that is not a, e, i, o, u)
                if (lc >= 'a' && lc <= 'z') {
                    if (!(lc == 'a' || lc == 'e' || lc == 'i' || lc == 'o' || lc == 'u')) {
                        consonants++;
                    }
                }
            }

            // Branch: if the word has exactly n consonants, add to result
            if (consonants == n) {
                result.add(word);
            }
        }

        // Sequential: return the result
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.selectWords("Mary had a little lamb", 4).equals(List.of("little" )),
                s.selectWords("Mary had a little lamb", 3).equals(Arrays.asList("Mary", "lamb")),
                s.selectWords("simple white space", 2).equals(List.of()),
                s.selectWords("Hello world", 4).equals(List.of("world" )),
                s.selectWords("Uncle sam", 3).equals(List.of("Uncle" )),
                s.selectWords("", 4).equals(List.of()),
                s.selectWords("a b c d e f", 1).equals(Arrays.asList("b", "c", "d", "f"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}