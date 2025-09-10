def do_algebra(operator, operand):
    """
    Given two lists operator, and operand. The first list has basic algebra operations, and 
    the second list is a list of integers. Use the two given lists to build the algebric 
    expression and return the evaluation of this expression.

    The basic algebra operations:
    Addition ( + ) 
    Subtraction ( - ) 
    Multiplication ( * ) 
    Floor division ( // ) 
    Exponentiation ( ** ) 

    Example:
    operator['+', '*', '-']
    array = [2, 3, 4, 5]
    result = 2 + 3 * 4 - 5
    => result = 9

    Note:
        The length of operator list is equal to the length of operand list minus one.
        Operand is a list of of non-negative integers.
        Operator list has at least one operator, and operand list has at least two operands.

    """
    # Let's think step by step
    # Problem-solving process (using sequential, branch, and loop structures):
    # Sequential steps:
    # 1) Check that the lengths of operator and operand lists are consistent.
    # 2) Define the allowed set of operators.
    # 3) Initialize an expression string with the first operand.
    # Loop structure:
    # 4) For each pair (op, next_operand) in the lists, append them to the expression in order.
    # Branch structure:
    # 5) If an operator is not in the allowed set, raise an error.
    # Final sequential steps:
    # 6) Evaluate the constructed expression (which naturally respects operator precedence).
    # 7) Return the evaluated result.

    # Write your code here
    if len(operator) != len(operand) - 1:
        raise ValueError("Operator and operand lengths are inconsistent.")

    allowed_ops = {"+", "-", "*", "//", "**"}

    # Start building the expression string safely from validated tokens
    expr_parts = [str(int(operand[0]))]
    for op, val in zip(operator, operand[1:]):
        if op not in allowed_ops:
            raise ValueError(f"Unsupported operator: {op}")
        expr_parts.append(op)
        expr_parts.append(str(int(val)))

    expr = " ".join(expr_parts)

    # Evaluate with no builtins to keep evaluation limited to arithmetic
    return eval(expr, {"__builtins__": None}, {})

def check(do_algebra):

    # Check some simple cases
    assert do_algebra(['**', '*', '+'], [2, 3, 4, 5]) == 37
    assert do_algebra(['+', '*', '-'], [2, 3, 4, 5]) == 9
    assert do_algebra(['//', '*'], [7, 3, 4]) == 8, "This prints if this assert fails 1 (good for debugging!)"

    # Check some edge cases that are easy to work out by hand.
    assert True, "This prints if this assert fails 2 (also good for debugging!)"

check(do_algebra)