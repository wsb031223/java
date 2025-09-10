from typing import List, Tuple


def rolling_max(numbers: List[int]) -> List[int]:
    """ From a given list of integers, generate a list of rolling maximum element found until given moment
    in the sequence.
    >>> rolling_max([1, 2, 3, 2, 3, 4, 2])
    [1, 2, 3, 3, 3, 4, 4]
    """
    # Let's think step by step
    # Input: numbers, a list of integers
    # Output: a list containing the rolling maximums at each position
    # Sequential structure:
    # 1. If the input list is empty, return an empty list.
    # 2. Initialize current_max with the first element.
    # 3. Initialize result list with current_max as the first element.
    # Loop structure:
    # 4. For each subsequent element in numbers:
    # Branch structure:
    # 5.   If the element is greater than current_max, update current_max; else keep current_max.
    # 6.   Append current_max to the result list.
    # 7. Return the result list.

    if not numbers:
        return []

    current_max = numbers[0]
    result: List[int] = [current_max]

    for x in numbers[1:]:
        if x > current_max:
            current_max = x
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