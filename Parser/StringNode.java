package Parser;

import Evaluator.Environment;

/**
 * Represents a string literal node in the Abstract Syntax Tree (AST).
 * This is a fundamental building block for expressions, holding a static
 * text value that always evaluates to itself.
 */
public class StringNode implements Expression {
    private final String value;

    /**
     * Constructs a new StringNode.
     *
     * @param value The parsed string value (e.g., "Hello World").
     */
    public StringNode(String value) {
        this.value = value;
    }

    /**
     * Evaluates the string node.
     * Since this is a literal value, it does not require variable lookups
     * and simply returns its internal stored text.
     *
     * @param env The execution environment (unused by literal nodes, but required by the Expression contract).
     * @return The stored String value.
     */
    @Override
    public Object evaluate(Environment env) {
        return value;
    }
}