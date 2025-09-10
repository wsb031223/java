import java.util.*;
import java.lang.*;

class Solution {
    /**
    We have an array 'arr' of N integers arr[1], arr[2], ..., arr[N].The
    numbers in the array will be randomly ordered. Your task is to determine if
    it is possible to get an array sorted in non-decreasing order by performing
    the following operation on the given array:
        You are allowed to perform right shift operation any number of times.

    One right shift operation means shifting all elements of the array by one
    position in the right direction. The last element of the array will be moved to
    the starting position in the array i.e. 0th index.

    If it is possible to obtain the sorted array by performing the above operation
    then return true else return False.
    If the given array is empty then return true.

    Note: The given list is guaranteed to have unique elements.

    For Example:

    moveOneBall(Arrays.asList(3, 4, 5, 1, 2))==>true
    Explanation: By performin 2 right shift operations, non-decreasing order can
                 be achieved for the given array.
    moveOneBall(Arrays.asList(3, 5, 4, 1, 2))==>False
    Explanation:It is not possible to get non-decreasing order for the given
                array by performing any number of right shift operations.
     */
    public boolean moveOneBall(List<Integer> arr) {
        // Let's think step by step
        // Input: arr, a list of integers
        // Output: boolean indicating if sorted order can be achieved by right shifts
        // 1. If array is empty, return true
        // 2. Find the minimum element and count how many times the array is already sorted
        // 3. Check if there's exactly one point where the array "breaks" from being sorted
        // 4. Verify that all elements before the break point are greater than all elements after
        if (arr.isEmpty() || arr.size() == 1) {
            return true;
        }
        
        int n = arr.size();
        int breakPoint = -1;
        int breakCount = 0;
        
        // Find where the array breaks from being sorted
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            if (arr.get(i) > arr.get(next)) {
                breakPoint = next;
                breakCount++;
            }
        }
        
        // If no breaks, array is already sorted
        if (breakCount == 0) {
            return true;
        }
        
        // If more than one break, cannot be sorted by shifting
        if (breakCount > 1) {
            return false;
        }
        
        // Check if the break point is valid (all elements before break are greater than all after)
        // Since elements are unique, we can check if first element after break is the minimum
        int minVal = Collections.min(arr);
        if (arr.get(breakPoint) == minVal) {
            return true;
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.moveOneBall(new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2))) == true,
                s.moveOneBall(new ArrayList<>(Arrays.asList(3, 5, 10, 1, 2))) == true,
                s.moveOneBall(new ArrayList<>(Arrays.asList(4, 3, 1, 2))) == false,
                s.moveOneBall(new ArrayList<>(Arrays.asList(3, 5, 4, 1, 2))) == false,
                s.moveOneBall(new ArrayList<>(Arrays.asList())) == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}