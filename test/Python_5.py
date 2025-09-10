from typing import List


def intersperse(numbers: List[int], delimeter: int) -> List[int]:
    """ Insert a number 'delimeter' between every two consecutive elements of input list `numbers'
    >>> intersperse([], 4)
    []
    >>> intersperse([1, 2, 3], 4)
    [1, 4, 2, 4, 3]
    """
    # Let's think step by step
    # Input: numbers (list of integers), delimeter (integer)
    # Output: new list with delimeter inserted between elements
    # 1. Initialize an empty result list
    # 2. If the input list is empty, return empty list (branch)
    # 3. Loop through each element in the input list (loop)
    # 4. For each element, add it to the result list (sequential)
    # 5. If it's not the last element, add the delimeter (branch)
    # 6. Return the result list
    
    if not numbers:
        return []
    
    result = []
    for i in range(len(numbers)):
        result.append(numbers[i])
        if i < len(numbers) - 1:
            result.append(delimeter)
    return result



METADATA = {
    'author': 'jt',
    'dataset': 'test'
}


def check(intersperse):
    assert intersperse([], 7) == []
    assert intersperse([5, 6, 3, 2], 8) == [5, 8, 6, 8, 3, 8, 2]
    assert intersperse([2, 2, 2], 2) == [2, 2, 2, 2, 2]

check(intersperse)