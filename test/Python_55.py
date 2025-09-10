def fib(n: int):
    """Return n-th Fibonacci number.
    >>> fib(10)
    55
    >>> fib(1)
    1
    >>> fib(8)
    21
    """
    # Let's think step by step
    # Input: n, an integer
    # Output: n-th Fibonacci number
    # 1. Handle base cases: if n is 0, return 0; if n is 1, return 1
    # 2. Initialize two variables to store previous two Fibonacci numbers
    # 3. Use a loop to calculate Fibonacci numbers from 2 to n
    # 4. In each iteration, compute next Fibonacci number as sum of previous two
    # 5. Update the previous two numbers for next iteration
    # 6. Return the n-th Fibonacci number
    if n == 0:
        return 0
    elif n == 1:
        return 1
    a, b = 0, 1
    for i in range(2, n + 1):
        c = a + b
        a = b
        b = c
    return b



METADATA = {}


def check(fib):
    assert fib(10) == 55
    assert fib(1) == 1
    assert fib(8) == 21
    assert fib(11) == 89
    assert fib(12) == 144

check(fib)