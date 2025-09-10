import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given a positive integer n, return a sorted list that has the odd numbers in collatz sequence.

    The Collatz conjecture is a conjecture in mathematics that concerns a sequence defined
    as follows: start with any positive integer n. Then each term is obtained from the
    previous term as follows: if the previous term is even, the next term is one half of
    the previous term. If the previous term is odd, the next term is 3 times the previous
    term plus 1. The conjecture is that no matter what value of n, the sequence will always reach 1.

    Note:
        1. Collatz(1) is [1].
        2. returned list sorted in increasing order.

    For example:
    getOddCollatz(5) returns [1, 5] # The collatz sequence for 5 is [5, 16, 8, 4, 2, 1], so the odd numbers are only 1, and 5.
     */
    public List<Integer> getOddCollatz(int n) {
        // Let's think step by step
        // Input: n, a positive integer
        // Output: a sorted list of odd numbers appearing in the Collatz sequence starting at n
        // Sequential structure:
        // 1) Initialize a sorted set to collect unique odd numbers.
        // 2) Initialize a variable "curr" with n.
        // Loop structure:
        // 3) While true, process the current number in the sequence:
        // Branch structure:
        //    a) If "curr" is odd, add it to the set.
        //    b) If "curr" is 1, break out of the loop (sequence ends).
        //    c) Else, update "curr": if even -> curr = curr / 2; else -> curr = 3 * curr + 1.
        // 4) After the loop, convert the sorted set to a list and return it.
        TreeSet<Integer> odds = new TreeSet<>();
        long curr = n; // use long to reduce overflow risk during 3*curr+1
        while (true) {
            if ((curr & 1L) == 1L) {
                odds.add((int) curr);
            }
            if (curr == 1L) {
                break;
            }
            if ((curr & 1L) == 0L) {
                curr = curr / 2L;
            } else {
                curr = 3L * curr + 1L;
            }
        }
        return new ArrayList<>(odds);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.getOddCollatz(14).equals(Arrays.asList(1, 5, 7, 11, 13, 17)),
                s.getOddCollatz(5).equals(Arrays.asList(1, 5)),
                s.getOddCollatz(12).equals(Arrays.asList(1, 3, 5)),
                s.getOddCollatz(1).equals(List.of(1))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}