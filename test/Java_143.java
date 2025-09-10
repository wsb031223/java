import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a string representing a sentence,
    the sentence contains some words separated by a space,
    and you have to return a string that contains the words from the original sentence,
    whose lengths are prime numbers,
    the order of the words in the new string should be the same as the original one.

    Example 1:
        Input: sentence = "This is a test"
        Output: "is"

    Example 2:
        Input: sentence = "lets go for swimming"
        Output: "go for"

    Constraints:
        * 1 <= len(sentence) <= 100
        * sentence contains only letters
     */
    public String wordsInSentence(String sentence) {
        // Let's think step by step
        // Input: sentence, a string
        // Output: result, a string with words whose lengths are prime
        // 1. Split the sentence by spaces to get words. (sequential)
        // 2. Initialize a StringBuilder to collect valid words. (sequential)
        // 3. For each word in the list: (loop)
        // 4.   Compute its length. (sequential)
        // 5.   If the length is a prime number: (branch)
        // 6.     Append the word to the result, managing spaces. (sequential)
        // 7. Convert the StringBuilder to String and return it. (sequential)
        // Write your code here
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int len = word.length();
            if (isPrime(len)) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(word);
            }
        }

        return result.toString();
    }

    private boolean isPrime(int n) {
        // Branch structure for quick eliminations
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        // Loop to check divisibility up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.wordsInSentence("This is a test" ), "is" ),
                Objects.equals(s.wordsInSentence("lets go for swimming" ), "go for" ),
                Objects.equals(s.wordsInSentence("there is no place available here" ), "there is no place" ),
                Objects.equals(s.wordsInSentence("Hi I am Hussein" ), "Hi am Hussein" ),
                Objects.equals(s.wordsInSentence("go for it" ), "go for it" ),
                Objects.equals(s.wordsInSentence("here" ), "" ),
                Objects.equals(s.wordsInSentence("here is" ), "is" )
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}