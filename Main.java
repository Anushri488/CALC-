import Tokenizer.*;
import Parser.*;
import Evaluator.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

/**
 * The primary entry point for the CALC programming language interpreter.
 * This class acts as the system orchestrator. It reads raw source code from a specified
 * file and pushes it through the complete compiler pipeline:
 * Tokenizer (Lexing) -> Parser (AST Generation) -> Interpreter (Evaluation).
 */
public class Main {

    /**
     * Validates command-line arguments and initiates the execution of a CALC script.
     *
     * @param args Command-line arguments. Expects exactly one argument representing
     * the relative or absolute file path to the target .calc source file.
     */
    public static void main(String[] args) {
        // 1. Check if you provided a file name in the terminal
        if (args.length == 0) {
            System.err.println("Usage error: No file provided.");
            return; // Stop execution
        }

        // 2. Grab the file name you typed in the terminal
        String filePath = args[0];

        System.out.println("====== Running " + filePath + " ======");
        runScript(filePath);
        System.out.println("====== Execution Finished ======");
    }

    /**
     * Reads a source file and executes it through the CALC interpreter pipeline.
     * Safely traps and reports I/O exceptions (missing files) and runtime exceptions
     * (syntax errors, undefined variables, math errors) to prevent JVM crashes.
     *
     * @param filePath The path to the CALC source code file to be executed.
     */
    private static void runScript(String filePath) {
        try {
            // 1. I/O: Read the entire file into a single String
            String code = Files.readString(Path.of(filePath));

            // 2. Lexical Analysis: Convert text into semantic Tokens
            Tokenizer tokenizer = new Tokenizer(code);
            List<Token> tokens = tokenizer.tokenize();

            // 3. Syntax Analysis: Convert Tokens into an Abstract Syntax Tree (AST)
            Parser parser = new Parser(tokens);
            List<Instruction> instructions = parser.parse();

            // 4. Evaluation: Execute the AST within a managed memory Environment
            Interpreter interpreter = new Interpreter();
            interpreter.execute(instructions);

        } catch (IOException e) {
            System.err.println("Error: Could not find or read the file '" + filePath + "'.");
        } catch (Exception e) {
            System.err.println("Interpreter Error in " + filePath + ": " + e.getMessage());
        }
    }
}