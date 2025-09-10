import java.util.*;
import java.lang.*;

class Solution {
    /**
    Create a function that returns a tuple (a, b), where 'a' is
    the largest of negative integers, and 'b' is the smallest
    of positive integers in a list.
    If there is no negative or positive integers, return them as None.

    Examples:
    largestSmallestIntegers(Arrays.asList(2, 4, 1, 3, 5, 7)) == (Optional.empty(), Optional.of(1))
    largestSmallestIntegers(Arrays.asList()) == (Optional.empty(), Optional.empty())
    largestSmallestIntegers(Arrays.asList(0)) == (Optional.empty(), Optional.empty())
     */
    public List<Optional<Integer>> largestSmallestIntegers(List<Integer> lst){
        // Let's think step by step
        // Input: lst, a list of integers
        // Output: a List of two Optionals: [largestNegative, smallestPositive]
        // Sequential structure:
        // 1) Initialize placeholders for the largest negative and smallest positive numbers.
        // Loop structure:
        // 2) Iterate over each number in the list.
        // Branch structure inside loop:
        //    - If the number is negative, update the largest negative if it's larger.
        //    - Else if the number is positive, update the smallest positive if it's smaller.
        //    - Else (number is zero), do nothing.
        // Sequential structure:
        // 3) Wrap the final values into Optional.
        // 4) Return them as a list [largestNegative, smallestPositive].
        
        if (lst == null || lst.isEmpty()) {
            return Arrays.asList(Optional.empty(), Optional.empty());
        }

        Integer maxNeg = null; // largest negative
        Integer minPos = null; // smallest positive

        for (Integer x : lst) {
            if (x == null) continue; // ignore nulls if present
            if (x < 0) {
                if (maxNeg == null || x > maxNeg) {
                    maxNeg = x;
                }
            } else if (x > 0) {
                if (minPos == null || x < minPos) {
                    minPos = x;
                }
            } // x == 0 -> ignore
        }

        Optional<Integer> a = (maxNeg == null) ? Optional.empty() : Optional.of(maxNeg);
        Optional<Integer> b = (minPos == null) ? Optional.empty() : Optional.of(minPos);

        return Arrays.asList(a, b);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.largestSmallestIntegers(Arrays.asList(2, 4, 1, 3, 5, 7)).equals(Arrays.asList(Optional.empty(), Optional.of(1))),
                s.largestSmallestIntegers(Arrays.asList(2, 4, 1, 3, 5, 7, 0)).equals(Arrays.asList(Optional.empty(), Optional.of(1))),
                s.largestSmallestIntegers(Arrays.asList(1, 3, 2, 4, 5, 6, -2)).equals(Arrays.asList(Optional.of(-2), Optional.of(1))),
                s.largestSmallestIntegers(Arrays.asList(4, 5, 3, 6, 2, 7, -7)).equals(Arrays.asList(Optional.of(-7), Optional.of(2))),
                s.largestSmallestIntegers(Arrays.asList(7, 3, 8, 4, 9, 2, 5, -9)).equals(Arrays.asList(Optional.of(-9), Optional.of(2))),
                s.largestSmallestIntegers(List.of()).equals(Arrays.asList(Optional.empty(), Optional.empty())),
                s.largestSmallestIntegers(List.of(0)).equals(Arrays.asList(Optional.empty(), Optional.empty())),
                s.largestSmallestIntegers(Arrays.asList(-1, -3, -5, -6)).equals(Arrays.asList(Optional.of(-1), Optional.empty())),
                s.largestSmallestIntegers(Arrays.asList(-1, -3, -5, -6, 0)).equals(Arrays.asList(Optional.of(-1), Optional.empty())),
                s.largestSmallestIntegers(Arrays.asList(-6, -4, -4, -3, 1)).equals(Arrays.asList(Optional.of(-3), Optional.of(1))),
                s.largestSmallestIntegers(Arrays.asList(-6, -4, -4, -3, -100, 1)).equals(Arrays.asList(Optional.of(-3), Optional.of(1)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}