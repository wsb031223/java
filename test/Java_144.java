import java.util.*;
import java.lang.*;

class Solution {
    /**
    Your task is to implement a function that will simplify the expression
    x * n. The function returns true if x * n evaluates to a whole number and false
    otherwise. Both x and n, are string representation of a fraction, and have the following format,
    <numerator>/<denominator> where both numerator and denominator are positive whole numbers.

    You can assume that x, and n are valid fractions, and do not have zero as denominator.

    simplify("1/5", "5/1") = true
    simplify("1/6", "2/1") = false
    simplify("7/10", "10/2") = false
     */
    public boolean simplify(String x, String n) {
        // Let's think step by step
        // Input: x and n as strings in the form "numerator/denominator"
        // Output: boolean indicating whether (x * n) is a whole number
        // Sequential structure:
        // 1. Parse x and n into numerators and denominators: a/b and c/d.
        // 2. Initialize working variables a1=a, b1=b, c1=c, d1=d as long.
        // Loop structure:
        // 3. Repeatedly cancel common factors between numerators and denominators using gcd:
        //    - Cancel gcd(a1, b1), gcd(a1, d1), gcd(c1, b1), gcd(c1, d1) in a loop until no change.
        // Branch structure:
        // 4. After cancellation, if both denominators b1 and d1 are 1, return true; else return false.
        String[] xs = x.split("/");
        String[] ns = n.split("/");

        long a = Long.parseLong(xs[0]);
        long b = Long.parseLong(xs[1]);
        long c = Long.parseLong(ns[0]);
        long d = Long.parseLong(ns[1]);

        long a1 = a, b1 = b, c1 = c, d1 = d;

        // Loop to ensure all possible cancellations are performed
        boolean changed;
        do {
            changed = false;

            long g;

            g = gcd(a1, b1);
            if (g > 1) {
                a1 /= g;
                b1 /= g;
                changed = true;
            }

            g = gcd(a1, d1);
            if (g > 1) {
                a1 /= g;
                d1 /= g;
                changed = true;
            }

            g = gcd(c1, b1);
            if (g > 1) {
                c1 /= g;
                b1 /= g;
                changed = true;
            }

            g = gcd(c1, d1);
            if (g > 1) {
                c1 /= g;
                d1 /= g;
                changed = true;
            }
        } while (changed);

        // If both denominators reduce to 1, the product is an integer
        return b1 == 1 && d1 == 1;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.simplify("1/5", "5/1") == true,
                s.simplify("1/6", "2/1") == false,
                s.simplify("5/1", "3/1") == true,
                s.simplify("7/10", "10/2") == false,
                s.simplify("2/10", "50/10") == true,
                s.simplify("7/2", "4/2") == true,
                s.simplify("11/6", "6/1") == true,
                s.simplify("2/3", "5/2") == false,
                s.simplify("5/2", "3/5") == false,
                s.simplify("2/4", "8/4") == true,
                s.simplify("2/4", "4/2") == true,
                s.simplify("1/5", "5/1") == true,
                s.simplify("1/5", "1/5") == false
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}