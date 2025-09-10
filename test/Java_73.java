import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given an array arr of integers, find the minimum number of elements that
    need to be changed to make the array palindromic. A palindromic array is an array that
    is read the same backwards and forwards. In one change, you can change one element to any other element.

    For example:
    smallestChange(Arrays.asList(1,2,3,5,4,7,9,6)) == 4
    smallestChange(Arrays.asList(1, 2, 3, 4, 3, 2, 2)) == 1
    smallestChange(Arrays.asList(1, 2, 3, 2, 1)) == 0
     */
    public int smallestChange(List<Integer> arr) {
        // Let's think step by step
        // Input: arr, a list of integers
        // Output: minimum number of changes to make arr palindromic
        // Sequential structure:
        // 1. Handle edge cases (null or size <= 1) -> return 0.
        // 2. Initialize two pointers i = 0 and j = arr.size() - 1.
        // 3. Initialize a counter 'changes' = 0.
        // Loop structure:
        // 4. While i < j:
        //    Branch structure:
        //    a. If arr[i] != arr[j], increment 'changes' by 1 because one change can fix the pair.
        //    b. Move pointers inward: i++, j--.
        // 5. Return 'changes'.
        if (arr == null || arr.size() <= 1) {
            return 0;
        }
        int i = 0, j = arr.size() - 1;
        int changes = 0;
        while (i < j) {
            if (!Objects.equals(arr.get(i), arr.get(j))) {
                changes++;
            }
            i++;
            j--;
        }
        return changes;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.smallestChange(new ArrayList<>(Arrays.asList(1, 2, 3, 5, 4, 7, 9, 6))) == 4,
                s.smallestChange(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 2, 2))) == 1,
                s.smallestChange(new ArrayList<>(Arrays.asList(1, 4, 2))) == 1,
                s.smallestChange(new ArrayList<>(Arrays.asList(1, 4, 4, 2))) == 1,
                s.smallestChange(new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1))) == 0,
                s.smallestChange(new ArrayList<>(Arrays.asList(3, 1, 1, 3))) == 0,
                s.smallestChange(new ArrayList<>(List.of(1))) == 0,
                s.smallestChange(new ArrayList<>(Arrays.asList(0, 1))) == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}