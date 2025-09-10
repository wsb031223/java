import java.util.*;
import java.lang.*;

class Solution {
    /**
    In this task, you will be given a string that represents a number of apples and oranges
    that are distributed in a basket of fruit this basket contains
    apples, oranges, and mango fruits. Given the string that represents the total number of
    the oranges and apples and an integer that represent the total number of the fruits
    in the basket return the number of the mango fruits in the basket.
    for examble:
    fruitDistribution("5 apples and 6 oranges", 19) ->19 - 5 - 6 = 8
    fruitDistribution("0 apples and 1 oranges",3) -> 3 - 0 - 1 = 2
    fruitDistribution("2 apples and 3 oranges", 100) -> 100 - 2 - 3 = 95
    fruitDistribution("100 apples and 1 oranges",120) -> 120 - 100 - 1 = 19
     */
    public int fruitDistribution(String s, int n) {
        // Let's think step by step
        // Input: s, a string containing counts for apples and oranges; n, total fruits.
        // Output: number of mango fruits.
        // Sequential steps:
        // 1. Initialize variables to capture the two numbers (apples and oranges).
        // 2. Loop through the string characters to parse contiguous digits into integers.
        // 3. Branch on whether the current character is a digit to build numbers or finalize them.
        // 4. After the loop, handle any trailing number not yet finalized.
        // 5. Compute mangoes as n - apples - oranges.
        // 6. Return the result.

        int apples = 0;
        int oranges = 0;
        int current = 0;
        boolean inNumber = false;
        int countFound = 0;

        // Loop through characters to extract numbers
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                // Branch: we are within a number
                inNumber = true;
                current = current * 10 + (c - '0');
            } else {
                // Branch: non-digit ends a number if we were building one
                if (inNumber) {
                    if (countFound == 0) {
                        apples = current;
                    } else if (countFound == 1) {
                        oranges = current;
                    }
                    countFound++;
                    current = 0;
                    inNumber = false;
                    // Optional: could break after finding two numbers
                }
            }
        }

        // Handle trailing number after loop ends
        if (inNumber) {
            if (countFound == 0) {
                apples = current;
            } else if (countFound == 1) {
                oranges = current;
            }
            countFound++;
        }

        // Compute and return result
        int mangoes = n - apples - oranges;
        return mangoes;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.fruitDistribution("5 apples and 6 oranges",19) == 8,
                s.fruitDistribution("5 apples and 6 oranges",21) == 10,
                s.fruitDistribution("0 apples and 1 oranges",3) == 2,
                s.fruitDistribution("1 apples and 0 oranges",3) == 2,
                s.fruitDistribution("2 apples and 3 oranges",100) == 95,
                s.fruitDistribution("2 apples and 3 oranges",5) == 0,
                s.fruitDistribution("1 apples and 100 oranges",120) == 19
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}