package Parser;

import Evaluator.Environment;

/**
 * Represents a print instruction in the Abstract Syntax Tree (AST).
 * When executed, this instruction evaluates its associated expression and outputs
 * the result to the standard console. It includes custom formatting to display
 * whole-number Doubles as integers (e.g., printing 5 instead of 5.0).
 */
public class PrintInstruction implements Instruction {
    private final Expression expression;

    /**
     * Constructs a new PrintInstruction.
     *
     * @param expression The expression to be evaluated and printed.
     */
    public PrintInstruction(Expression expression) {
        this.expression = expression;
    }

    /**
     * Executes the print operation.
     * Evaluates the internal expression. If the result is a Double representing a
     * whole number, it strips the decimal before printing. Otherwise, it prints
     * the raw result to standard output.
     *
     * @param env The execution environment used to evaluate the expression.
     */
    @Override
    public void execute(Environment env) {
        Object result = expression.evaluate(env);
        // Print double without the .0 if it's a whole number
        if (result instanceof Double) {
            double d = (Double) result;
            if (d == (long) d) {
                System.out.println(String.format("%d", (long) d));
                return;
            }
        }
        System.out.println(result);
    }
}