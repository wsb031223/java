def circular_shift(x, shift):
    """Circular shift the digits of the integer x, shift the digits right by shift
    and return the result as a string.
    If shift > number of digits, return digits reversed.
    >>> circular_shift(12, 1)
    "21"
    >>> circular_shift(12, 2)
    "12"
    """
    # Let's think step by step
    # 1. Convert the integer to a string to get its digits
    # 2. Calculate the number of digits
    # 3. If shift is greater than number of digits, return reversed string
    # 4. Otherwise, perform circular shift by splitting and recombining
    s = str(x)
    n = len(s)
    if shift > n:
        return s[::-1]
    else:
        shift = shift % n
        return s[-shift:] + s[:-shift]

def check(circular_shift):

    # Check some simple cases
    assert circular_shift(100, 2) == "001"
    assert circular_shift(12, 2) == "12"
    assert circular_shift(97, 8) == "79"
    assert circular_shift(12, 1) == "21", "This prints if this assert fails 1 (good for debugging!)"

    # Check some edge cases that are easy to work out by hand.
    assert circular_shift(11, 101) == "11", "This prints if this assert fails 2 (also good for debugging!)"

check(circular_shift)