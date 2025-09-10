import java.util.*;
import java.lang.*;

class Solution {
    /**
    Everyone knows Fibonacci sequence, it was studied deeply by mathematicians in
    the last couple centuries. However, what people don't know is Tribonacci sequence.
    Tribonacci sequence is defined by the recurrence:
    tri(1) = 3
    tri(n) = 1 + n / 2, if n is even.
    tri(n) =  tri(n - 1) + tri(n - 2) + tri(n + 1), if n is odd.
    For example:
    tri(2) = 1 + (2 / 2) = 2
    tri(4) = 3
    tri(3) = tri(2) + tri(1) + tri(4)
           = 2 + 3 + 3 = 8
    You are given a non-negative integer number n, you have to a return a list of the
    first n + 1 numbers of the Tribonacci sequence.
    Examples:
    tri(3) = [1, 3, 2, 8]
     */
    public List<Integer> tri(int n) {
        // Let's think step by step
        // Input: n, a non-negative integer
        // Output: list of first n+1 Tribonacci numbers
        // 1. Handle base case when n is 0
        // 2. Initialize a list to store the sequence
        // 3. For n=0, return [1]
        // 4. For n>=1, we need to compute values up to n
        // 5. The recurrence depends on even/odd and requires tri(n+1) for odd n
        // 6. This creates a challenge: we need to compute higher values first
        // 7. Alternative approach: use memoization to avoid infinite recursion
        // 8. Create a DP array to store computed values
        // 9. Use a recursive helper function with memoization
        // 10. Compute values from 0 to n
        
        if (n < 0) return new ArrayList<>();
        
        // Use memoization to store computed values
        Map<Integer, Integer> memo = new HashMap<>();
        
        // Pre-store known base cases
        memo.put(0, 1);
        memo.put(1, 3);
        
        // Compute all values from 0 to n
        for (int i = 0; i <= n; i++) {
            computeTri(i, memo);
        }
        
        // Build the result list
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            result.add(memo.get(i));
        }
        
        return result;
    }
    
    private int computeTri(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        if (n % 2 == 0) {
            // Even case: tri(n) = 1 + n / 2
            int value = 1 + n / 2;
            memo.put(n, value);
            return value;
        } else {
            // Odd case: tri(n) = tri(n-1) + tri(n-2) + tri(n+1)
            // We need to compute n+1 first, which might not be in memo yet
            // Compute all required values recursively
            int nMinus1 = computeTri(n - 1, memo);
            int nMinus2 = computeTri(n - 2, memo);
            int nPlus1 = computeTri(n + 1, memo);
            int value = nMinus1 + nMinus2 + nPlus1;
            memo.put(n, value);
            return value;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.tri(3).equals(Arrays.asList(1, 3, 2, 8)),
                s.tri(4).equals(Arrays.asList(1, 3, 2, 8, 3)),
                s.tri(5).equals(Arrays.asList(1, 3, 2, 8, 3, 15)),
                s.tri(6).equals(Arrays.asList(1, 3, 2, 8, 3, 15, 4)),
                s.tri(7).equals(Arrays.asList(1, 3, 2, 8, 3, 15, 4, 24)),
                s.tri(8).equals(Arrays.asList(1, 3, 2, 8, 3, 15, 4, 24, 5)),
                s.tri(9).equals(Arrays.asList(1, 3, 2, 8, 3, 15, 4, 24, 5, 35)),
                s.tri(20).equals(Arrays.asList(1, 3, 2, 8, 3, 15, 4, 24, 5, 35, 6, 48, 7, 63, 8, 80, 9, 99, 10, 120, 11)),
                s.tri(0).equals(List.of(1)),
                s.tri(1).equals(Arrays.asList(1, 3))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}