import java.util.*;
import java.lang.*;

class Solution {
    /**
    You'll be given a string of words, and your task is to count the number
    of boredoms. A boredom is a sentence that starts with the word "I".
    Sentences are delimited by '.', '?' or '!'.

    For example:
    >>> isBored("Hello world")
    0
    >>> isBored("The sky is blue. The sun is shining. I love this weather")
    1
     */
    public int isBored(String S) {
        // Let's think step by step
        // Input: S, a string
        // Output: count, an integer
        // 1. Sequential: Handle null/empty input and split S into sentence fragments using '.', '?', and '!' as delimiters.
        // 2. Loop: Iterate over each fragment.
        // 3.   Sequential: Trim whitespace from the fragment.
        // 4.   Branch: If the fragment is empty, continue to the next fragment.
        // 5.   Sequential: Extract the first word (from start until first whitespace).
        // 6.   Branch: If the first word equals "I", increment the counter.
        // 7. Sequential: Return the counter.
        if (S == null || S.length() == 0) return 0;

        String[] parts = S.split("[.?!]");
        int count = 0;

        for (String part : parts) {
            if (part == null) continue;
            String trimmed = part.trim();
            if (trimmed.length() == 0) continue;

            int i = 0;
            int n = trimmed.length();
            // skip leading whitespace (already trimmed, but safe)
            while (i < n && Character.isWhitespace(trimmed.charAt(i))) i++;
            int j = i;
            while (j < n && !Character.isWhitespace(trimmed.charAt(j))) j++;
            String firstWord = (i < n) ? trimmed.substring(i, j) : "";

            if (firstWord.equals("I")) {
                count++;
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isBored("Hello world") == 0,
                s.isBored("Is the sky blue?") == 0,
                s.isBored("I love It !") == 1,
                s.isBored("bIt") == 0,
                s.isBored("I feel good today. I will be productive. will kill It") == 2,
                s.isBored("You and I are going for a walk") == 0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}