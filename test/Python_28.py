from typing import List


def concatenate(strings: List[str]) -> str:
    """ Concatenate list of strings into a single string
    >>> concatenate([])
    ''
    >>> concatenate(['a', 'b', 'c'])
    'abc'
    """
    # Let's think step by step
    # Input: strings, a list of strings
    # Output: result, a single concatenated string
    # 1. Initialize an empty string variable "result"
    # 2. Use a loop to iterate through each string in the list
    # 3. In each iteration, append the current string to the result
    # 4. Return the final result string
    result = ""
    for s in strings:
        result += s
    return result



METADATA = {
    'author': 'jt',
    'dataset': 'test'
}


def check(concatenate):
    assert concatenate([]) == ''
    assert concatenate(['x', 'y', 'z']) == 'xyz'
    assert concatenate(['x', 'y', 'z', 'w', 'k']) == 'xyzwk'

check(concatenate)