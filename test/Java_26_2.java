import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Solution {
    /**
    From a list of integers, remove all elements that occur more than once.
    Keep order of elements left the same as in the input.
    >>> removeDuplicates(Array.asList(1, 2, 3, 2, 4))
    [1, 3, 4]
     */
    public List<Integer> removeDuplicates(List<Integer> numbers) {
        // Let's think step by step
        // Input: numbers, a list of integers
        // Output: a list containing only the elements that appear exactly once, preserving input order
        // 1. Sequential: Initialize a frequency map to count occurrences of each number.
        // 2. Loop: Iterate through the list and update the frequency map.
        // 3. Sequential: Initialize a result list to store unique elements.
        // 4. Loop: Iterate through the list again.
        // 5. Branch: If the count of the current number is exactly 1, add it to the result list.
        // 6. Sequential: Return the result list.
        // Write your code here
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer num : numbers) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (freq.get(num) == 1) {
                result.add(num);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.removeDuplicates(new ArrayList<>(List.of())).equals(List.of()),
                s.removeDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 4))).equals(Arrays.asList(1, 2, 3, 4)),
                s.removeDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 3, 5))).equals(Arrays.asList(1, 4, 5))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}