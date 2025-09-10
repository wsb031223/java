def incr_list(l: list):
    """Return list with elements incremented by 1.
    >>> incr_list([1, 2, 3])
    [2, 3, 4]
    >>> incr_list([5, 3, 5, 2, 3, 3, 9, 0, 123])
    [6, 4, 6, 3, 4, 4, 10, 1, 124]
    """
    # Let's think step by step
    # Input: l, a list of numbers
    # Output: a new list with each element incremented by 1
    # 1. Sequential: initialize an empty result list.
    # 2. Branch: if the input list is empty, return early to avoid unnecessary work.
    # 3. Loop: iterate over each element in the list:
    #    a) Sequential: compute incremented value as element + 1.
    #    b) Sequential: append the incremented value to the result list.
    # 4. Sequential: return the result list.
    result = []
    if not l:
        return result
    for x in l:
        result.append(x + 1)
    return result



METADATA = {}


def check(incr_list):
    assert incr_list([]) == []
    assert incr_list([3, 2, 1]) == [4, 3, 2]
    assert incr_list([5, 2, 5, 2, 3, 3, 9, 0, 123]) == [6, 3, 6, 3, 4, 4, 10, 1, 124]

check(incr_list)