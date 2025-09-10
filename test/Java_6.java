import java.util.*;
import java.lang.*;

class Solution {
    /**
    Input to this function is a string represented multiple groups for nested parentheses separated by spaces.
    For each of the group, output the deepest level of nesting of parentheses.
    E.g. (()()) has maximum two levels of nesting while ((())) has three.

    >>> parseNestedParens("(()()) ((())) () ((())()())")
    [2, 3, 1, 3]
     */
    public List<Integer> parseNestedParens(String paren_string) {
        // Let's think step by step
        // Problem-solving process (using sequential, branch, and loop structures):
        // Sequential:
        //   - Initialize the result list.
        //   - Sanitize the input by trimming and splitting into groups by whitespace.
        // Loop:
        //   - For each group, iterate through its characters.
        // Branch:
        //   - If character is '(', increment current depth and update max depth if needed.
        //   - Else if character is ')', decrement current depth.
        //   - Ignore any other characters (if present).
        // Finally, append the computed max depth for each group to the result list and return it.

        List<Integer> result = new ArrayList<>();

        if (paren_string == null || paren_string.trim().isEmpty()) {
            return result;
        }

        String[] groups = paren_string.trim().split("\\s+");

        for (String group : groups) {
            int currentDepth = 0;
            int maxDepth = 0;

            for (int i = 0; i < group.length(); i++) {
                char ch = group.charAt(i);
                if (ch == '(') { // Branch
                    currentDepth++;
                    if (currentDepth > maxDepth) {
                        maxDepth = currentDepth;
                    }
                } else if (ch == ')') { // Branch
                    currentDepth--;
                }
                // Any other characters are ignored.
            }

            result.add(maxDepth);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.parseNestedParens("(()()) ((())) () ((())()())").equals(Arrays.asList(2, 3, 1, 3)),
                s.parseNestedParens("() (()) ((())) (((())))").equals(Arrays.asList(1, 2, 3, 4)),
                s.parseNestedParens("(()(())((())))").equals(Arrays.asList(4))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}