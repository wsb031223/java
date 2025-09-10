def solution(lst):
    """Given a non-empty list of integers, return the sum of all of the odd elements that are in even positions.
    

    Examples
    solution([5, 8, 7, 1]) ==> 12
    solution([3, 3, 3, 3, 3]) ==> 9
    solution([30, 13, 24, 321]) ==>0
    """
    # Let's think step by step
    # 1. Initialize a variable to store the sum
    # 2. Iterate through the list with index positions
    # 3. For each element, check if the index is even (0, 2, 4, ...)
    # 4. If index is even and the element is odd, add it to the sum
    # 5. Return the final sum
    total = 0
    for i in range(len(lst)):
        if i % 2 == 0 and lst[i] % 2 != 0:
            total += lst[i]
    return total

def check(solution):

    # Check some simple cases
    assert solution([5, 8, 7, 1])    == 12
    assert solution([3, 3, 3, 3, 3]) == 9
    assert solution([30, 13, 24, 321]) == 0
    assert solution([5, 9]) == 5
    assert solution([2, 4, 8]) == 0
    assert solution([30, 13, 23, 32]) == 23
    assert solution([3, 13, 2, 9]) == 3

    # Check some edge cases that are easy to work out by hand.

check(solution)