def will_it_fly(q,w):
    '''
    Write a function that returns True if the object q will fly, and False otherwise.
    The object q will fly if it's balanced (it is a palindromic list) and the sum of its elements is less than or equal the maximum possible weight w.

    Example:
    will_it_fly([1, 2], 5) ➞ False 
    # 1+2 is less than the maximum possible weight, but it's unbalanced.

    will_it_fly([3, 2, 3], 1) ➞ False
    # it's balanced, but 3+2+3 is more than the maximum possible weight.

    will_it_fly([3, 2, 3], 9) ➞ True
    # 3+2+3 is less than the maximum possible weight, and it's balanced.

    will_it_fly([3], 5) ➞ True
    # 3 is less than the maximum possible weight, and it's balanced.
    '''
    # Let's think step by step
    # Input: q (list of numbers), w (maximum allowed weight, int)
    # Output: True if q is palindromic and sum(q) <= w, else False
    # 1. Initialize variables (sequential): total sum = 0, and a flag 'balanced' = True.
    # 2. Loop to compute the total sum of elements in q.
    # 3. Loop to check if q is palindromic by comparing symmetric elements.
    # 4. Branch to return True only if balanced and total <= w; otherwise return False.
    # Write your code here
    total = 0
    for value in q:
        total += value

    balanced = True
    left, right = 0, len(q) - 1
    while left < right:
        if q[left] != q[right]:
            balanced = False
            break
        left += 1
        right -= 1

    if balanced and total <= w:
        return True
    else:
        return False

def check(will_it_fly):

    # Check some simple cases
    assert will_it_fly([3, 2, 3], 9) is True
    assert will_it_fly([1, 2], 5) is False
    assert will_it_fly([3], 5) is True
    assert will_it_fly([3, 2, 3], 1) is False


    # Check some edge cases that are easy to work out by hand.
    assert will_it_fly([1, 2, 3], 6) is False
    assert will_it_fly([5], 5) is True

check(will_it_fly)