import java.util.*;
import java.lang.*;

class Solution {
    /**
    Write a function that returns True if the object q will fly, and False otherwise.
    The object q will fly if it's balanced (it is a palindromic list) and the sum of its elements is less than or equal the maximum possible weight w.

    Example:
    willItFly(Arrays.asList(1, 2), 5) -> false
    # 1+2 is less than the maximum possible weight, but it's unbalanced.

    willItFly(Arrays.asList(3, 2, 3), 1) -> false
    # it's balanced, but 3+2+3 is more than the maximum possible weight.

    willItFly(Arrays.asList(3, 2, 3), 9) -> true
    # 3+2+3 is less than the maximum possible weight, and it's balanced.

    willItFly(Arrays.asList(3), 5) -> true
    # 3 is less than the maximum possible weight, and it's balanced.
     */
    public boolean willItFly(List<Integer> q, int w) {
        // Let's think step by step
        // Input: q, a list of integers; w, an integer (max weight)
        // Output: boolean indicating if the object will fly
        // Sequential structure:
        // 1. If q is null, return false (invalid input).
        // 2. Get n = q.size().
        // Loop structure:
        // 3. Check if q is a palindrome using two pointers:
        //    for i from 0 to n/2 - 1:
        //       if q[i] != q[n-1-i], it's unbalanced -> return false.
        // Branch structure:
        // 4. If it's balanced, compute the sum of elements.
        // Loop structure:
        // 5. Sum all elements in q.
        // Branch structure:
        // 6. If sum <= w, return true; otherwise, return false.

        if (q == null) {
            return false;
        }

        int n = q.size();

        // Check palindromic (balanced)
        for (int i = 0; i < n / 2; i++) {
            Integer left = q.get(i);
            Integer right = q.get(n - 1 - i);
            if (left == null || right == null || !left.equals(right)) {
                return false;
            }
        }

        // Compute sum
        long sum = 0L;
        for (Integer val : q) {
            if (val != null) {
                sum += val;
            } else {
                // Treat null as 0 to avoid NPE; adjust if problem requires otherwise
                // sum += 0;
            }
        }

        return sum <= (long) w;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.willItFly(new ArrayList<>(Arrays.asList(3, 2, 3)), 9),
                !s.willItFly(new ArrayList<>(Arrays.asList(1, 2)), 5),
                s.willItFly(new ArrayList<>(List.of(3)), 5),
                !s.willItFly(new ArrayList<>(Arrays.asList(3, 2, 3)), 1),
                !s.willItFly(new ArrayList<>(Arrays.asList(1, 2, 3)), 6),
                s.willItFly(new ArrayList<>(List.of(5)), 5)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}