import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer n, return a tuple that has the number of even and odd
    integer palindromes that fall within the range(1, n), inclusive.

    Example 1:

        Input: 3
        Output: (1, 2)
        Explanation:
        Integer palindrome are 1, 2, 3. one of them is even, and two of them are odd.

    Example 2:

        Input: 12
        Output: (4, 6)
        Explanation:
        Integer palindrome are 1, 2, 3, 4, 5, 6, 7, 8, 9, 11. four of them are even, and 6 of them are odd.

    Note:
        1. 1 <= n <= 10^3
        2. returned tuple has the number of even and odd integer palindromes respectively.
     */
    public List<Integer> evenOddPalindrome(int n) {
        // Let's think step by step
        // Input: n, a positive integer
        // Output: List<Integer> -> [evenCount, oddCount]
        // Sequential:
        // 1. Initialize counters for even and odd palindromic numbers.
        // Loop:
        // 2. For i from 1 to n (inclusive), check if i is a palindrome.
        // Branch:
        // 3. If i is a palindrome, then:
        //    - If i is even, increment evenCount.
        //    - Else, increment oddCount.
        // 4. After the loop, construct and return the list [evenCount, oddCount].

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 1; i <= n; i++) {
            if (isPalindrome(i)) {
                if (i % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(evenCount);
        result.add(oddCount);
        return result;
    }

    private boolean isPalindrome(int x) {
        int original = x;
        int reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + (x % 10);
            x /= 10;
        }
        return reversed == original;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.evenOddPalindrome(123).equals(Arrays.asList(8, 13)),
                s.evenOddPalindrome(12).equals(Arrays.asList(4, 6)),
                s.evenOddPalindrome(3).equals(Arrays.asList(1, 2)),
                s.evenOddPalindrome(63).equals(Arrays.asList(6, 8)),
                s.evenOddPalindrome(25).equals(Arrays.asList(5, 6)),
                s.evenOddPalindrome(19).equals(Arrays.asList(4, 6)),
                s.evenOddPalindrome(9).equals(Arrays.asList(4, 5)),
                s.evenOddPalindrome(1).equals(Arrays.asList(0, 1))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}