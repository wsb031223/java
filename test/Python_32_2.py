import math


def poly(xs: list, x: float):
    """
    Evaluates polynomial with coefficients xs at point x.
    return xs[0] + xs[1] * x + xs[1] * x^2 + .... xs[n] * x^n
    """
    return sum([coeff * math.pow(x, i) for i, coeff in enumerate(xs)])


def find_zero(xs: list):
    """ xs are coefficients of a polynomial.
    find_zero find x such that poly(x) = 0.
    find_zero returns only only zero point, even if there are many.
    Moreover, find_zero only takes list xs having even number of coefficients
    and largest non zero coefficient as it guarantees
    a solution.
    >>> round(find_zero([1, 2]), 2) # f(x) = 1 + 2x
    -0.5
    >>> round(find_zero([-6, 11, -6, 1]), 2) # (x - 1) * (x - 2) * (x - 3) = -6 + 11x - 6x^2 + x^3
    1.0
    """
    # Let's think step by step
    # Input: xs, a list of polynomial coefficients
    # Output: a float x such that poly(xs, x) = 0 (one real root)
    # Sequential structure:
    # 1) Clean and validate input (ensure leading coefficient non-zero and even number of coefficients).
    # 2) Define helper function f(x) to evaluate the polynomial.
    # 3) Attempt to find a bracketing interval [-R, R] with a sign change f(-R) * f(R) <= 0.
    # Branch structure:
    # - If polynomial is invalid or no bracket is found within limits, raise an error.
    # - If an endpoint evaluates exactly to zero, return it immediately.
    # Loop structure:
    # - Loop to expand the search radius exponentially until a sign change is found.
    # - Loop to apply the bisection method to converge to a root within a tolerance.
    # Finally, return the approximated root.

    # Clean and validate coefficients: remove trailing zeros to identify true degree
    coeffs = list(xs)
    while len(coeffs) > 1 and coeffs[-1] == 0:
        coeffs.pop()

    if not coeffs or (len(coeffs) == 1 and coeffs[0] != 0):
        raise ValueError("Polynomial must be non-constant.")

    # Leading coefficient must be non-zero
    if coeffs[-1] == 0:
        raise ValueError("Leading coefficient must be non-zero.")

    # Expect an odd-degree polynomial (even number of coefficients) for guaranteed real root
    if len(coeffs) % 2 != 0:
        raise ValueError("find_zero expects an odd-degree polynomial (even number of coefficients).")

    def f(t: float) -> float:
        return poly(coeffs, t)

    # Quick check at x = 0
    f0 = f(0.0)
    if f0 == 0.0:
        return 0.0

    # Find a bracket [-R, R] such that f(-R) * f(R) <= 0
    radius = 1.0
    fa = f(-radius)
    if fa == 0.0:
        return -radius
    fb = f(radius)
    if fb == 0.0:
        return radius

    max_expand = 64
    for _ in range(max_expand):
        if fa * fb <= 0.0:
            break
        radius *= 2.0
        fa = f(-radius)
        if fa == 0.0:
            return -radius
        fb = f(radius)
        if fb == 0.0:
            return radius
    else:
        # No bracketing interval found
        raise ValueError("Failed to bracket a root; input might not satisfy the guarantee.")

    # Bisection method
    a, b = -radius, radius
    fa, fb = f(a), f(b)
    tol = 1e-12
    max_iter = 100

    for _ in range(max_iter):
        m = 0.5 * (a + b)
        fm = f(m)
        if fm == 0.0 or 0.5 * (b - a) < tol:
            return m
        if fa * fm <= 0.0:
            b, fb = m, fm
        else:
            a, fa = m, fm

    return 0.5 * (a + b)



METADATA = {}


def check(find_zero):
    import math
    import random
    rng = random.Random(42)
    import copy
    for _ in range(100):
        ncoeff = 2 * rng.randint(1, 4)
        coeffs = []
        for _ in range(ncoeff):
            coeff = rng.randint(-10, 10)
            if coeff == 0:
                coeff = 1
            coeffs.append(coeff)
        solution = find_zero(copy.deepcopy(coeffs))
        assert math.fabs(poly(coeffs, solution)) < 1e-4

check(find_zero)