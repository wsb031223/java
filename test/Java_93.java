import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that takes a message, and encodes in such a
    way that it swaps case of all letters, replaces all vowels in
    the message with the letter that appears 2 places ahead of that
    vowel in the english alphabet.
    Assume only letters.

    Examples:
    >>> encode("test")
    "TGST"
    >>> encode("This is a message")
    "tHKS KS C MGSSCGG"
     */
    public String encode(String message) {
        // Let's think step by step
        // Input: message string
        // Output: encoded string
        // 1. Create a string of vowels (both cases)
        // 2. Create a mapping for vowel replacement
        // 3. Iterate through each character in the message
        // 4. For each character:
        //    - If it's a vowel, replace with the letter 2 places ahead
        //    - Swap the case of the character
        // 5. Build and return the encoded string
        
        String vowels = "aeiouAEIOU";
        StringBuilder encoded = new StringBuilder();
        
        for (char c : message.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                // Replace vowel with letter 2 places ahead
                char newChar = (char)(c + 2);
                // Swap case of the new character
                if (Character.isUpperCase(c)) {
                    encoded.append(Character.toLowerCase(newChar));
                } else {
                    encoded.append(Character.toUpperCase(newChar));
                }
            } else {
                // Just swap case for non-vowels
                if (Character.isUpperCase(c)) {
                    encoded.append(Character.toLowerCase(c));
                } else {
                    encoded.append(Character.toUpperCase(c));
                }
            }
        }
        
        return encoded.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.encode("TEST"), "tgst"),
                Objects.equals(s.encode("Mudasir"), "mWDCSKR"),
                Objects.equals(s.encode("YES"), "ygs"),
                Objects.equals(s.encode("This is a message"), "tHKS KS C MGSSCGG"),
                Objects.equals(s.encode("I DoNt KnOw WhAt tO WrItE"), "k dQnT kNqW wHcT Tq wRkTg")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}