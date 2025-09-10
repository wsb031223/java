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
        // 1. Filter the input list to only include numbers between 1 and 9 inclusive
        // 2. Sort the filtered list in ascending order
        // 3. Reverse the sorted list to get descending order
        // 4. Map each number to its corresponding word representation
        // 5. Return the resulting list of strings
        
        List<Integer> filtered = new ArrayList<>();
        for (int num : arr) {
            if (num >= 1 && num <= 9) {
                filtered.add(num);
            }
        }
        
        Collections.sort(filtered);
        Collections.reverse(filtered);
        
        List<String> result = new ArrayList<>();
        for (int num : filtered) {
            switch (num) {
                case 1: result.add("One"); break;
                case 2: result.add("Two"); break;
                case 3: result.add("Three"); break;
                case 4: result.add("Four"); break;
                case 5: result.add("Five"); break;
                case 6: result.add("Six"); break;
                case 7: result.add("Seven"); break;
                case 8: result.add("Eight"); break;
                case 9: result.add("Nine"); break;
            }
        }
        
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