from typing import List


def parse_nested_parens(paren_string: str) -> List[int]:
    """ Input to this function is a string represented multiple groups for nested parentheses separated by spaces.
    For each of the group, output the deepest level of nesting of parentheses.
    E.g. (()()) has maximum two levels of nesting while ((())) has three.

    >>> parse_nested_parens('(()()) ((())) () ((())()())')
    [2, 3, 1, 3]
    """
    # Let's think step by step
    # Sequential structure:
    # 1) Split the input string by whitespace into individual parenthesis groups.
    # 2) Prepare a results list to store maximum nesting depth per group.
    groups = paren_string.split()
    results: List[int] = []

    # Loop structure:
    # 3) For each group, scan characters to compute nesting depth.
    for group in groups:
        current_depth = 0
        max_depth = 0

        # Loop through each character to track depth
        for ch in group:
            # Branch structure:
            # - If it's an opening parenthesis, increase depth and update max.
            # - If it's a closing parenthesis, decrease depth (clamped at 0 for safety).
            # - Otherwise, ignore the character.
            if ch == '(':
                current_depth += 1
                if current_depth > max_depth:
                    max_depth = current_depth
            elif ch == ')':
                if current_depth > 0:
                    current_depth -= 1
                else:
                    # Unbalanced closing; keep depth non-negative
                    current_depth = 0
            else:
                # Ignore any non-parenthesis characters
                pass

        # Append the maximum depth found for this group
        results.append(max_depth)

    # Sequential structure:
    # 4) Return the list of maximum depths corresponding to each group.
    return results



METADATA = {
    'author': 'jt',
    'dataset': 'test'
}


def check(parse_nested_parens):
    assert parse_nested_parens('(()()) ((())) () ((())()())') == [2, 3, 1, 3]
    assert parse_nested_parens('() (()) ((())) (((())))') == [1, 2, 3, 4]
    assert parse_nested_parens('(()(())((())))') == [4]

check(parse_nested_parens)