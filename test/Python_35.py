def max_element(l: list):
    """Return maximum element in the list.
    >>> max_element([1, 2, 3])
    3
    >>> max_element([5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10])
    123
    """
    # Let's think step by step
    # Input: l, a list of numbers
    # Output: maximum element in the list
    # 1. Initialize a variable "max_val" with the first element of the list
    # 2. Loop through each element in the list
    # 3. For each element, if it's greater than current max_val, update max_val
    # 4. Return max_val
    max_val = l[0]
    for num in l:
        if num > max_val:
            max_val = num
    return max_val



METADATA = {}


def check(max_element):
    assert max_element([1, 2, 3]) == 3
    assert max_element([5, 3, -5, 2, -3, 3, 9, 0, 124, 1, -10]) == 124

check(max_element)