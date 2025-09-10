import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function countNums which takes an array of integers and returns
    the number of elements which has a sum of digits > 0.
    If a number is negative, then its first signed digit will be negative:
    e.g. -123 has signed digits -1, 2, and 3.
    >>> countNums(Arrays.asList()) == 0
    >>> countNums(Arrays.asList(-1, 11, -11)) == 1
    >>> countNums(Arrays.asList(1, 1, 2)) == 3
     */
    public int countNums(List<Integer> arr) {
        // Let's think step by step
        // Input: arr, a list of integers
        // Output: count, an integer
        // Sequential structure:
        // 1. Initialize a counter to 0.
        // 2. Traverse each number in the list.
        // Loop structure:
        // 3. For each number, compute the sum of its digits:
        //    - Work in long to safely handle Integer.MIN_VALUE.
        //    - Get absolute value to extract digits.
        //    - Accumulate the sum of digits and capture the most significant digit.
        // Branch structure:
        // 4. If the original number is negative, make the most significant digit negative
        //    by subtracting it twice from the total digit sum.
        // 5. If the resulting signed-digit sum > 0, increment the counter.
        // 6. Return the counter.
        int count = 0;
        for (int x : arr) {
            long v = x;
            boolean neg = v < 0;
            long abs = neg ? -v : v; // safe absolute using long to avoid overflow on Integer.MIN_VALUE
            long signedSum;
            if (abs == 0) {
                signedSum = 0;
            } else {
                long temp = abs;
                long sumPos = 0;
                long msd = 0;
                while (temp >= 10) {
                    sumPos += (temp % 10);
                    temp /= 10;
                }
                msd = temp;        // most significant digit
                sumPos += msd;     // complete sum of digits of |x|
                signedSum = neg ? (sumPos - 2 * msd) : sumPos; // apply sign to the first digit
            }
            if (signedSum > 0) {
                count++;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.countNums(List.of()) == 0,
                s.countNums(Arrays.asList(-1, -2, 0)) == 0,
                s.countNums(Arrays.asList(1, 1, 2, -2, 3, 4, 5)) == 6,
                s.countNums(Arrays.asList(1, 6, 9, -6, 0, 1, 5)) == 5,
                s.countNums(Arrays.asList(1, 100, 98, -7, 1, -1)) == 4,
                s.countNums(Arrays.asList(12, 23, 34, -45, -56, 0)) == 5,
                s.countNums(Arrays.asList(-0, (int) Math.pow(1, 0))) == 1,
                s.countNums(List.of(1)) == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}