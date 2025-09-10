import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer N, return the total sum of its digits in binary.

    Example
        For N = 1000, the sum of digits will be 1 the output should be "1".
        For N = 150, the sum of digits will be 6 the output should be "110".
        For N = 147, the sum of digits will be 12 the output should be "1100".

    Variables:
        @N integer
             Constraints: 0 <= N <= 10000.
    Output:
         a string of binary number
     */
    public String solve(int N) {
        // Let's think step by step
        // Input: N, an integer
        // Output: a binary string representing the sum of digits

        // Sequential structure:
        // 1) Initialize variables to accumulate digit sum.
        int sum = 0;
        int temp = N;

        // Branch structure:
        // 2) If N is 0, return "0" directly since sum of digits is 0.
        if (temp == 0) {
            return "0";
        }

        // Loop structure:
        // 3) While temp > 0, extract last digit and add to sum, then remove the digit.
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        // Sequential structure:
        // 4) Convert the computed sum to a binary string and return it.
        return Integer.toBinaryString(sum);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.solve(1000), "1"),
                Objects.equals(s.solve(150), "110"),
                Objects.equals(s.solve(147), "1100"),
                Objects.equals(s.solve(333), "1001"),
                Objects.equals(s.solve(963), "10010")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}