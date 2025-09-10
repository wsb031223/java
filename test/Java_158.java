import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that accepts a list of strings.
    The list contains different words. Return the word with maximum number
    of unique characters. If multiple strings have maximum number of unique
    characters, return the one which comes first in lexicographical order.

    findMax(["name", "of", "string"]) == "string"
    findMax(["name", "enam", "game"]) == "enam"
    findMax(["aaaaaaa", "bb" ,"cc"]) == ""aaaaaaa"
     */
    public String findMax(List<String> words) {
        // Let's think step by step
        // Input: list of strings
        // Output: string with max unique characters (lexicographical first if tie)
        // 1. Initialize variables to track max unique count and result word
        // 2. Loop through each word in the list
        // 3. For each word, count unique characters using a Set
        // 4. Compare with current max count
        // 5. If higher count, update max and result
        // 6. If equal count, compare lexicographically and take the smaller one
        // 7. Return the result word
        
        if (words == null || words.isEmpty()) {
            return "";
        }
        
        int maxUnique = -1;
        String result = "";
        
        for (String word : words) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
            int currentUnique = uniqueChars.size();
            
            if (currentUnique > maxUnique) {
                maxUnique = currentUnique;
                result = word;
            } else if (currentUnique == maxUnique) {
                if (result.compareTo(word) > 0) {
                    result = word;
                }
            }
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.findMax(new ArrayList<>(Arrays.asList("name", "of", "string"))).equals("string"),
                s.findMax(new ArrayList<>(Arrays.asList("name", "enam", "game"))).equals("enam"),
                s.findMax(new ArrayList<>(Arrays.asList("aaaaaaa", "bb", "cc"))).equals("aaaaaaa"),
                s.findMax(new ArrayList<>(Arrays.asList("abc", "cba"))).equals("abc"),
                s.findMax(new ArrayList<>(Arrays.asList("play", "this", "game", "of", "footbott"))).equals("footbott"),
                s.findMax(new ArrayList<>(Arrays.asList("we", "are", "gonna", "rock"))).equals("gonna"),
                s.findMax(new ArrayList<>(Arrays.asList("we", "are", "a", "mad", "nation"))).equals("nation"),
                s.findMax(new ArrayList<>(Arrays.asList("this", "is", "a", "prrk"))).equals("this"),
                s.findMax(new ArrayList<>(List.of("b"))).equals("b"),
                s.findMax(new ArrayList<>(Arrays.asList("play", "play", "play"))).equals("play")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}