package Parser;

public interface Expression {
    // Evaluate this expression using the current variable store.
    Object evaluate(Environment env);
}
