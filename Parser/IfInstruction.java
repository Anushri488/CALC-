package Parser;

import java.util.List;

public class IfInstruction implements Instruction {
    private final Expression condition;
    private final List<Instruction> body;

    public IfInstruction(Expression condition, List<Instruction> body) {
        this.condition = condition;
        this.body = body;
    }

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