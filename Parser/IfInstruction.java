package Parser;

import Evaluator.Environment;
import java.util.List;

/**
 * Represents a conditional control flow instruction in the Abstract Syntax Tree (AST).
 * Evaluates a condition and, if the result is true, executes an associated block of instructions.
 */
public class IfInstruction implements Instruction {
    private final Expression condition;
    private final List<Instruction> body;

    /**
     * Constructs a new IfInstruction.
     *
     * @param condition The expression to evaluate. It must resolve to a Boolean value.
     * @param body      The list of instructions to execute if the condition is true.
     */
    public IfInstruction(Expression condition, List<Instruction> body) {
        this.condition = condition;
        this.body = body;
    }

    /**
     * Executes the conditional block.
     * Evaluates the condition expression. If the result is a Boolean and evaluates to true,
     * sequentially executes all instructions within the body. If the result is false or
     * a non-boolean type, the body is skipped.
     *
     * @param env The execution environment where variables are stored and retrieved.
     */
    @Override
    public void execute(Environment env) {
        Object conditionResult = condition.evaluate(env);

        if (conditionResult instanceof Boolean && (Boolean) conditionResult) {
            for (Instruction instruction : body) {
                instruction.execute(env);
            }
        }
    }
}