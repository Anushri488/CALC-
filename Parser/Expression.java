package Parser;

import Evaluator.Environment;

/**
 * Represents a node in the Abstract Syntax Tree (AST) that computes and returns a value.
 * Unlike {@link Instruction} nodes (which perform actions or change state), an Expression
 * always resolves to a specific data type (e.g., Double, Boolean, or String) when evaluated.
 */

public interface Expression {

    /**
     * Evaluates this expression using the current variable state.
     *
     * @param env The execution environment containing currently defined variables.
     * @return The computed result of the expression as an Object.
     * @throws RuntimeException if the evaluation fails (e.g., due to an undefined variable or type mismatch).
     */
    Object evaluate(Environment env);
}
