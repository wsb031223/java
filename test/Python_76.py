def is_simple_power(x, n):
    """Your task is to write a function that returns true if a number x is a simple
    power of n and false in other cases.
    x is a simple power of n if n**int=x
    For example:
    is_simple_power(1, 4) => true
    is_simple_power(2, 2) => true
    is_simple_power(8, 2) => true
    is_simple_power(3, 2) => false
    is_simple_power(3, 1) => false
    is_simple_power(5, 3) => false
    """
    # Let's think step by step
    # Input: x, n (integers)
    # Output: boolean
    # 1) Sequential steps:
    #    - Handle special/base cases (x == 1, n in {1, -1, 0}, x == 0).
    #    - Reduce x by repeatedly dividing by n if divisible.
    #    - Check if x reduces to 1.
    # 2) Branch structure:
    #    - If x == 1 -> True (since n**0 == 1 for any n, by convention).
    #    - Elif n == 1 -> True only if x == 1.
    #    - Elif n == -1 -> True only if x is 1 or -1.
    #    - Elif n == 0 -> True if x == 1 (0**0 in Python is 1) or x == 0 (0**k, k>=1).
    #    - Elif x == 0 -> False for any nonzero n.
    # 3) Loop structure:
    #    - While x is divisible by n (x % n == 0), set x = x // n.
    #    - After loop, return True if x == 1, else False.
    # Write your code here
    # Branch: special/base cases
    if x == 1:
        return True
    if n == 1:
        return x == 1
    if n == -1:
        return x in (1, -1)
    if n == 0:
        return x == 0 or x == 1
    if x == 0:
        return False

    # Loop: reduce x by dividing by n when divisible
    while x % n == 0:
        x //= n

    # Final check
    return x == 1

def check(is_simple_power):

    # Check some simple cases
    assert is_simple_power(1, 4)== True, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(2, 2)==True, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(8, 2)==True, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(3, 2)==False, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(3, 1)==False, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(5, 3)==False, "This prints if this assert fails 1 (good for debugging!)"
    # Check some simple cases
    assert is_simple_power(16, 2)== True, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(143214, 16)== False, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(4, 2)==True, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(9, 3)==True, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(16, 4)==True, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(24, 2)==False, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(128, 4)==False, "This prints if this assert fails 1 (good for debugging!)"
    assert is_simple_power(12, 6)==False, "This prints if this assert fails 1 (good for debugging!)"

    # Check some edge cases that are easy to work out by hand.
    assert is_simple_power(1, 1)==True, "This prints if this assert fails 2 (also good for debugging!)"
    assert is_simple_power(1, 12)==True, "This prints if this assert fails 2 (also good for debugging!)"

check(is_simple_power)