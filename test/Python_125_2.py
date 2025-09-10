def split_words(txt):
    '''
    Given a string of words, return a list of words split on whitespace, if no whitespaces exists in the text you
    should split on commas ',' if no commas exists you should return the number of lower-case letters with odd order in the
    alphabet, ord('a') = 0, ord('b') = 1, ... ord('z') = 25
    Examples
    split_words("Hello world!") ➞ ["Hello", "world!"]
    split_words("Hello,world!") ➞ ["Hello", "world!"]
    split_words("abcdef") == 3 
    '''
    # Let's think step by step
    # Input: txt, a string
    # Output: either a list of words or an integer count
    # Sequential:
    # 1) Determine if any whitespace exists in txt.
    # 2) Determine if any comma exists in txt.
    has_whitespace = any(ch.isspace() for ch in txt)
    has_comma = (',' in txt)
    # Branch:
    # 3) If whitespace exists, split on whitespace.
    if has_whitespace:
        return txt.split()
    # 4) Else if comma exists, split on comma.
    elif has_comma:
        return txt.split(',')
    # 5) Else, count lowercase letters with odd order in the alphabet.
    else:
        count = 0
        # Loop:
        # 6) Iterate through characters and count those with odd index ('b','d','f',...,'z').
        for ch in txt:
            if 'a' <= ch <= 'z':
                if (ord(ch) - ord('a')) % 2 == 1:
                    count += 1
        # 7) Return the result.
        return count

def check(split_words):

    assert split_words("Hello world!") == ["Hello","world!"]
    assert split_words("Hello,world!") == ["Hello","world!"]
    assert split_words("Hello world,!") == ["Hello","world,!"]
    assert split_words("Hello,Hello,world !") == ["Hello,Hello,world","!"]
    assert split_words("abcdef") == 3
    assert split_words("aaabb") == 2
    assert split_words("aaaBb") == 1
    assert split_words("") == 0

check(split_words)