def unique(l: list):
    """Return sorted unique elements in a list
    >>> unique([5, 3, 5, 2, 3, 3, 9, 0, 123])
    [0, 2, 3, 5, 9, 123]
    """
    # Let's think step by step
    # Input: l, a list possibly containing duplicates
    # Output: a list of sorted unique elements
    # Sequential: Initialize a container to track seen elements
    seen = set()
    # Loop: Iterate through each element in the list
    for x in l:
        # Branch: If the element has not been seen before, record it
        if x not in seen:
            seen.add(x)
    # Sequential: Sort and return the unique elements
    return sorted(seen)



METADATA = {}


def check(unique):
    assert unique([5, 3, 5, 2, 3, 3, 9, 0, 123]) == [0, 2, 3, 5, 9, 123]

check(unique)