import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given list of numbers (of at least two elements), apply a linear transform to that list,
    such that the smallest number will become 0 and the largest will become 1
    >>> rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))
    [0.0, 0.25, 0.5, 0.75, 1.0]
     */
    public List<Double> rescaleToUnit(List<Double> numbers) {
        // Let's think step by step
        // Input: numbers, a list of Double with at least two elements
        // Output: rescaled, a list of Double where min maps to 0.0 and max maps to 1.0
        // Sequential: define variables, compute range, and build result
        // Branch: handle null/empty input and the case where all values are equal
        // Loop: iterate to find min/max and to compute each rescaled value

        // 1) Branch: handle null or empty input
        if (numbers == null || numbers.isEmpty()) {
            return new ArrayList<>();
        }

        // 2) Sequential: initialize min and max
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        // 3) Loop: determine min and max values
        for (Double v : numbers) {
            if (v < min) min = v;
            if (v > max) max = v;
        }

        // 4) Sequential: compute the range
        double range = max - min;

        // 5) Branch + Loop: if all values are the same, return all zeros
        List<Double> result = new ArrayList<>(numbers.size());
        if (range == 0.0) {
            for (int i = 0; i < numbers.size(); i++) {
                result.add(0.0);
            }
            return result;
        }

        // 6) Loop: compute rescaled values
        for (Double v : numbers) {
            result.add((v - min) / range);
        }

        // 7) Sequential: return the result
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(2.0, 49.9))).equals(Arrays.asList(0.0, 1.0)),
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(100.0, 49.9))).equals(Arrays.asList(1.0, 0.0)),
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))).equals(Arrays.asList(0.0, 0.25, 0.5, 0.75, 1.0)),
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(2.0, 1.0, 5.0, 3.0, 4.0))).equals(Arrays.asList(0.25, 0.0, 1.0, 0.5, 0.75)),
                s.rescaleToUnit(new ArrayList<>(Arrays.asList(12.0, 11.0, 15.0, 13.0, 14.0))).equals(Arrays.asList(0.25, 0.0, 1.0, 0.5, 0.75))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}