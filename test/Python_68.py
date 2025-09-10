def pluck(arr):
    """
    "Given an array representing a branch of a tree that has non-negative integer nodes
    your task is to pluck one of the nodes and return it.
    The plucked node should be the node with the smallest even value.
    If multiple nodes with the same smallest even value are found return the node that has smallest index.

    The plucked node should be returned in a list, [ smalest_value, its index ],
    If there are no even values or the given array is empty, return [].

    Example 1:
        Input: [4,2,3]
        Output: [2, 1]
        Explanation: 2 has the smallest even value, and 2 has the smallest index.

    Example 2:
        Input: [1,2,3]
        Output: [2, 1]
        Explanation: 2 has the smallest even value, and 2 has the smallest index. 

    Example 3:
        Input: []
        Output: []
    
    Example 4:
        Input: [5, 0, 3, 0, 4, 2]
        Output: [0, 1]
        Explanation: 0 is the smallest value, but  there are two zeros,
                     so we will choose the first zero, which has the smallest index.

    Constraints:
        * 1 <= nodes.length <= 10000
        * 0 <= node.value
    """
    # Let's think step by step
    # 1. Check if array is empty, return [] if true
    # 2. Initialize variables to track smallest even value and its index
    # 3. Loop through each element in the array with its index
    # 4. For each element, check if it's even
    # 5. If it's even, compare with current smallest value
    # 6. If it's smaller or if it's the first even found, update tracker
    # 7. After loop, return [value, index] if found, else []
    
    if not arr:
        return []
    
    smallest_value = None
    smallest_index = -1
    
    for i, num in enumerate(arr):
        if num % 2 == 0:
            if smallest_value is None or num < smallest_value:
                smallest_value = num
                smallest_index = i
    
    if smallest_value is not None:
        return [smallest_value, smallest_index]
    else:
        return []

def check(pluck):

    # Check some simple cases
    assert True, "This prints if this assert fails 1 (good for debugging!)"
    assert pluck([4,2,3]) == [2, 1], "Error"
    assert pluck([1,2,3]) == [2, 1], "Error"
    assert pluck([]) == [], "Error"
    assert pluck([5, 0, 3, 0, 4, 2]) == [0, 1], "Error"

    # Check some edge cases that are easy to work out by hand.
    assert True, "This prints if this assert fails 2 (also good for debugging!)"
    assert pluck([1, 2, 3, 0, 5, 3]) == [0, 3], "Error"
    assert pluck([5, 4, 8, 4 ,8]) == [4, 1], "Error"
    assert pluck([7, 6, 7, 1]) == [6, 1], "Error"
    assert pluck([7, 9, 7, 1]) == [], "Error"

check(pluck)