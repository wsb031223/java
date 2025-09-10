def change_base(x: int, base: int):
    """Change numerical base of input number x to base.
    return string representation after the conversion.
    base numbers are less than 10.
    >>> change_base(8, 3)
    '22'
    >>> change_base(8, 2)
    '1000'
    >>> change_base(7, 2)
    '111'
    """
    # Let's think step by step
    # Input: x (int), base (int)
    # Output: a string representing x in the given base
    # Sequential structure:
    # 1) Validate the base and set up variables (sign, working copy of x, storage for digits).
    # 2) Prepare to collect converted digits.
    # Branch structure:
    # - If base is invalid (not between 2 and 9), raise an error.
    # - If x is 0, return "0".
    # - If x is negative, remember the sign and convert its absolute value.
    # Loop structure:
    # - While the working number > 0: compute remainder by base, store digit, and divide the number by base.
    # Finally, reverse the digits, add the sign if needed, and return the result.
    if not (2 <= base < 10):
        raise ValueError("base must be between 2 and 9 inclusive")

    if x == 0:
        return "0"

    negative = x < 0
    n = -x if negative else x

    digits = []
    while n > 0:
        r = n % base
        digits.append(str(r))
        n //= base

    digits.reverse()
    result = "".join(digits)
    if negative:
        result = "-" + result
    return result



METADATA = {}


def check(change_base):
    assert change_base(8, 3) == "22"
    assert change_base(9, 3) == "100"
    assert change_base(234, 2) == "11101010"
    assert change_base(16, 2) == "10000"
    assert change_base(8, 2) == "1000"
    assert change_base(7, 2) == "111"
    for x in range(2, 8):
        assert change_base(x, x + 1) == str(x)

check(change_base)