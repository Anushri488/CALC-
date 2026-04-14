import Tokenizer.*;
import Parser.*;
import Evaluator.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String code = """
                i := 1
                @ 4 =>
                >> i
                i := i + 1
                """;

        Tokenizer tokenizer = new Tokenizer(code);
        List<Token> tokens = tokenizer.tokenize();

        Parser parser = new Parser(tokens);
        List<Instruction> instructions = parser.parse();

        Interpreter interpreter = new Interpreter();
        interpreter.execute(instructions);

        //System.out.println("Final State: " + interpreter.getEnvironment());
    }
}
