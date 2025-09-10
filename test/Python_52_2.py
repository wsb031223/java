def below_threshold(l: list, t: int):
    """Return True if all numbers in the list l are below threshold t.
    >>> below_threshold([1, 2, 4, 10], 100)
    True
    >>> below_threshold([1, 20, 4, 10], 5)
    False
    """
    # Let's think step by step
    # Input: l (list of numbers), t (threshold integer)
    # Output: Boolean indicating if all numbers in l are strictly less than t
    # Sequential structure:
    # 1) Initialize a flag variable to track if all elements are below t.
    all_below = True
    # Loop structure:
    # 2) Iterate through each element in the list.
    for x in l:
        # Branch structure:
        # 3) If any element is greater than or equal to t, set flag to False and break.
        if x >= t:
            all_below = False
            break
    # Sequential structure:
    # 4) Return the result.
    return all_below



METADATA = {}


def check(below_threshold):
    assert below_threshold([1, 2, 4, 10], 100)
    assert not below_threshold([1, 20, 4, 10], 5)
    assert below_threshold([1, 20, 4, 10], 21)
    assert below_threshold([1, 20, 4, 10], 22)
    assert below_threshold([1, 8, 4, 10], 11)
    assert not below_threshold([1, 8, 4, 10], 10)

check(below_threshold)