def add(lst):
    """Given a non-empty list of integers lst. add the even elements that are at odd indices..


    Examples:
        add([4, 2, 6, 7]) ==> 2 
    """
    # Let's think step by step
    # Input: lst, a non-empty list of integers
    # Output: total, the sum of even elements at odd indices
    # 1. Initialize an accumulator 'total' to 0. (sequential)
    # 2. Loop through indices from 0 to len(lst) - 1. (loop)
    # 3. If the index is odd and the element at that index is even, add it to 'total'. (branch)
    # 4. Return 'total'. (sequential)
    total = 0
    for i in range(len(lst)):
        if i % 2 == 1 and lst[i] % 2 == 0:
            total += lst[i]
    return total

def check(add):

    # Check some simple cases
    assert add([4, 88]) == 88
    assert add([4, 5, 6, 7, 2, 122]) == 122
    assert add([4, 0, 6, 7]) == 0
    assert add([4, 4, 6, 8]) == 12

    # Check some edge cases that are easy to work out by hand.

check(add)