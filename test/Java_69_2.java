import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a non-empty list of positive integers. Return the greatest integer that is greater than
    zero, and has a frequency greater than or equal to the value of the integer itself.
    The frequency of an integer is the number of times it appears in the list.
    If no such a value exist, return -1.
    Examples:
        search(Arrays.asList(4, 1, 2, 2, 3, 1)) == 2
        search(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4)) == 3
        search(Arrays.asList(5, 5, 4, 4, 4)) == -1
     */
    public int search(List<Integer> lst) {
        // Let's think step by step
        // Input: lst, a non-empty list of positive integers
        // Output: the greatest integer x > 0 such that frequency(x) >= x, else -1
        // Sequential structure:
        // 1. Create a frequency map to count occurrences of each number.
        // 2. Initialize result to -1 (default if no valid number exists).
        // Loop structure:
        // 3. Iterate over lst to populate the frequency map.
        // 4. Iterate over the entries of the frequency map to evaluate the condition.
        // Branch structure:
        // 5. If count >= number and number > result, update result with this number.
        // 6. After processing all entries, return result.

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : lst) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int result = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (num > 0 && count >= num && num > result) {
                result = num;
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.search(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 1))) == 1,
                s.search(new ArrayList<>(Arrays.asList(4, 1, 4, 1, 4, 4))) == 4,
                s.search(new ArrayList<>(Arrays.asList(3, 3))) == -1,
                s.search(new ArrayList<>(Arrays.asList(8, 8, 8, 8, 8, 8, 8, 8))) == 8,
                s.search(new ArrayList<>(Arrays.asList(2, 3, 3, 2, 2))) == 2,
                s.search(new ArrayList<>(Arrays.asList(2, 7, 8, 8, 4, 8, 7, 3, 9, 6, 5, 10, 4, 3, 6, 7, 1, 7, 4, 10, 8, 1))) == 1,
                s.search(new ArrayList<>(Arrays.asList(3, 2, 8, 2))) == 2,
                s.search(new ArrayList<>(Arrays.asList(6, 7, 1, 8, 8, 10, 5, 8, 5, 3, 10))) == 1,
                s.search(new ArrayList<>(Arrays.asList(8, 8, 3, 6, 5, 6, 4))) == -1,
                s.search(new ArrayList<>(Arrays.asList(6, 9, 6, 7, 1, 4, 7, 1, 8, 8, 9, 8, 10, 10, 8, 4, 10, 4, 10, 1, 2, 9, 5, 7, 9))) == 1,
                s.search(new ArrayList<>(Arrays.asList(1, 9, 10, 1, 3))) == 1,
                s.search(new ArrayList<>(Arrays.asList(6, 9, 7, 5, 8, 7, 5, 3, 7, 5, 10, 10, 3, 6, 10, 2, 8, 6, 5, 4, 9, 5, 3, 10))) == 5,
                s.search(new ArrayList<>(List.of(1))) == 1,
                s.search(new ArrayList<>(Arrays.asList(8, 8, 10, 6, 4, 3, 5, 8, 2, 4, 2, 8, 4, 6, 10, 4, 2, 1, 10, 2, 1, 1, 5))) == 4,
                s.search(new ArrayList<>(Arrays.asList(2, 10, 4, 8, 2, 10, 5, 1, 2, 9, 5, 5, 6, 3, 8, 6, 4, 10))) == 2,
                s.search(new ArrayList<>(Arrays.asList(1, 6, 10, 1, 6, 9, 10, 8, 6, 8, 7, 3))) == 1,
                s.search(new ArrayList<>(Arrays.asList(9, 2, 4, 1, 5, 1, 5, 2, 5, 7, 7, 7, 3, 10, 1, 5, 4, 2, 8, 4, 1, 9, 10, 7, 10, 2, 8, 10, 9, 4))) == 4,
                s.search(new ArrayList<>(Arrays.asList(2, 6, 4, 2, 8, 7, 5, 6, 4, 10, 4, 6, 3, 7, 8, 8, 3, 1, 4, 2, 2, 10, 7))) == 4,
                s.search(new ArrayList<>(Arrays.asList(9, 8, 6, 10, 2, 6, 10, 2, 7, 8, 10, 3, 8, 2, 6, 2, 3, 1))) == 2,
                s.search(new ArrayList<>(Arrays.asList(5, 5, 3, 9, 5, 6, 3, 2, 8, 5, 6, 10, 10, 6, 8, 4, 10, 7, 7, 10, 8))) == -1,
                s.search(new ArrayList<>(List.of(10))) == -1,
                s.search(new ArrayList<>(Arrays.asList(9, 7, 7, 2, 4, 7, 2, 10, 9, 7, 5, 7, 2))) == 2,
                s.search(new ArrayList<>(Arrays.asList(5, 4, 10, 2, 1, 1, 10, 3, 6, 1, 8))) == 1,
                s.search(new ArrayList<>(Arrays.asList(7, 9, 9, 9, 3, 4, 1, 5, 9, 1, 2, 1, 1, 10, 7, 5, 6, 7, 6, 7, 7, 6))) == 1,
                s.search(new ArrayList<>(Arrays.asList(3, 10, 10, 9, 2))) == -1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}