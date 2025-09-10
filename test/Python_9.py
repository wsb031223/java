from typing import List, Tuple


def rolling_max(numbers: List[int]) -> List[int]:
    """ From a given list of integers, generate a list of rolling maximum element found until given moment
    in the sequence.
    >>> rolling_max([1, 2, 3, 2, 3, 4, 2])
    [1, 2, 3, 3, 3, 4, 4]
    """
    # Let's think step by step
    # Input: list of integers
    # Output: list of rolling maximums
    # 1. Initialize an empty result list
    # 2. Initialize a variable to track current maximum
    # 3. Loop through each number in the input list
    # 4. For each number, update the current maximum if needed
    # 5. Append the current maximum to the result list
    # 6. Return the result list
    
    if not numbers:
        return []
    
    result = []
    current_max = numbers[0]
    
    for num in numbers:
        if num > current_max:
            current_max = num
        result.append(current_max)
    
    return result



METADATA = {
    'author': 'jt',
    'dataset': 'test'
}


def check(rolling_max):
    assert rolling_max([]) == []
    assert rolling_max([1, 2, 3, 4]) == [1, 2, 3, 4]
    assert rolling_max([4, 3, 2, 1]) == [4, 4, 4, 4]
    assert rolling_max([3, 2, 3, 100, 3]) == [3, 3, 3, 100, 100]

check(rolling_max)