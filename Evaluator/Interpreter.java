package Evaluator;

import Parser.Instruction;
import java.util.List;

public class Interpreter {

    private final Environment env;

    public Interpreter() {
        this.env = new Environment();
    }

    public void execute(List<Instruction> instructions) {
        for (Instruction instruction : instructions) {
            instruction.execute(env);
        }
    }

    public Environment getEnvironment() {
        return env;
    }
}
