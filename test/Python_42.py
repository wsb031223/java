def incr_list(l: list):
    """Return list with elements incremented by 1.
    >>> incr_list([1, 2, 3])
    [2, 3, 4]
    >>> incr_list([5, 3, 5, 2, 3, 3, 9, 0, 123])
    [6, 4, 6, 3, 4, 4, 10, 1, 124]
    """
    # Let's think step by step
    # Input: l, a list of integers
    # Output: a new list with each element incremented by 1
    # 1. Initialize an empty list for the result
    # 2. Loop through each element in the input list
    # 3. For each element, add 1 to it and append to result list
    # 4. Return the result list
    result = []
    for num in l:
        result.append(num + 1)
    return result



METADATA = {}


def check(incr_list):
    assert incr_list([]) == []
    assert incr_list([3, 2, 1]) == [4, 3, 2]
    assert incr_list([5, 2, 5, 2, 3, 3, 9, 0, 123]) == [6, 3, 6, 3, 4, 4, 10, 1, 124]

check(incr_list)