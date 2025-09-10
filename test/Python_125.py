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
    # 1. Check if there are whitespaces in the string
    # 2. If yes, split on whitespace and return the list
    # 3. If no whitespace, check if there are commas
    # 4. If commas exist, split on commas and return the list
    # 5. If no commas, count the number of lowercase letters with odd alphabetical order
    # 6. Return the count
    
    if ' ' in txt:
        return txt.split()
    elif ',' in txt:
        return txt.split(',')
    else:
        count = 0
        for char in txt:
            if char.islower():
                order = ord(char) - ord('a')
                if order % 2 == 1:
                    count += 1
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