import java.util.*;
import java.lang.*;

class Solution {
    /**
    You are given a list of integers.
    You need to find the largest prime value and return the sum of its digits.

    Examples:
    For lst = [0,3,2,1,3,5,7,4,5,5,5,2,181,32,4,32,3,2,32,324,4,3] the output should be 10
    For lst = [1,0,1,8,2,4597,2,1,3,40,1,2,1,2,4,2,5,1] the output should be 25
    For lst = [1,3,1,32,5107,34,83278,109,163,23,2323,32,30,1,9,3] the output should be 13
    For lst = [0,724,32,71,99,32,6,0,5,91,83,0,5,6] the output should be 11
    For lst = [0,81,12,3,1,21] the output should be 3
    For lst = [0,8,1,2,1,7] the output should be 7
     */
    public int skjkasdkd(List<Integer> lst) {
        // Let's think step by step
        // Input: lst, a list of integers
        // Output: an integer representing the sum of digits of the largest prime in lst
        // Sequential structure:
        // 1. Initialize maxPrime to -1 (no prime found yet).
        // Loop structure:
        // 2. For each number in lst:
        //    - Branch structure:
        //      a) If number is prime and greater than maxPrime, update maxPrime.
        // Sequential structure:
        // 3. If maxPrime is still -1, return 0 (no primes). Otherwise, compute and return sum of digits of maxPrime.
        int maxPrime = -1;
        for (int x : lst) {
            if (isPrime(x) && x > maxPrime) {
                maxPrime = x;
            }
        }
        if (maxPrime == -1) return 0;
        return digitSum(maxPrime);
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if ((n & 1) == 0) return false;
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private int digitSum(int n) {
        int sum = 0;
        n = Math.abs(n);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.skjkasdkd(Arrays.asList(0, 3, 2, 1, 3, 5, 7, 4, 5, 5, 5, 2, 181, 32, 4, 32, 3, 2, 32, 324, 4, 3)) == 10,
                s.skjkasdkd(Arrays.asList(1, 0, 1, 8, 2, 4597, 2, 1, 3, 40, 1, 2, 1, 2, 4, 2, 5, 1)) == 25,
                s.skjkasdkd(Arrays.asList(1, 3, 1, 32, 5107, 34, 83278, 109, 163, 23, 2323, 32, 30, 1, 9, 3)) == 13,
                s.skjkasdkd(Arrays.asList(0, 724, 32, 71, 99, 32, 6, 0, 5, 91, 83, 0, 5, 6)) == 11,
                s.skjkasdkd(Arrays.asList(0, 81, 12, 3, 1, 21)) == 3,
                s.skjkasdkd(Arrays.asList(0, 8, 1, 2, 1, 7)) == 7,
                s.skjkasdkd(List.of(8191)) == 19,
                s.skjkasdkd(Arrays.asList(8191, 123456, 127, 7)) == 19,
                s.skjkasdkd(Arrays.asList(127, 97, 8192)) == 10
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}