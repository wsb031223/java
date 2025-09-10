def total_match(lst1, lst2):
    '''
    Write a function that accepts two lists of strings and returns the list that has 
    total number of chars in the all strings of the list less than the other list.

    if the two lists have the same number of chars, return the first list.

    Examples
    total_match([], []) ➞ []
    total_match(['hi', 'admin'], ['hI', 'Hi']) ➞ ['hI', 'Hi']
    total_match(['hi', 'admin'], ['hi', 'hi', 'admin', 'project']) ➞ ['hi', 'admin']
    total_match(['hi', 'admin'], ['hI', 'hi', 'hi']) ➞ ['hI', 'hi', 'hi']
    total_match(['4'], ['1', '2', '3', '4', '5']) ➞ ['4']
    '''
    # Let's think step by step
    # Sequential structure:
    # 1) Initialize accumulators for total character counts of each list.
    total1 = 0
    total2 = 0
    # Loop structure:
    # 2) Accumulate the lengths of strings in lst1.
    for s in lst1:
        total1 += len(s)
    # 3) Accumulate the lengths of strings in lst2.
    for s in lst2:
        total2 += len(s)
    # Branch structure:
    # 4) Compare totals and return the appropriate list.
    if total1 < total2:
        return lst1
    elif total2 < total1:
        return lst2
    else:
        return lst1

def check(total_match):

    # Check some simple cases
    assert True, "This prints if this assert fails 1 (good for debugging!)"
    assert total_match([], []) == []
    assert total_match(['hi', 'admin'], ['hi', 'hi']) == ['hi', 'hi']
    assert total_match(['hi', 'admin'], ['hi', 'hi', 'admin', 'project']) == ['hi', 'admin']
    assert total_match(['4'], ['1', '2', '3', '4', '5']) == ['4']
    assert total_match(['hi', 'admin'], ['hI', 'Hi']) == ['hI', 'Hi']
    assert total_match(['hi', 'admin'], ['hI', 'hi', 'hi']) == ['hI', 'hi', 'hi']
    assert total_match(['hi', 'admin'], ['hI', 'hi', 'hii']) == ['hi', 'admin']


    # Check some edge cases that are easy to work out by hand.
    assert True, "This prints if this assert fails 2 (also good for debugging!)"
    assert total_match([], ['this']) == []
    assert total_match(['this'], []) == []

check(total_match)