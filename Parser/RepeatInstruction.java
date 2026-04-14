package Parser;

import Evaluator.Environment;

import java.util.List;

/**
 * Represents a loop/iteration instruction in the Abstract Syntax Tree (AST).
 * Evaluates a numeric expression to determine a repetition count, and then
 * executes a block of instructions that exact number of times.
 */
public class RepeatInstruction implements Instruction {
    private final Expression countExpression;
    private final List<Instruction> body;

    /**
     * Constructs a new RepeatInstruction.
     *
     * @param countExpression The expression dictating how many times to loop. Must resolve to a Double.
     * @param body            The list of instructions to execute during each iteration.
     */
    public RepeatInstruction(Expression countExpression, List<Instruction> body) {
        this.countExpression = countExpression;
        this.body = body;
    }

    /**
     * Executes the loop block.
     * Evaluates the count expression, truncates the Double result into an integer,
     * and sequentially executes the body instructions for that many iterations.
     *
     * @param env The execution environment where variables are stored and retrieved.
     * @throws RuntimeException if the count expression does not evaluate to a numeric Double type.
     */
    @Override
    public void execute(Environment env) {
        Object countResult = countExpression.evaluate(env);

        if (countResult instanceof Double) {
            int count = ((Double) countResult).intValue();
            for (int i = 0; i < count; i++) {
                for (Instruction instruction : body) {
                    instruction.execute(env);
                }
            }
        } else {
            throw new RuntimeException("Repeat count must be a number.");
        }
    }
}