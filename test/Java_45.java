import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given length of a side and high return area for a triangle.
    >>> triangleArea(5, 3)
    7.5
     */
    public double triangleArea(double a, double h) {
        // Let's think step by step
        // Input: a (base length) and h (height) as doubles
        // Output: area of triangle as double
        // Formula: area = (a * h) / 2
        // 1. Calculate the product of base and height
        // 2. Divide the product by 2
        // 3. Return the result
        return (a * h) / 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.triangleArea(5, 3) == 7.5,
                s.triangleArea(2, 2) == 2.0,
                s.triangleArea(10, 8) == 40.0
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}