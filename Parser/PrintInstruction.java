package Parser;

public class PrintInstruction implements Instruction {
    private final Expression expression;

    public PrintInstruction(Expression expression) {
        this.expression = expression;
    }

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