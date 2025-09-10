def max_element(l: list):
    """Return maximum element in the list.
    >>> max_element([1, 2, 3])
    3
    >>> max_element([5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10])
    123
    """
    # Let's think step by step
    # Input: l, a list of numbers
    # Output: maximum element in l
    # Sequential structure:
    # 1. If the list is empty, raise an error since there is no maximum.
    # 2. Initialize max_val with the first element of the list.
    # Loop structure:
    # 3. Iterate over the remaining elements of the list.
    # Branch structure:
    # 4. For each element, if it is greater than max_val, update max_val.
    # 5. After the loop, return max_val.
    if not l:
        raise ValueError("max_element() arg is an empty list")
    max_val = l[0]
    for x in l[1:]:
        if x > max_val:
            max_val = x
    return max_val



METADATA = {}


def check(max_element):
    assert max_element([1, 2, 3]) == 3
    assert max_element([5, 3, -5, 2, -3, 3, 9, 0, 124, 1, -10]) == 124

check(max_element)