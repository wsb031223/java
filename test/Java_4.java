import java.util.*;
import java.lang.*;

class Solution {
    /**
    For a given list of input numbers, calculate Mean Absolute Deviation
    around the mean of this dataset.
    Mean Absolute Deviation is the average absolute difference between each
    element and a centerpoint (mean in this case):
    MAD = average | x - x_mean |
    >>> meanAbsoluteDeviation(Arrays.asList(1.0, 2.0, 3.0, 4.0))
    1.0
     */
    public double meanAbsoluteDeviation(List<Double> numbers) {
        // Let's think step by step
        // Input: numbers, a list of Double
        // Output: mad, a double representing the mean absolute deviation
        // 1) Sequential structure:
        //    - Validate input
        //    - Compute mean
        //    - Compute total absolute deviation
        //    - Compute average deviation and return
        // 2) Branch structure:
        //    - If numbers is null or has no valid (non-null) elements, return 0.0
        // 3) Loop structure:
        //    - Loop to compute sum (and count)
        //    - Loop to compute sum of absolute deviations

        // Branch: handle null or empty input
        if (numbers == null || numbers.isEmpty()) {
            return 0.0;
        }

        // Loop: compute sum and count non-null elements
        double sum = 0.0;
        int count = 0;
        for (Double x : numbers) {
            if (x == null) { // Branch: skip nulls
                continue;
            }
            sum += x;
            count++;
        }

        // Branch: if no valid elements after filtering nulls
        if (count == 0) {
            return 0.0;
        }

        // Sequential: compute mean
        double mean = sum / count;

        // Loop: compute total absolute deviation
        double totalAbsDev = 0.0;
        for (Double x : numbers) {
            if (x == null) { // Branch: skip nulls
                continue;
            }
            totalAbsDev += Math.abs(x - mean);
        }

        // Sequential: compute and return MAD
        double mad = totalAbsDev / count;
        return mad;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0))) - 2.0/3.0) < 1e-6,
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0))) - 1.0) < 1e-6,
                Math.abs(s.meanAbsoluteDeviation(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))) - 6.0/5.0) < 1e-6
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}