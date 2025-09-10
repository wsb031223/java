def closest_integer(value):
    '''
    Create a function that takes a value (string) representing a number
    and returns the closest integer to it. If the number is equidistant
    from two integers, round it away from zero.

    Examples
    >>> closest_integer("10")
    10
    >>> closest_integer("15.3")
    15

    Note:
    Rounding away from zero means that if the given number is equidistant
    from two integers, the one you should return is the one that is the
    farthest from zero. For example closest_integer("14.5") should
    return 15 and closest_integer("-14.5") should return -15.
    '''
    # Let's think step by step
    # 1. Convert the string value to a float
    # 2. Check if the number is equidistant from two integers (ends with .5)
    # 3. If equidistant, round away from zero
    # 4. Otherwise, round to the nearest integer using standard rounding
    num = float(value)
    if num >= 0:
        if num % 1 == 0.5:
            return int(num) + 1
        else:
            return round(num)
    else:
        if num % 1 == -0.5:
            return int(num) - 1
        else:
            return round(num)

def check(closest_integer):

    # Check some simple cases
    assert closest_integer("10") == 10, "Test 1"
    assert closest_integer("14.5") == 15, "Test 2"
    assert closest_integer("-15.5") == -16, "Test 3"
    assert closest_integer("15.3") == 15, "Test 3"

    # Check some edge cases that are easy to work out by hand.
    assert closest_integer("0") == 0, "Test 0"

check(closest_integer)