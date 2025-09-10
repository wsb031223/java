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
        // Input: string containing musical notes separated by spaces
        // Output: list of integers representing beat counts
        // 1. Split the input string by spaces to get individual note tokens
        // 2. Initialize an empty list to store the results
        // 3. For each token in the split array:
        // 4.   If token equals "o", add 4 to the result list
        // 5.   Else if token equals "o|", add 2 to the result list
        // 6.   Else if token equals ".|", add 1 to the result list
        // 7. Return the result list
        
        String[] tokens = string.split(" ");
        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            if (token.equals("o")) {
                result.add(4);
            } else if (token.equals("o|")) {
                result.add(2);
            } else if (token.equals(".|")) {
                result.add(1);
            }
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