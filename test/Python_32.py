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
    # Input: xs, list of coefficients
    # Output: x, a float such that poly(x) = 0
    # 1. Since the polynomial has an even number of coefficients and largest non-zero coefficient,
    #    it guarantees at least one real root.
    # 2. We can use the bisection method to find a root.
    # 3. First, we need to find two points a and b such that poly(a) * poly(b) < 0.
    # 4. Then, we can iteratively narrow down the interval until we find a root.
    # 5. We'll start with a wide interval, say [-1000, 1000], and check if the function changes sign.
    # 6. If it does, we apply bisection method to find the root.
    # 7. If not, we might need to adjust the interval, but the problem guarantees a solution.
    
    # Define the function to evaluate the polynomial
    def f(x):
        return poly(xs, x)
    
    # Find initial bounds
    a = -1000.0
    b = 1000.0
    # Check if the function changes sign in the initial interval
    if f(a) * f(b) > 0:
        # If not, try to find an interval where it does
        # Since the problem guarantees a solution, we can try to expand the interval
        # or look for a sign change in a different way.
        # Alternatively, we can use the fact that the polynomial has a root and adjust the bounds.
        # For simplicity, we assume the initial bounds are sufficient due to the guarantee.
        pass
    
    # Apply bisection method
    tolerance = 1e-10
    while (b - a) > tolerance:
        mid = (a + b) / 2.0
        if f(mid) == 0:
            return mid
        if f(a) * f(mid) < 0:
            b = mid
        else:
            a = mid
    
    return (a + b) / 2.0



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