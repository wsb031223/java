def make_a_pile(n):
    """
    Given a positive integer n, you have to make a pile of n levels of stones.
    The first level has n stones.
    The number of stones in the next level is:
        - the next odd number if n is odd.
        - the next even number if n is even.
    Return the number of stones in each level in a list, where element at index
    i represents the number of stones in the level (i+1).

    Examples:
    >>> make_a_pile(3)
    [3, 5, 7]
    """
    # Let's think step by step
    # Input: n, a positive integer
    # Output: list of stones in each level
    # 1. Initialize an empty list to store the stones for each level
    # 2. Start with the first level having n stones
    # 3. For each subsequent level (n-1 times):
    # 4.   If current number is odd, next number is current + 2 (next odd)
    # 5.   If current number is even, next number is current + 2 (next even)
    # 6. Add each level's stones to the list
    # 7. Return the list
    
    pile = []
    current = n
    for i in range(n):
        pile.append(current)
        if current % 2 == 1:  # odd
            current += 2
        else:  # even
            current += 2
    return pile

def check(make_a_pile):

    # Check some simple cases
    assert make_a_pile(3) == [3, 5, 7], "Test 3"
    assert make_a_pile(4) == [4,6,8,10], "Test 4"
    assert make_a_pile(5) == [5, 7, 9, 11, 13]
    assert make_a_pile(6) == [6, 8, 10, 12, 14, 16]
    assert make_a_pile(8) == [8, 10, 12, 14, 16, 18, 20, 22]

    # Check some edge cases that are easy to work out by hand.
    assert True, "This prints if this assert fails 2 (also good for debugging!)"

check(make_a_pile)