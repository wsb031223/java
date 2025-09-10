def simplify(x, n):
    """Your task is to implement a function that will simplify the expression
    x * n. The function returns True if x * n evaluates to a whole number and False
    otherwise. Both x and n, are string representation of a fraction, and have the following format,
    <numerator>/<denominator> where both numerator and denominator are positive whole numbers.

    You can assume that x, and n are valid fractions, and do not have zero as denominator.

    simplify("1/5", "5/1") = True
    simplify("1/6", "2/1") = False
    simplify("7/10", "10/2") = False
    """
    # Let's think step by step
    # Input: x, n as strings like "a/b"
    # Output: True if (a1/b1) * (a2/b2) is a whole number, else False
    # 1) Sequential structure:
    #    - Parse x and n into numerators and denominators.
    #    - Compute the combined numerator and denominator of the product.
    # 2) Loop structure:
    #    - Repeatedly divide numerator and denominator by their gcd until no common factor remains.
    # 3) Branch structure:
    #    - If the final denominator equals 1, return True; otherwise return False.

    # Write your code here
    from math import gcd

    # Parse the input fractions
    a1_str, b1_str = x.split("/")
    a2_str, b2_str = n.split("/")
    a1, b1 = int(a1_str), int(b1_str)
    a2, b2 = int(a2_str), int(b2_str)

    # Compute product numerator and denominator
    num = a1 * a2
    den = b1 * b2

    # Reduce fraction by cancelling common factors using gcd in a loop
    while True:
        g = gcd(num, den)
        if g == 1:
            break
        num //= g
        den //= g

    # Check if the result is a whole number (denominator == 1)
    if den == 1:
        return True
    else:
        return False

def check(simplify):

    # Check some simple cases
    assert simplify("1/5", "5/1") == True, 'test1'
    assert simplify("1/6", "2/1") == False, 'test2'
    assert simplify("5/1", "3/1") == True, 'test3'
    assert simplify("7/10", "10/2") == False, 'test4'
    assert simplify("2/10", "50/10") == True, 'test5'
    assert simplify("7/2", "4/2") == True, 'test6'
    assert simplify("11/6", "6/1") == True, 'test7'
    assert simplify("2/3", "5/2") == False, 'test8'
    assert simplify("5/2", "3/5") == False, 'test9'
    assert simplify("2/4", "8/4") == True, 'test10'


    # Check some edge cases that are easy to work out by hand.
    assert simplify("2/4", "4/2") == True, 'test11'
    assert simplify("1/5", "5/1") == True, 'test12'
    assert simplify("1/5", "1/5") == False, 'test13'

check(simplify)