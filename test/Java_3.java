import java.util.*;
import java.lang.*;

class Solution {
    /**
    You're given a list of deposit and withdrawal operations on a bank account that starts with
    zero balance. Your task is to detect if at any point the balance of account fallls below zero, and
    at that point function should return True. Otherwise it should return False.
    >>> belowZero(Arrays.asList(1, 2, 3))
    false
    >>> belowZero(Arrays.asList(1, 2, -4, 5))
    true
     */
    public boolean belowZero(List<Integer> operations) {
        // Let's think step by step
        // Input: operations, a list of integers representing deposits(+)/withdrawals(-)
        // Output: boolean indicating whether the running balance ever drops below zero

        // Sequential structure:
        // 1. Initialize running balance to 0.
        // 2. If the operations list is null or empty, return false (no operations means never below zero).

        // Loop structure:
        // 3. Iterate through each operation amount in the list and update the balance.

        // Branch structure:
        // 4. After each update, if balance < 0, return true immediately.
        // 5. If loop completes without balance < 0, return false.

        int balance = 0;
        if (operations == null || operations.isEmpty()) {
            return false;
        }
        for (Integer op : operations) {
            if (op != null) {
                balance += op;
            }
            if (balance < 0) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.belowZero(new ArrayList<>(Arrays.asList())),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -3, 1, 2, -3))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -4, 5, 6))),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}