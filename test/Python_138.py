def is_equal_to_sum_even(n):
    """Evaluate whether the given number n can be written as the sum of exactly 4 positive even numbers
    Example
    is_equal_to_sum_even(4) == False
    is_equal_to_sum_even(6) == False
    is_equal_to_sum_even(8) == True
    """
    # Let's think step by step
    # Sequential structure:
    # 1) The smallest sum of 4 positive even numbers is 2 + 2 + 2 + 2 = 8.
    # 2) The sum of even numbers is even, so n must be even.
    # Branch structure:
    # - If n < 8 or n is odd, immediately return False.
    # Loop structure:
    # - Otherwise, try to construct such a sum by fixing two addends (2 and 2),
    #   then loop over possible even values for the third addend and compute the fourth.
    #   If the fourth is also a positive even number, return True.

    # Sequential computations
    min_sum = 8
    is_even = (n % 2 == 0)

    # Branch: quick impossibility checks
    if n < min_sum or not is_even:
        return False

    # Loop: constructively search for a valid decomposition
    a = 2
    b = 2
    for c in range(2, n - a - b, 2):
        d = n - (a + b + c)
        if d >= 2 and d % 2 == 0:
            return True

    # Fallback (should not be reached given the math, but for completeness)
    return False

def check(is_equal_to_sum_even):
    assert is_equal_to_sum_even(4) == False
    assert is_equal_to_sum_even(6) == False
    assert is_equal_to_sum_even(8) == True
    assert is_equal_to_sum_even(10) == True
    assert is_equal_to_sum_even(11) == False
    assert is_equal_to_sum_even(12) == True
    assert is_equal_to_sum_even(13) == False
    assert is_equal_to_sum_even(16) == True

check(is_equal_to_sum_even)