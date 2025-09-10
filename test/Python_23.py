def strlen(string: str) -> int:
    """ Return length of given string
    >>> strlen('')
    0
    >>> strlen('abc')
    3
    """
    # Let's think step by step
    # Input: string, a string
    # Output: length, an integer
    # 1. Initialize a counter variable to 0
    # 2. Loop through each character in the string
    # 3. For each character, increment the counter by 1
    # 4. Return the counter value
    count = 0
    for char in string:
        count += 1
    return count



METADATA = {
    'author': 'jt',
    'dataset': 'test'
}


def check(strlen):
    assert strlen('') == 0
    assert strlen('x') == 1
    assert strlen('asdasnakj') == 9

check(strlen)