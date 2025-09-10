def get_positive(l: list):
    """Return only positive numbers in the list.
    >>> get_positive([-1, 2, -4, 5, 6])
    [2, 5, 6]
    >>> get_positive([5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10])
    [5, 3, 2, 3, 9, 123, 1]
    """
    # Let's think step by step
    # Input: l, a list of numbers
    # Output: a list containing only the positive numbers from l, preserving order
    # Sequential: initialize a result container
    result = []
    # Loop: iterate through each element in the input list
    for x in l:
        # Branch: check if the current element is strictly positive
        if x > 0:
            # Sequential: append positive elements to the result
            result.append(x)
    # Sequential: return the filtered list
    return result



METADATA = {}


def check(get_positive):
    assert get_positive([-1, -2, 4, 5, 6]) == [4, 5, 6]
    assert get_positive([5, 3, -5, 2, 3, 3, 9, 0, 123, 1, -10]) == [5, 3, 2, 3, 3, 9, 123, 1]
    assert get_positive([-1, -2]) == []
    assert get_positive([]) == []

check(get_positive)