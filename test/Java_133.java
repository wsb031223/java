import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a list of numbers.
    You need to return the sum of squared numbers in the given list,
    round each element in the list to the upper int(Ceiling) first.
    Examples:
    For lst = [1,2,3] the output should be 14
    For lst = [1,4,9] the output should be 98
    For lst = [1,3,5,7] the output should be 84
    For lst = [1.4,4.2,0] the output should be 29
    For lst = [-2.4,1,1] the output should be 6
     */
    public int sumSquares(List<Double> lst) {
        // Let's think step by step
        // Input: lst, a list of Double numbers
        // Output: sum, an integer representing the sum of squares of ceiled elements
        // Sequential structure:
        // 1. Initialize an accumulator variable "sum" to 0.
        // Branch structure:
        // 2. If the input list is null or empty, return 0.
        // Loop structure:
        // 3. For each number x in the list:
        //    3.1 Compute its ceiling value c = Math.ceil(x).
        //    3.2 Convert c to int.
        //    3.3 Square it and add to "sum".
        // 4. Return "sum".
        int sum = 0;
        if (lst == null || lst.isEmpty()) {
            return 0;
        }
        for (Double x : lst) {
            if (x == null) {
                continue;
            }
            int c = (int) Math.ceil(x.doubleValue());
            sum += c * c;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.sumSquares(Arrays.asList(1., 2., 3.)) == 14,
                s.sumSquares(Arrays.asList(1.0, 2., 3.)) == 14,
                s.sumSquares(Arrays.asList(1., 3., 5., 7.)) == 84,
                s.sumSquares(Arrays.asList(1.4, 4.2, 0.)) == 29,
                s.sumSquares(Arrays.asList(-2.4, 1., 1.)) == 6,
                s.sumSquares(Arrays.asList(100., 1., 15., 2.)) == 10230,
                s.sumSquares(Arrays.asList(10000., 10000.)) == 200000000,
                s.sumSquares(Arrays.asList(-1.4, 4.6, 6.3)) == 75,
                s.sumSquares(Arrays.asList(-1.4, 17.9, 18.9, 19.9)) == 1086,
                s.sumSquares(List.of(0.)) == 0,
                s.sumSquares(List.of(-1.)) == 1,
                s.sumSquares(Arrays.asList(-1., 1., 0.)) == 2
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}