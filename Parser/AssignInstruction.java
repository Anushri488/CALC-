package Parser;

import Evaluator.Environment;

/**
 * Represents a variable assignment instruction in the Abstract Syntax Tree (AST).
 * When executed, this instruction evaluates its right-hand expression and stores
 * the resulting value in the current environment under the specified variable name.
 */
public class AssignInstruction implements Instruction {
    private final String variableName;
    private final Expression valueExpression;

    /**
     * Constructs a new AssignInstruction.
     *
     * @param variableName    The name of the variable being assigned to (e.g., "x").
     * @param valueExpression The expression to be evaluated and stored (e.g., "5 + 10").
     */

    public AssignInstruction(String variableName, Expression valueExpression) {
        this.variableName = variableName;
        this.valueExpression = valueExpression;
    }

    /**
     * Executes the assignment operation.
     * Evaluates the internal expression and saves the result to the provided environment.
     *
     * @param env The execution environment where variables are stored and retrieved.
     */

    @Override
    public void execute(Environment env) {
        Object value = valueExpression.evaluate(env);
        env.set(variableName, value);
    }
}