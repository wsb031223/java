import java.util.*;
import java.lang.*;

class Solution {
    /**
    Imagine a road that's a perfectly straight infinitely long line.
    n cars are driving left to right;  simultaneously, a different set of n cars
    are driving right to left.   The two sets of cars start out being very far from
    each other.  All cars move in the same speed.  Two cars are said to collide
    when a car that's moving left to right hits a car that's moving right to left.
    However, the cars are infinitely sturdy and strong; as a result, they continue moving
    in their trajectory as if they did not collide.

    This function outputs the number of such collisions.
     */
    public int carRaceCollision(int n) {
        // Let's think step by step
        // Input: n, number of cars in each direction (non-negative integer)
        // Output: total number of collisions (int)

        // Sequential structure:
        // 1) Validate input n.
        // 2) Observation: Each left-to-right car will meet (collide with) every right-to-left car exactly once.
        // 3) Therefore, total collisions = n * n. Compute and return the result.

        // Branch structure:
        // - If n <= 0, there are no cars in at least one direction, so return 0.

        // Loop structure (conceptual reasoning, not executed for efficiency):
        // - For i from 1 to n:
        //     total += n   // each left-to-right car collides with all n right-to-left cars
        // - This would yield total = n * n, but we avoid the actual loop to keep time O(1).

        // Final code:
        if (n <= 0) {
            return 0;
        }
        return (int)((long) n * (long) n);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.carRaceCollision(2) == 4,
                s.carRaceCollision(3) == 9,
                s.carRaceCollision(4) == 16,
                s.carRaceCollision(8) == 64,
                s.carRaceCollision(10) == 100
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}