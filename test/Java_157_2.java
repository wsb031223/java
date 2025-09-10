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
        // Input: a, b, c - integers representing side lengths
        // Output: boolean - true if they form a right-angled triangle, else false
        // Sequential structure:
        // 1. Check that all sides are positive.
        // 2. Identify the largest side (candidate hypotenuse).
        // 3. Check triangle inequality.
        // 4. Compare sum of squares of the two smaller sides with the square of the largest.
        // Branch structure:
        // - If any side is non-positive, return false.
        // - If triangle inequality fails, return false.
        // - Finally, return the result of the Pythagorean check.
        // Loop structure:
        // - Iterate over the sides to find the largest side.

        // 1) Sequential + Branch: validate positive sides
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        // Prepare sides
        int[] sides = {a, b, c};

        // 2) Loop: find index of the largest side (hypotenuse candidate)
        int maxIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (sides[i] > sides[maxIdx]) {
                maxIdx = i;
            }
        }

        int hyp = sides[maxIdx];
        int leg1 = sides[(maxIdx + 1) % 3];
        int leg2 = sides[(maxIdx + 2) % 3];

        // Use long to avoid overflow when squaring
        long H = hyp;
        long L1 = leg1;
        long L2 = leg2;

        // 3) Branch: triangle inequality (since hyp is largest, only need L1 + L2 > H)
        if (L1 + L2 <= H) {
            return false;
        }

        // 4) Sequential: Pythagorean theorem check
        return (L1 * L1 + L2 * L2) == (H * H);
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