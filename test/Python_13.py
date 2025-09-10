def greatest_common_divisor(a: int, b: int) -> int:
    """ Return a greatest common divisor of two integers a and b
    >>> greatest_common_divisor(3, 5)
    1
    >>> greatest_common_divisor(25, 15)
    5
    """
    # Let's think step by step
    # Input: two integers a and b
    # Output: greatest common divisor
    # 1. If b is 0, return a
    # 2. Otherwise, recursively call the function with b and a % b
    if b == 0:
        return a
    else:
        return greatest_common_divisor(b, a % b)



METADATA = {
    'author': 'jt',
    'dataset': 'test'
}


def check(greatest_common_divisor):
    assert greatest_common_divisor(3, 7) == 1
    assert greatest_common_divisor(10, 15) == 5
    assert greatest_common_divisor(49, 14) == 7
    assert greatest_common_divisor(144, 60) == 12

check(greatest_common_divisor)