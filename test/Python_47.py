def median(l: list):
    """Return median of elements in the list l.
    >>> median([3, 1, 2, 4, 5])
    3
    >>> median([-10, 4, 6, 1000, 10, 20])
    15.0
    """
    # Let's think step by step
    # Input: l, a list of numbers
    # Output: median value (int or float)
    # 1. Sort the list in ascending order (sequential)
    # 2. Check if the list length is odd or even (branch)
    # 3. If odd: return the middle element
    # 4. If even: return the average of two middle elements
    # 5. Return the result
    
    sorted_l = sorted(l)
    n = len(sorted_l)
    mid = n // 2
    
    if n % 2 == 1:
        return sorted_l[mid]
    else:
        return (sorted_l[mid - 1] + sorted_l[mid]) / 2



METADATA = {}


def check(median):
    assert median([3, 1, 2, 4, 5]) == 3
    assert median([-10, 4, 6, 1000, 10, 20]) == 8.0
    assert median([5]) == 5
    assert median([6, 5]) == 5.5
    assert median([8, 1, 3, 9, 9, 2, 7]) == 7

check(median)