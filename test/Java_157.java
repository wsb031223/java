import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given the lengths of the three sides of a triangle. Return true if the three
    sides form a right-angled triangle, false otherwise.
    A right-angled triangle is a triangle in which one angle is right angle or
    90 degree.
    Example:
    rightAngleTriangle(3, 4, 5) == true
    rightAngleTriangle(1, 2, 3) == false
     */
    public boolean rightAngleTriangle(int a, int b, int c) {
        // Let's think step by step
        // Input: three integers a, b, c representing triangle sides
        // Output: boolean indicating if it's a right-angled triangle
        // 1. Check if the sides can form a valid triangle (sum of any two sides > third side)
        // 2. Check all three possible combinations to see if they satisfy Pythagorean theorem:
        //    a² + b² = c² OR a² + c² = b² OR b² + c² = a²
        // 3. Return true if any of these conditions is satisfied
        
        // Check if valid triangle first
        if (a + b <= c || a + c <= b || b + c <= a) {
            return false;
        }
        
        // Check Pythagorean theorem for all combinations
        if (a * a + b * b == c * c) {
            return true;
        }
        if (a * a + c * c == b * b) {
            return true;
        }
        if (b * b + c * c == a * a) {
            return true;
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.rightAngleTriangle(3, 4, 5) == true,
                s.rightAngleTriangle(1, 2, 3) == false,
                s.rightAngleTriangle(10, 6, 8) == true,
                s.rightAngleTriangle(2, 2, 2) == false,
                s.rightAngleTriangle(7, 24, 25) == true,
                s.rightAngleTriangle(10, 5, 7) == false,
                s.rightAngleTriangle(5, 12, 13) == true,
                s.rightAngleTriangle(15, 8, 17) == true,
                s.rightAngleTriangle(48, 55, 73) == true,
                s.rightAngleTriangle(1, 1, 1) == false,
                s.rightAngleTriangle(2, 2, 10) == false
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}