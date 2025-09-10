def median(l: list):
    """Return median of elements in the list l.
    >>> median([3, 1, 2, 4, 5])
    3
    >>> median([-10, 4, 6, 1000, 10, 20])
    15.0
    """
    # Let's think step by step
    # Sequential structure:
    # 1) Create a new list 'arr' and copy elements from the input list.
    # 2) Compute the length 'n' of arr.
    # 3) Sort 'arr' in non-decreasing order.
    # 4) Compute the middle index 'mid'.
    #
    # Branch structure:
    # - If n == 0: raise an error because median is undefined for empty lists.
    # - If n is odd: return the middle element.
    # - Else (n is even): return the average of the two middle elements.
    #
    # Loop structure:
    # - Use a loop to copy elements from the input list into 'arr'.
    arr = []
    for x in l:
        arr.append(x)

    n = len(arr)
    if n == 0:
        raise ValueError("median() arg is an empty list")

    arr.sort()
    mid = n // 2
    if n % 2 == 1:
        return arr[mid]
    else:
        return (arr[mid - 1] + arr[mid]) / 2



METADATA = {}


def check(median):
    assert median([3, 1, 2, 4, 5]) == 3
    assert median([-10, 4, 6, 1000, 10, 20]) == 8.0
    assert median([5]) == 5
    assert median([6, 5]) == 5.5
    assert median([8, 1, 3, 9, 9, 2, 7]) == 7

check(median)