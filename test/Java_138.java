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
        // Output: boolean indicating if n can be expressed as sum of 4 positive even numbers
        // 1. Check if n is even (since sum of 4 even numbers must be even)
        // 2. Check if n is at least 8 (smallest sum: 2+2+2+2=8)
        // 3. If both conditions are true, return true; else return false
        
        if (n % 2 != 0) {
            return false;
        }
        if (n < 8) {
            return false;
        }
        return true;
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