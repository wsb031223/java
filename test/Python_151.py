def double_the_difference(lst):
    '''
    Given a list of numbers, return the sum of squares of the numbers
    in the list that are odd. Ignore numbers that are negative or not integers.
    
    double_the_difference([1, 3, 2, 0]) == 1 + 9 + 0 + 0 = 10
    double_the_difference([-1, -2, 0]) == 0
    double_the_difference([9, -2]) == 81
    double_the_difference([0]) == 0  
   
    If the input list is empty, return 0.
    '''
    # Let's think step by step
    # Sequential structure:
    # 1) Initialize an accumulator to hold the sum of squares.
    total = 0

    # Branch structure:
    # 2) If the input list is empty, return 0 immediately.
    if not lst:
        return 0

    # Loop structure:
    # 3) Iterate through each element and use branching to filter:
    #    - Keep only non-negative integers that are odd, then add their squares.
    for x in lst:
        # Branch structure (filtering conditions):
        if type(x) is int and x >= 0 and x % 2 == 1:
            total += x * x

    # 4) Return the accumulated result.
    return total

def check(double_the_difference):

    # Check some simple cases
    assert double_the_difference([]) == 0 , "This prints if this assert fails 1 (good for debugging!)"
    assert double_the_difference([5, 4]) == 25 , "This prints if this assert fails 2 (good for debugging!)"
    assert double_the_difference([0.1, 0.2, 0.3]) == 0 , "This prints if this assert fails 3 (good for debugging!)"
    assert double_the_difference([-10, -20, -30]) == 0 , "This prints if this assert fails 4 (good for debugging!)"


    # Check some edge cases that are easy to work out by hand.
    assert double_the_difference([-1, -2, 8]) == 0, "This prints if this assert fails 5 (also good for debugging!)"
    assert double_the_difference([0.2, 3, 5]) == 34, "This prints if this assert fails 6 (also good for debugging!)"
    lst = list(range(-99, 100, 2))
    odd_sum = sum([i**2 for i in lst if i%2!=0 and i > 0])
    assert double_the_difference(lst) == odd_sum , "This prints if this assert fails 7 (good for debugging!)"

check(double_the_difference)