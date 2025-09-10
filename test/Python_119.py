def match_parens(lst):
    '''
    You are given a list of two strings, both strings consist of open
    parentheses '(' or close parentheses ')' only.
    Your job is to check if it is possible to concatenate the two strings in
    some order, that the resulting string will be good.
    A string S is considered to be good if and only if all parentheses in S
    are balanced. For example: the string '(())()' is good, while the string
    '())' is not.
    Return 'Yes' if there's a way to make a good string, and return 'No' otherwise.

    Examples:
    match_parens(['()(', ')']) == 'Yes'
    match_parens([')', ')']) == 'No'
    '''
    # Let's think step by step
    # Sequential structure:
    # 1) Define a helper to compute for a string:
    #    - total balance (count('(') - count(')'))
    #    - minimal prefix balance across the scan
    # 2) Compute these stats for both input strings.
    # Loop structure:
    # 3) Iterate over both possible concatenation orders (A+B and B+A).
    # Branch structure:
    # 4) For each order, check:
    #    - Overall total balance equals zero.
    #    - The first string's minimal prefix is nonnegative.
    #    - The second string's minimal prefix plus the first's total balance is nonnegative.
    # 5) If any order satisfies all conditions, return 'Yes'; else return 'No'.

    def stats(s):
        bal = 0
        min_pref = 0
        for ch in s:
            if ch == '(':
                bal += 1
            else:
                bal -= 1
            if bal < min_pref:
                min_pref = bal
        return bal, min_pref

    a, b = lst[0], lst[1]
    sa, ma = stats(a)
    sb, mb = stats(b)

    orders = [(sa, ma, sb, mb), (sb, mb, sa, ma)]
    for s_first, m_first, s_second, m_second in orders:
        if s_first + s_second == 0 and m_first >= 0 and (m_second + s_first) >= 0:
            return 'Yes'
    return 'No'

def check(match_parens):

    # Check some simple cases
    assert match_parens(['()(', ')']) == 'Yes'
    assert match_parens([')', ')']) == 'No'
    assert match_parens(['(()(())', '())())']) == 'No'
    assert match_parens([')())', '(()()(']) == 'Yes'
    assert match_parens(['(())))', '(()())((']) == 'Yes'
    assert match_parens(['()', '())']) == 'No'
    assert match_parens(['(()(', '()))()']) == 'Yes'
    assert match_parens(['((((', '((())']) == 'No'
    assert match_parens([')(()', '(()(']) == 'No'
    assert match_parens([')(', ')(']) == 'No'
    

    # Check some edge cases that are easy to work out by hand.
    assert match_parens(['(', ')']) == 'Yes'
    assert match_parens([')', '(']) == 'Yes'

check(match_parens)