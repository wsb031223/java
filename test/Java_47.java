import java.util.*;
import java.lang.*;

class Solution {
    /**
    Return median of elements in the list l.
    >>> median(Arrays.asList(3, 1, 2, 4, 5))
    3
    >>> median(Arrays.asList(-10, 4, 6, 1000, 10, 20))
    15.0
     */
    public double median(List<Integer> l) {
        // Let's think step by step
        // Input: l, a list of integers
        // Output: the median value as a double
        // Sequential structure:
        // 1) If the list is empty, return 0.0 (or could throw, but we choose 0.0 here).
        // 2) Copy elements into an array.
        // 3) Sort the array.
        // Branch structure:
        // 4) If the number of elements is odd, return the middle element.
        // 5) Else (even), return the average of the two middle elements.
        // Loop structure:
        // - Use a loop to copy elements from the list into an array.

        int n = l.size();
        if (n == 0) {
            return 0.0;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { // loop to copy elements
            arr[i] = l.get(i);
        }

        Arrays.sort(arr);

        if (n % 2 == 1) { // odd length
            return (double) arr[n / 2];
        } else { // even length
            int a = arr[n / 2 - 1];
            int b = arr[n / 2];
            return (a + b) / 2.0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.median(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 5))) == 3,
                s.median(new ArrayList<>(Arrays.asList(-10, 4, 6, 1000, 10, 20))) == 8.0,
                s.median(new ArrayList<>(Arrays.asList(5))) == 5,
                s.median(new ArrayList<>(Arrays.asList(6, 5))) == 5.5
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}