import java.util.*;
import java.lang.*;

class Solution {
    /**
     * For a given list of integers, return a tuple consisting of a sum and a product of all the integers in a list.
     * Empty sum should be equal to 0 and empty product should be equal to 1.
     * >>> sumProduct(List.of())
     * [0, 1]
     * >>> sumProduct(Arrays.asList(1, 2, 3, 4))
     * [10, 24]
     */
    public List<Integer> sumProduct(List<Integer> numbers) {
        // Let's think step by step
        // Input: list of integers
        // Output: list with two integers [sum, product]
        // 1. Initialize sum to 0 and product to 1
        // 2. If the list is empty, return [0, 1]
        // 3. For each number in the list:
        // 4.   Add the number to the sum
        // 5.   Multiply the product by the number
        // 6. Return [sum, product]
        int sum = 0;
        int product = 1;

        if (numbers.isEmpty()) {
            return Arrays.asList(0, 1);
        }

        for (int num : numbers) {
            sum += num;
            product *= num;
        }

        return Arrays.asList(sum, product);
    }
}

