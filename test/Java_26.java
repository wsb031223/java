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
        // Input: list of integers
        // Output: list with duplicates removed (elements that appear more than once)
        // 1. Create a frequency map to count occurrences of each number
        // 2. Create a new result list
        // 3. Iterate through the original list sequentially
        // 4. For each element, check if it appears only once in the frequency map
        // 5. If it appears only once, add it to the result list
        // 6. Return the result list
        
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : numbers) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int num : numbers) {
            if (frequency.get(num) == 1) {
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