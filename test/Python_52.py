def below_threshold(l: list, t: int):
    """Return True if all numbers in the list l are below threshold t.
    >>> below_threshold([1, 2, 4, 10], 100)
    True
    >>> below_threshold([1, 20, 4, 10], 5)
    False
    """
    # Let's think step by step
    # Input: l (list of numbers), t (threshold integer)
    # Output: Boolean value
    # 1. Initialize a loop to iterate through each element in the list
    # 2. For each element, check if it is greater than or equal to the threshold
    # 3. If any element is found that is >= threshold, return False immediately
    # 4. If all elements are below threshold, return True after the loop
    for num in l:
        if num >= t:
            return False
    return True



METADATA = {}


def check(below_threshold):
    assert below_threshold([1, 2, 4, 10], 100)
    assert not below_threshold([1, 20, 4, 10], 5)
    assert below_threshold([1, 20, 4, 10], 21)
    assert below_threshold([1, 20, 4, 10], 22)
    assert below_threshold([1, 8, 4, 10], 11)
    assert not below_threshold([1, 8, 4, 10], 10)

check(below_threshold)