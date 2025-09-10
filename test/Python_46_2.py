def fib4(n: int):
    """The Fib4 number sequence is a sequence similar to the Fibbonacci sequnece that's defined as follows:
    fib4(0) -> 0
    fib4(1) -> 0
    fib4(2) -> 2
    fib4(3) -> 0
    fib4(n) -> fib4(n-1) + fib4(n-2) + fib4(n-3) + fib4(n-4).
    Please write a function to efficiently compute the n-th element of the fib4 number sequence.  Do not use recursion.
    >>> fib4(5)
    4
    >>> fib4(6)
    8
    >>> fib4(7)
    14
    """
    # Let's think step by step
    # Rough problem-solving process using three programming structures:
    # - Sequential: Establish base known values f0=0, f1=0, f2=2, f3=0 and set up a rolling window.
    # - Branch: Handle invalid inputs (negative) and small n (n <= 3) by returning known values.
    # - Loop: For i from 4 to n, iteratively compute the next value as the sum of the previous four and slide the window.
    # Input: n (int)
    # Output: fib4(n) (int)

    # Branch: validate input
    if n < 0:
        raise ValueError("n must be non-negative")

    # Branch: base cases
    if n == 0:
        return 0
    elif n == 1:
        return 0
    elif n == 2:
        return 2
    elif n == 3:
        return 0

    # Sequential: initialize rolling window for f0..f3
    f0, f1, f2, f3 = 0, 0, 2, 0

    # Loop: compute iteratively from 4 to n
    for _ in range(4, n + 1):
        nxt = f0 + f1 + f2 + f3
        f0, f1, f2, f3 = f1, f2, f3, nxt

    return f3



METADATA = {}


def check(fib4):
    assert fib4(5) == 4
    assert fib4(8) == 28
    assert fib4(10) == 104
    assert fib4(12) == 386

check(fib4)