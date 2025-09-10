def get_positive(l: list):
    """Return only positive numbers in the list.
    >>> get_positive([-1, 2, -4, 5, 6])
    [2, 5, 6]
    >>> get_positive([5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10])
    [5, 3, 2, 3, 9, 123, 1]
    """
    # Let's think step by step
    # Input: l, a list of numbers
    # Output: a new list containing only positive numbers
    # 1. Initialize an empty list for positive numbers
    # 2. Loop through each element in the input list
    # 3. For each element, check if it's positive (greater than 0)
    # 4. If positive, add it to the result list
    # 5. Return the result list
    result = []
    for num in l:
        if num > 0:
            result.append(num)
    return result



METADATA = {}


def check(get_positive):
    assert get_positive([-1, -2, 4, 5, 6]) == [4, 5, 6]
    assert get_positive([5, 3, -5, 2, 3, 3, 9, 0, 123, 1, -10]) == [5, 3, 2, 3, 3, 9, 123, 1]
    assert get_positive([-1, -2]) == []
    assert get_positive([]) == []

check(get_positive)