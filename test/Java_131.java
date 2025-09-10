import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer n, return the product of the odd digits.
    Return 0 if all digits are even.
    For example:
    digits(1)  == 1
    digits(4)  == 0
    digits(235) == 15
     */
    public int digits(int n) {
        // Let's think step by step
        // Input: n, a positive integer
        // Output: product of its odd digits; if no odd digits, return 0
        // Sequential:
        // 1. Initialize product = 1 and foundOdd = false.
        // Loop:
        // 2. While n > 0:
        //    a. Extract last digit d = n % 10.
        //    b. Branch: If d is odd, multiply product by d and mark foundOdd = true.
        //    c. Remove last digit by n /= 10.
        // Branch:
        // 3. If foundOdd is false, return 0; otherwise, return product.
        // Write your code here
        int product = 1;
        boolean foundOdd = false;
        while (n > 0) {
            int d = n % 10;
            if ((d & 1) == 1) {
                product *= d;
                foundOdd = true;
            }
            n /= 10;
        }
        if (!foundOdd) {
            return 0;
        }
        return product;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.digits(5) == 5,
                s.digits(54) == 5,
                s.digits(120) == 1,
                s.digits(5014) == 5,
                s.digits(98765) == 315,
                s.digits(5576543) == 2625
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}