def prod_signs(arr):
    """
    You are given an array arr of integers and you need to return
    sum of magnitudes of integers multiplied by product of all signs
    of each number in the array, represented by 1, -1 or 0.
    Note: return None for empty arr.

    Example:
    >>> prod_signs([1, 2, 2, -4]) == -9
    >>> prod_signs([0, 1]) == 0
    >>> prod_signs([]) == None
    """
    # Let's think step by step
    # Input: arr, a list of integers
    # Output: integer (or None for empty arr)
    # Plan using sequential, branch, and loop:
    # 1. Branch: If arr is empty, return None.
    # 2. Sequential: Initialize sum_mag = 0 and sign_prod = 1.
    # 3. Loop: For each x in arr:
    # 4.   Sequential: Add abs(x) to sum_mag.
    # 5.   Branch: Determine sign of x: -1 if x < 0, 1 if x > 0, 0 if x == 0.
    # 6.   Sequential: Multiply sign_prod by the sign.
    # 7. Branch: If a zero is encountered (sign becomes 0), return 0 immediately.
    # 8. Sequential: After loop, return sum_mag * sign_prod.

    if not arr:
        return None

    sum_mag = 0
    sign_prod = 1

    for x in arr:
        sum_mag += abs(x)
        if x == 0:
            return 0
        elif x > 0:
            sign = 1
        else:
            sign = -1
        sign_prod *= sign

    return sum_mag * sign_prod

def check(prod_signs):

    # Check some simple cases
    assert True, "This prints if this assert fails 1 (good for debugging!)"
    assert prod_signs([1, 2, 2, -4]) == -9
    assert prod_signs([0, 1]) == 0
    assert prod_signs([1, 1, 1, 2, 3, -1, 1]) == -10
    assert prod_signs([]) == None
    assert prod_signs([2, 4,1, 2, -1, -1, 9]) == 20
    assert prod_signs([-1, 1, -1, 1]) == 4
    assert prod_signs([-1, 1, 1, 1]) == -4
    assert prod_signs([-1, 1, 1, 0]) == 0

    # Check some edge cases that are easy to work out by hand.
    assert True, "This prints if this assert fails 2 (also good for debugging!)"

check(prod_signs)