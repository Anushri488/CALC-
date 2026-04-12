package Parser;

import Evaluator.Environment;

/**
 * Represents a binary operation node in the Abstract Syntax Tree (AST).
 * This node handles arithmetic (+, -, *, /) and comparison (>, <) operations
 * by evaluating its left and right expressions and applying the specified operator.
 */

public class BinaryOpNode implements Expression {
    private final Expression left;
    private final String operator;
    private final Expression right;

    /**
     * Constructs a new BinaryOpNode.
     *
     * @param left     The left-hand side expression.
     * @param operator The binary operator as a string (e.g., "+", ">").
     * @param right    The right-hand side expression.
     */

    public BinaryOpNode(Expression left, String operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    /**
     * Evaluates both child expressions and applies the binary operator.
     * * @param env The execution environment for variable lookups.
     * @return A Double for arithmetic operations, or a Boolean for comparison operations.
     * @throws RuntimeException if the operands are not numerical (Double) or if the operator is invalid.
     */

    @Override
    public Object evaluate(Environment env) {
        Object leftVal = left.evaluate(env);
        Object rightVal = right.evaluate(env);

        // Handle Math (Returns Double)
        if (leftVal instanceof Double && rightVal instanceof Double) {
            double l = (Double) leftVal;
            double r = (Double) rightVal;

            switch (operator) {
                case "+": return l + r;
                case "-": return l - r;
                case "*": return l * r;
                case "/": return l / r;
                case ">": return l > r;
                case "<": return l < r;
            }
        }

        throw new RuntimeException("Invalid operation: " + leftVal + " " + operator + " " + rightVal);
    }
}
