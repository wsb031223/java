import java.util.*;
import java.lang.*;

class Solution {
    /**
    Given two lists operator, and operand. The first list has basic algebra operations, and
    the second list is a list of integers. Use the two given lists to build the algebric
    expression and return the evaluation of this expression.

    The basic algebra operations:
    Addition ( + )
    Subtraction ( - )
    Multiplication ( * )
    Floor division ( / )
    Exponentiation ( ** )

    Example:
    operator["+", "*", "-"]
    array = [2, 3, 4, 5]
    result = 2 + 3 * 4 - 5
    => result = 9

    Note:
        The length of operator list is equal to the length of operand list minus one.
        Operand is a list of of non-negative integers.
        Operator list has at least one operator, and operand list has at least two operands.
     */
    public int doAlgebra(List<String> operator, List<Integer> operand) {
        // Let's think step by step
        // Input: operator (list of symbols), operand (list of integers)
        // Output: integer result of the formed infix expression with standard precedence
        //
        // Sequential structure:
        // 1) Define operator precedence and associativity.
        // 2) Initialize two stacks: one for values, one for operators.
        // 3) Push the first operand to the value stack.
        //
        // Loop structure:
        // 4) For each operator in order:
        //    - While the operator stack top has higher precedence (or same precedence and current is left-associative),
        //      pop it and apply to the top two values.
        //    - Push the current operator.
        //    - Push the next operand.
        //
        // Branch structure:
        // 5) During application, branch by operator symbol to perform +, -, *, floor /, or **.
        //
        // 6) After the loop, apply any remaining operators.
        // 7) Return the final value as int.

        Deque<Long> values = new ArrayDeque<>();
        Deque<String> ops = new ArrayDeque<>();

        // Push first operand
        values.push(operand.get(0).longValue());

        for (int i = 0; i < operator.size(); i++) {
            String op = operator.get(i);

            // While there is an operator at the top with higher precedence,
            // or same precedence and current operator is left-associative, apply it.
            while (!ops.isEmpty() && shouldPopBefore(ops.peek(), op)) {
                applyTopOperator(values, ops.pop());
            }

            // Push current operator
            ops.push(op);

            // Push next operand
            values.push(operand.get(i + 1).longValue());
        }

        // Apply remaining operators
        while (!ops.isEmpty()) {
            applyTopOperator(values, ops.pop());
        }

        long result = values.pop();
        return (int) result;
    }

    private static boolean shouldPopBefore(String top, String curr) {
        int pt = precedence(top);
        int pc = precedence(curr);
        if (pt > pc) return true;
        if (pt < pc) return false;
        // Equal precedence: pop if current is left-associative
        return !isRightAssociative(curr);
    }

    private static int precedence(String op) {
        switch (op) {
            case "**": return 3;
            case "*":
            case "/":  return 2;
            case "+":
            case "-":  return 1;
            default:   return -1;
        }
    }

    private static boolean isRightAssociative(String op) {
        return "**".equals(op);
    }

    private static void applyTopOperator(Deque<Long> values, String op) {
        long b = values.pop();
        long a = values.pop();
        long res;
        switch (op) {
            case "+": res = a + b; break;
            case "-": res = a - b; break;
            case "*": res = a * b; break;
            case "/": res = Math.floorDiv(a, b); break; // floor division
            case "**": res = pow(a, b); break;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
        values.push(res);
    }

    private static long pow(long base, long exp) {
        // Fast exponentiation, treating 0**0 as 1 (common programming convention)
        if (exp < 0) {
            // Not expected per problem constraints (operands are non-negative)
            throw new IllegalArgumentException("Negative exponent not supported");
        }
        long result = 1L;
        long b = base;
        long e = exp;
        while (e > 0) {
            if ((e & 1L) == 1L) {
                result = result * b;
            }
            b = b * b;
            e >>= 1;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.doAlgebra(new ArrayList<>(Arrays.asList("**", "*", "+")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))) == 37,
                s.doAlgebra(new ArrayList<>(Arrays.asList("+", "*", "-")), new ArrayList<>(Arrays.asList(2, 3, 4, 5))) == 9,
                s.doAlgebra(new ArrayList<>(Arrays.asList("/", "*")), new ArrayList<>(Arrays.asList(7, 3, 4))) == 8,
                s.doAlgebra(new ArrayList<>(Arrays.asList("+", "**", "**")), new ArrayList<>(Arrays.asList(7, 5, 3, 2))) == 1953132
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}