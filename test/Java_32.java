import java.util.*;
import java.lang.*;

class Solution {
    /**
    Evaluates polynomial with coefficients xs at point x.
    return xs[0] + xs[1] * x + xs[1] * x^2 + .... xs[n] * x^n
     */
    public double poly(List<Double> xs, double x) {
        double result = 0;
        for (int i = 0; i < xs.size(); i++) {
            result += xs.get(i) * Math.pow(x, i);
        }
        return result;
    }
    
    /**
    xs are coefficients of a polynomial.
    findZero find x such that poly(x) = 0.
    findZero returns only only zero point, even if there are many.
    Moreover, findZero only takes list xs having even number of coefficients
    and largest non zero coefficient as it guarantees
    a solution.
    >>> findZero(Arrays.asList(1, 2)) // f(x) = 1 + 2x
    -0.5
    >>> findZero(Arrays.asList(-6, 11, -6, 1)) // (x - 1) * (x - 2) * (x - 3) = -6 + 11x - 6x^2 + x^3
    1.0
     */
    public double findZero(List<Double> xs) {
        // Let's think step by step
        // Input: xs, a List<Double> of polynomial coefficients with even size and non-zero leading coefficient
        // Output: a double value r such that poly(xs, r) == 0 (approximately)
        // Sequential structure:
        // 1) Validate that xs is non-empty, has even length, and its last coefficient is non-zero.
        // 2) Initialize a symmetric search interval [-range, range] with range = 1.0 and evaluate f(a), f(b).
        // Loop structure:
        // 3) While f(a) and f(b) have the same sign, expand the interval by doubling its size.
        // Branch structure:
        // 4) If an endpoint evaluates to zero, return it. Otherwise, apply the bisection method:
        //    - Compute midpoint, evaluate function, choose the half-interval that keeps a sign change.
        // 5) Stop when the function value is small or the interval is sufficiently tight, and return the midpoint.

        if (xs == null || xs.isEmpty()) {
            throw new IllegalArgumentException("xs must be non-empty");
        }
        if ((xs.size() & 1) != 0) {
            throw new IllegalArgumentException("xs must have an even number of coefficients (odd degree)");
        }
        double leading = xs.get(xs.size() - 1);
        if (leading == 0.0) {
            throw new IllegalArgumentException("Leading coefficient must be non-zero");
        }

        // Step 2: Initialize bracket
        double a = -1.0;
        double b = 1.0;
        double fa = poly(xs, a);
        double fb = poly(xs, b);

        if (fa == 0.0) return a;
        if (fb == 0.0) return b;

        // Step 3: Expand interval until sign change
        int expandIters = 0;
        while (fa * fb > 0.0 && expandIters < 60) { // 2^60 is huge; should bracket for odd-degree polynomials
            a *= 2.0;
            b *= 2.0;
            fa = poly(xs, a);
            fb = poly(xs, b);
            expandIters++;
        }

        if (fa == 0.0) return a;
        if (fb == 0.0) return b;

        if (fa * fb > 0.0) {
            // Fallback attempt (shouldn't occur for valid inputs per spec)
            return Double.NaN;
        }

        // Step 4: Bisection method
        double left = a, right = b;
        double fLeft = fa, fRight = fb;
        double tol = 1e-12;

        for (int iter = 0; iter < 200; iter++) {
            double mid = 0.5 * (left + right);
            double fMid = poly(xs, mid);

            if (Math.abs(fMid) <= tol) {
                return mid;
            }

            // Choose the subinterval that retains a sign change
            if (fLeft * fMid <= 0.0) {
                right = mid;
                fRight = fMid;
            } else {
                left = mid;
                fLeft = fMid;
            }

            if (Math.abs(right - left) <= tol * Math.max(1.0, Math.max(Math.abs(left), Math.abs(right)))) {
                return 0.5 * (left + right);
            }
        }

        return 0.5 * (left + right);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Random rand = new Random(42);
        for (int i = 0; i < 100; i++) {
            int ncoeff = 2 * (rand.nextInt(3) + 1);
            List<Double> coeffs = new ArrayList<>();
            for (int j = 0; j < ncoeff; j++) {
                int coeff = rand.nextInt(20) - 10;
                if (coeff == 0) {
                    coeff = 1;
                }
                coeffs.add((double) coeff);
            }
            double solution = s.findZero(coeffs);
            if (Math.abs(s.poly(coeffs, solution)) > 1e-4) {
                throw new AssertionError();
            }
        }
    }
}