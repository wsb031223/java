def count_upper(s):
    """
    Given a string s, count the number of uppercase vowels in even indices.
    
    For example:
    count_upper('aBCdEf') returns 1
    count_upper('abcdefg') returns 0
    count_upper('dBBE') returns 0
    """
    # Let's think step by step
    # Input: s, a string
    # Output: count, an integer
    # 1. Initialize a counter variable to 0
    # 2. Loop through each character in the string with its index
    # 3. For each character at even index:
    # 4.   Check if the character is an uppercase vowel (A, E, I, O, U)
    # 5.   If yes, increment the counter
    # 6. Return the counter
    count = 0
    for i in range(len(s)):
        if i % 2 == 0:
            if s[i] in 'AEIOU':
                count += 1
    return count

def check(count_upper):

    # Check some simple cases
    assert count_upper('aBCdEf')  == 1
    assert count_upper('abcdefg') == 0
    assert count_upper('dBBE') == 0
    assert count_upper('B')  == 0
    assert count_upper('U')  == 1
    assert count_upper('') == 0
    assert count_upper('EEEE') == 2

    # Check some edge cases that are easy to work out by hand.
    assert True

check(count_upper)