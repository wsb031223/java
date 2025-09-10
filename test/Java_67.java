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
        // Input: s - string containing apple and orange counts, n - total fruits
        // Output: number of mango fruits
        // 1. Extract numbers from the string using string manipulation
        // 2. Split the string to get individual words
        // 3. Look for numeric values in the string
        // 4. Convert the found numbers to integers
        // 5. Calculate mango count = total fruits - apples - oranges
        // 6. Return the result
        
        String[] parts = s.split(" ");
        int apples = 0;
        int oranges = 0;
        
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].matches("\\d+")) {
                if (apples == 0) {
                    apples = Integer.parseInt(parts[i]);
                } else {
                    oranges = Integer.parseInt(parts[i]);
                }
            }
        }
        
        return n - apples - oranges;
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