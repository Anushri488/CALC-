package Parser;

public class AssignInstruction implements Instruction {
    private final String variableName;
    private final Expression valueExpression;

    public AssignInstruction(String variableName, Expression valueExpression) {
        this.variableName = variableName;
        this.valueExpression = valueExpression;
    }

    @Override
    public void execute(Environment env) {
        Object value = valueExpression.evaluate(env);
        env.set(variableName, value);
    }
}