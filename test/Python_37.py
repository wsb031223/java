def sort_even(l: list):
    """This function takes a list l and returns a list l' such that
    l' is identical to l in the odd indicies, while its values at the even indicies are equal
    to the values of the even indicies of l, but sorted.
    >>> sort_even([1, 2, 3])
    [1, 2, 3]
    >>> sort_even([5, 6, 3, 4])
    [3, 6, 5, 4]
    """
    # Let's think step by step
    # 1. Extract values at even indices from the input list
    # 2. Sort the extracted even index values
    # 3. Create a new result list
    # 4. For each index in the original list:
    #    - If index is even, take the next value from the sorted even values
    #    - If index is odd, take the original value from the input list
    # 5. Return the result list
    
    even_values = [l[i] for i in range(0, len(l), 2)]
    even_values.sort()
    result = []
    even_index = 0
    for i in range(len(l)):
        if i % 2 == 0:
            result.append(even_values[even_index])
            even_index += 1
        else:
            result.append(l[i])
    return result



METADATA = {}


def check(sort_even):
    assert tuple(sort_even([1, 2, 3])) == tuple([1, 2, 3])
    assert tuple(sort_even([5, 3, -5, 2, -3, 3, 9, 0, 123, 1, -10])) == tuple([-10, 3, -5, 2, -3, 3, 5, 0, 9, 1, 123])
    assert tuple(sort_even([5, 8, -12, 4, 23, 2, 3, 11, 12, -10])) == tuple([-12, 8, 3, 4, 5, 2, 12, 11, 23, -10])

check(sort_even)