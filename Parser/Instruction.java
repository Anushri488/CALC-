package Parser;

import Evaluator.Environment;

/**
 * Represents an executable statement or control flow node in the Abstract Syntax Tree (AST).
 * Unlike {@link Expression} nodes (which compute and return values), Instructions perform
 * actions that modify the program state or produce side effects (e.g., assigning variables,
 * printing output, or managing loops).
 */
public interface Instruction {

    /**
     * Executes the instruction within the provided environment.
     *
     * @param env The execution environment used to read and write variables during execution.
     * @throws RuntimeException if an error occurs during execution (e.g., undefined variables or invalid state).
     */
    void execute(Environment env);
}