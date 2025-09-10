import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input to this function is a string representing musical notes in a special ASCII format.
    Your task is to parse this string and return list of integers corresponding to how many beats does each
    not last.

    Here is a legend:
    "o" - whole note, lasts four beats
    "o|" - half note, lasts two beats
    ".|" - quater note, lasts one beat

    >>> parseMusic("o o| .| o| o| .| .| .| .| o o")
    [4, 2, 1, 2, 2, 1, 1, 1, 1, 4, 4]
     */
    public List<Integer> parseMusic(String string) {
        // Let's think step by step
        // Input: string of notes separated by spaces
        // Output: list of integers representing beats for each note
        // Sequential structure:
        // 1) Initialize the result list.
        // 2) Split the input string into tokens by whitespace.
        // Loop structure:
        // 3) Iterate over each token.
        // Branch structure:
        // 4) If token is "o" -> add 4; else if token is "o|" -> add 2; else if token is ".|" -> add 1; else ignore.
        // 5) Return the result list.

        List<Integer> result = new ArrayList<>();

        if (string == null || string.trim().isEmpty()) {
            return result;
        }

        String[] tokens = string.trim().split("\\s+");
        for (String token : tokens) {
            if ("o".equals(token)) {
                result.add(4);
            } else if ("o|".equals(token)) {
                result.add(2);
            } else if (".|".equals(token)) {
                result.add(1);
            }
            // Unknown tokens are ignored as per robust parsing.
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.parseMusic("").equals(List.of()),
                s.parseMusic("o o o o").equals(Arrays.asList(4, 4, 4, 4)),
                s.parseMusic(".| .| .| .|").equals(Arrays.asList(1, 1, 1, 1)),
                s.parseMusic("o| o| .| .| o o o o").equals(Arrays.asList(2, 2, 1, 1, 4, 4, 4, 4)),
                s.parseMusic("o| .| o| .| o o| o o|").equals(Arrays.asList(2, 1, 2, 1, 4, 2, 4, 2))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}