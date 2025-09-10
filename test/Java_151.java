import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a list of numbers, return the sum of squares of the numbers
    in the list that are odd. Ignore numbers that are negative or not integers.

    doubleTheDifference(Arrays.asList(1, 3, 2, 0)) == 1 + 9 + 0 + 0 = 10
    doubleTheDifference(Arrays.asList(-1, -2, 0)) == 0
    doubleTheDifference(Arrays.asList(9, -2)) == 81
    doubleTheDifference(Arrays.asList(0)) == 0

    If the input list is empty, return 0.
     */
    public int doubleTheDifference(List<Object> lst) {
        // Let's think step by step
        // Input: lst, a list of objects
        // Output: sum, an integer
        // Sequential structure:
        // 1. If lst is null or empty, return 0.
        // 2. Initialize a variable "sum" to 0 (use long to avoid intermediate overflow).
        // Loop structure:
        // 3. For each element "o" in lst:
        // Branch structure:
        //    a) If "o" is an integral type (Byte, Short, Integer, Long):
        //       i) Convert it to a long value "v".
        //      ii) If v >= 0 and v is odd, add v*v to sum.
        //    b) Else: ignore the element.
        // 4. Return sum as int.
        if (lst == null || lst.isEmpty()) {
            return 0;
        }
        long sum = 0L;
        for (Object o : lst) {
            if (o instanceof Integer || o instanceof Long || o instanceof Short || o instanceof Byte) {
                long v;
                if (o instanceof Integer) {
                    v = ((Integer) o).longValue();
                } else if (o instanceof Long) {
                    v = ((Long) o).longValue();
                } else if (o instanceof Short) {
                    v = ((Short) o).longValue();
                } else {
                    v = ((Byte) o).longValue();
                }
                if (v >= 0 && (v & 1L) == 1L) {
                    sum += v * v;
                }
            }
        }
        return (int) sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.doubleTheDifference(List.of()) == 0,
                s.doubleTheDifference(Arrays.asList(5, 4)) == 25,
                s.doubleTheDifference(Arrays.asList(0.1, 0.2, 0.3)) == 0,
                s.doubleTheDifference(Arrays.asList(-10, -20, -30)) == 0,
                s.doubleTheDifference(Arrays.asList(-1, -2, 8)) == 0,
                s.doubleTheDifference(Arrays.asList(0.2, 3, 5)) == 34
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
        List<Object> lst = new ArrayList<>();
        for (int i = -99; i < 100; i += 2) {
            lst.add(i);
        }
        int odd_sum = lst.stream().filter(i -> i instanceof Integer p && p % 2 != 0 && p > 0).map(i -> (Integer) i * (Integer) i).reduce(Integer::sum).orElse(0);
        assert s.doubleTheDifference(lst) == odd_sum;
    }
}