import java.util.*;
import java.lang.*;

class Solution {
    /**
    Evaluate whether the given number n can be written as the sum of exactly 4 positive even numbers
    Example
    isEqualToSumEven(4) == false
    isEqualToSumEven(6) == false
    isEqualToSumEven(8) == true
     */
    public boolean isEqualToSumEven(int n) {
        // Let's think step by step
        // Input: n, an integer
        // Output: boolean indicating if n can be expressed as the sum of exactly 4 positive even numbers
        // 1) Sequential: Note the minimum possible sum is 2 + 2 + 2 + 2 = 8.
        // 2) Branch: If n < 8, return false. If n is odd, return false (sum of evens is always even).
        // 3) Loop: Construct a valid decomposition by setting the first three addends to 2 in a loop,
        //          then compute the last addend as n - 6 and check if it is a positive even number.
        // 4) Branch: Return true if the constructed decomposition is valid; otherwise, return false.

        if (n < 8) {
            return false;
        }
        if ((n & 1) == 1) { // n is odd
            return false;
        }

        // Loop structure: build the first three positive even numbers (all 2)
        int[] parts = new int[4];
        for (int i = 0; i < 3; i++) {
            parts[i] = 2;
        }
        parts[3] = n - 6; // Remaining part

        // Branch: Validate the remaining part is a positive even number
        if (parts[3] >= 2 && (parts[3] % 2 == 0)) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.isEqualToSumEven(4) == false,
                s.isEqualToSumEven(6) == false,
                s.isEqualToSumEven(8) == true,
                s.isEqualToSumEven(10) == true,
                s.isEqualToSumEven(11) == false,
                s.isEqualToSumEven(12) == true,
                s.isEqualToSumEven(13) == false,
                s.isEqualToSumEven(16) == true
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}