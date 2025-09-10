def pairs_sum_to_zero(l):
    """
    pairs_sum_to_zero takes a list of integers as an input.
    it returns True if there are two distinct elements in the list that
    sum to zero, and False otherwise.
    >>> pairs_sum_to_zero([1, 3, 5, 0])
    False
    >>> pairs_sum_to_zero([1, 3, -2, 1])
    False
    >>> pairs_sum_to_zero([1, 2, 3, 7])
    False
    >>> pairs_sum_to_zero([2, 4, -5, 3, 5, 7])
    True
    >>> pairs_sum_to_zero([1])
    False
    """
    # Let's think step by step
    # Input: list of integers l
    # Output: boolean indicating if two distinct elements sum to zero
    # 1. Create an empty set to store seen numbers
    # 2. Iterate through each number in the list
    # 3. For each number, check if its negative complement exists in the set
    # 4. If found, return True immediately
    # 5. Add the current number to the set
    # 6. If loop completes without finding a pair, return False
    seen = set()
    for num in l:
        if -num in seen:
            return True
        seen.add(num)
    return False



METADATA = {}


def check(pairs_sum_to_zero):
    assert pairs_sum_to_zero([1, 3, 5, 0]) == False
    assert pairs_sum_to_zero([1, 3, -2, 1]) == False
    assert pairs_sum_to_zero([1, 2, 3, 7]) == False
    assert pairs_sum_to_zero([2, 4, -5, 3, 5, 7]) == True
    assert pairs_sum_to_zero([1]) == False

    assert pairs_sum_to_zero([-3, 9, -1, 3, 2, 30]) == True
    assert pairs_sum_to_zero([-3, 9, -1, 3, 2, 31]) == True
    assert pairs_sum_to_zero([-3, 9, -1, 4, 2, 30]) == False
    assert pairs_sum_to_zero([-3, 9, -1, 4, 2, 31]) == False

check(pairs_sum_to_zero)