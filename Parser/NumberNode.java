package Parser;
import Evaluator.Environment;

/**
 * Represents a numeric literal node in the Abstract Syntax Tree (AST).
 * This is a fundamental building block for math expressions, holding a static
 * decimal value that always evaluates to itself.
 */
public class NumberNode implements Expression {
    private final double value;

    /**
     * Constructs a new NumberNode.
     *
     * @param value The parsed numeric value (e.g., 5.0, -10.2).
     */
    public NumberNode(double value) {
        this.value = value;
    }

    /**
     * Evaluates the numeric node.
     * Since this is a literal value, it does not require variable lookups
     * and simply returns its internal stored value.
     *
     * @param env The execution environment (unused by literal nodes, but required by the Expression contract).
     * @return The stored Double value.
     */
    @Override
    public Object evaluate(Environment env) {
        return value;
    }
}
