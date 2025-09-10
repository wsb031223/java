def same_chars(s0: str, s1: str):
    """
    Check if two words have the same characters.
    >>> same_chars('eabcdzzzz', 'dddzzzzzzzddeddabc')
    True
    >>> same_chars('abcd', 'dddddddabc')
    True
    >>> same_chars('dddddddabc', 'abcd')
    True
    >>> same_chars('eabcd', 'dddddddabc')
    False
    >>> same_chars('abcd', 'dddddddabce')
    False
    >>> same_chars('eabcdzzzz', 'dddzzzzzzzddddabc')
    False
    """
    # Let's think step by step
    # Sequential steps:
    # 1. Initialize two empty sets to store unique characters from each string.
    # Loop structures:
    # 2. Iterate over characters in s0 and add them to the first set.
    # 3. Iterate over characters in s1 and add them to the second set.
    # Branch structure:
    # 4. Compare the two sets: if equal, return True; else, return False.
    set0 = set()
    set1 = set()
    for ch in s0:
        set0.add(ch)
    for ch in s1:
        set1.add(ch)
    if set0 == set1:
        return True
    else:
        return False



METADATA = {}


def check(same_chars):
    assert same_chars('eabcdzzzz', 'dddzzzzzzzddeddabc') == True
    assert same_chars('abcd', 'dddddddabc') == True
    assert same_chars('dddddddabc', 'abcd') == True
    assert same_chars('eabcd', 'dddddddabc') == False
    assert same_chars('abcd', 'dddddddabcf') == False
    assert same_chars('eabcdzzzz', 'dddzzzzzzzddddabc') == False
    assert same_chars('aabb', 'aaccc') == False

check(same_chars)