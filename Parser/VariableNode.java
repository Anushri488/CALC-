package Parser;

import Evaluator.Environment;

/**
 * Represents a variable lookup node in the Abstract Syntax Tree (AST).
 * When evaluated, it queries the execution environment to retrieve the
 * current value dynamically associated with its identifier.
 */
public class VariableNode implements Expression {
    private final String name;

    /**
     * Constructs a new VariableNode.
     *
     * @param name The identifier/name of the variable (e.g., "x", "counter").
     */
    public VariableNode(String name) {
        this.name = name;
    }

    /**
     * Evaluates the variable node by retrieving its value from the environment.
     *
     * @param env The execution environment containing currently defined variables.
     * @return The value assigned to the variable.
     * @throws RuntimeException if the variable has not been defined in the environment.
     */
    @Override
    public Object evaluate(Environment env) {
        return env.get(name);
    }
}