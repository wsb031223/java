import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given an array of integers, sort the integers that are between 1 and 9 inclusive,
    reverse the resulting array, and then replace each digit by its corresponding name from
    "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine".

    For example:
      arr = [2, 1, 1, 4, 5, 8, 2, 3]
            -> sort arr -> [1, 1, 2, 2, 3, 4, 5, 8]
            -> reverse arr -> [8, 5, 4, 3, 2, 2, 1, 1]
      return ["Eight", "Five", "Four", "Three", "Two", "Two", "One", "One"]

      If the array is empty, return an empty array:
      arr = []
      return []

      If the array has any strange number ignore it:
      arr = [1, -1 , 55]
            -> sort arr -> [-1, 1, 55]
            -> reverse arr -> [55, 1, -1]
      return = ["One"]
     */
    public List<String> byLength(List<Integer> arr) {
        // Let's think step by step
        // Input: arr, a list of integers
        // Output: a list of strings with names of digits 1..9 in descending order
        // Sequential: Prepare mapping of digits to names and containers for results.
        // Branch: Handle null or empty input quickly.
        // Loop + Branch: Traverse the input to filter only numbers in [1, 9].
        // Sequential: Sort the filtered numbers ascending.
        // Sequential: Reverse to get descending order.
        // Loop: Map each digit to its corresponding name and build the result.
        // Sequential: Return the result list.

        // Prepare name mapping
        String[] names = new String[] {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
        };

        // Handle null or empty input
        if (arr == null || arr.isEmpty()) {
            return new ArrayList<>();
        }

        // Filter numbers in the range [1, 9]
        List<Integer> filtered = new ArrayList<>();
        for (Integer num : arr) { // Loop
            if (num != null && num >= 1 && num <= 9) { // Branch
                filtered.add(num);
            }
        }

        // Sort ascending then reverse to get descending
        Collections.sort(filtered);
        Collections.reverse(filtered);

        // Map digits to names
        List<String> result = new ArrayList<>(filtered.size());
        for (int num : filtered) { // Loop
            result.add(names[num]);
        }

        // Return the final list
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.byLength(new ArrayList<>(Arrays.asList(2, 1, 1, 4, 5, 8, 2, 3))).equals(Arrays.asList("Eight", "Five", "Four", "Three", "Two", "Two", "One", "One" )),
                s.byLength(new ArrayList<>(List.of())).equals(List.of()),
                s.byLength(new ArrayList<>(Arrays.asList(1, -1, 55))).equals(List.of("One" )),
                s.byLength(new ArrayList<>(Arrays.asList(1, -1, 3, 2))).equals(Arrays.asList("Three", "Two", "One" )),
                s.byLength(new ArrayList<>(Arrays.asList(9, 4, 8))).equals(Arrays.asList("Nine", "Eight", "Four" ))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}