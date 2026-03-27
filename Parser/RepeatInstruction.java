package Parser;

import java.util.List;

public class RepeatInstruction implements Instruction {
    private final Expression countExpression;
    private final List<Instruction> body;

    public RepeatInstruction(Expression countExpression, List<Instruction> body) {
        this.countExpression = countExpression;
        this.body = body;
    }

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