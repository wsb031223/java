import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given the lengths of the three sides of a triangle. Return the area of
    the triangle rounded to 2 decimal points if the three sides form a valid triangle.
    Otherwise return -1
    Three sides make a valid triangle when the sum of any two sides is greater
    than the third side.
    Example:
    triangleArea(3, 4, 5) == 6.00
    triangleArea(1, 2, 10) == -1
     */
    public double triangleArea(double a, double b, double c) {
        // Let's think step by step
        // Input: a, b, c - doubles
        // Output: area rounded to 2 decimals as double, or -1 if invalid
        // 1. Sequential: Place sides into an array for looping.
        // 2. Loop: Ensure all sides are positive.
        // 3. Loop: Check triangle inequalities: each side less than the sum of the other two.
        // 4. Branch: If any check fails, return -1.
        // 5. Sequential: Compute semiperimeter s.
        // 6. Sequential: Compute area using Heron's formula.
        // 7. Sequential: Round area to 2 decimal places.
        // 8. Return the rounded area.

        double[] sides = new double[] {a, b, c};

        // Loop: Check positivity of sides
        for (int i = 0; i < 3; i++) {
            if (sides[i] <= 0) {
                return -1;
            }
        }

        // Loop: Check triangle inequality for all three sides
        for (int i = 0; i < 3; i++) {
            double sumOther = sides[(i + 1) % 3] + sides[(i + 2) % 3];
            if (!(sides[i] < sumOther)) {
                return -1;
            }
        }

        // Sequential: Compute area using Heron's formula
        double s = (a + b + c) / 2.0;
        double radicand = s * (s - a) * (s - b) * (s - c);
        if (radicand < 0) {
            // Numerical guard
            return -1;
        }
        double area = Math.sqrt(radicand);

        // Sequential: Round to 2 decimal places
        double rounded = Math.round(area * 100.0) / 100.0;
        return rounded;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.triangleArea(3, 4, 5) == 6.00,
                s.triangleArea(1, 2, 10) == -1,
                s.triangleArea(4, 8, 5) == 8.18,
                s.triangleArea(2, 2, 2) == 1.73,
                s.triangleArea(1, 2, 3) == -1,
                s.triangleArea(10, 5, 7) == 16.25,
                s.triangleArea(2, 6, 3) == -1,
                s.triangleArea(1, 1, 1) == 0.43,
                s.triangleArea(2, 2, 10) == -1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}