def monotonic(l: list):
    """Return True is list elements are monotonically increasing or decreasing.
    >>> monotonic([1, 2, 4, 20])
    True
    >>> monotonic([1, 20, 4, 10])
    False
    >>> monotonic([4, 1, 0, -10])
    True
    """
    # Let's think step by step
    # Input: l, a list of comparable elements
    # Output: True if l is non-decreasing or non-increasing; otherwise False

    # Sequential structure:
    # 1) Handle trivial case: if length < 2, it's monotonic.
    # 2) Initialize two flags: non_decreasing and non_increasing to True.
    if len(l) < 2:
        return True
    non_decreasing = True
    non_increasing = True

    # Loop structure:
    # 3) Iterate through the list comparing each element with its predecessor.
    for i in range(1, len(l)):
        prev, curr = l[i - 1], l[i]
        # Branch structure:
        # - If current > previous, it cannot be non-increasing.
        # - Elif current < previous, it cannot be non-decreasing.
        if curr > prev:
            non_increasing = False
        elif curr < prev:
            non_decreasing = False

        # 4) Early exit if both possibilities are invalid.
        if not non_decreasing and not non_increasing:
            return False

    # 5) Return True if either non-decreasing or non-increasing holds.
    return non_decreasing or non_increasing



METADATA = {}


def check(monotonic):
    assert monotonic([1, 2, 4, 10]) == True
    assert monotonic([1, 2, 4, 20]) == True
    assert monotonic([1, 20, 4, 10]) == False
    assert monotonic([4, 1, 0, -10]) == True
    assert monotonic([4, 1, 1, 0]) == True
    assert monotonic([1, 2, 3, 2, 5, 60]) == False
    assert monotonic([1, 2, 3, 4, 5, 60]) == True
    assert monotonic([9, 9, 9, 9]) == True

check(monotonic)