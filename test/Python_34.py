def unique(l: list):
    """Return sorted unique elements in a list
    >>> unique([5, 3, 5, 2, 3, 3, 9, 0, 123])
    [0, 2, 3, 5, 9, 123]
    """
    # Let's think step by step
    # Input: l, a list of elements
    # Output: sorted list of unique elements
    # 1. Create an empty set to store unique elements
    # 2. Loop through each element in the input list
    # 3. Add each element to the set (duplicates are automatically removed)
    # 4. Convert the set to a list
    # 5. Sort the list
    # 6. Return the sorted list
    unique_set = set()
    for item in l:
        unique_set.add(item)
    result = list(unique_set)
    result.sort()
    return result



METADATA = {}


def check(unique):
    assert unique([5, 3, 5, 2, 3, 3, 9, 0, 123]) == [0, 2, 3, 5, 9, 123]

check(unique)