package Tokenizer;

import java.util.List;

public class TestTokenizer {
    public static void main(String[] args) {
        String code = """
                i := 1
                @ 4 =>
                >> i
                i := i + 1
                """;
        // String code = """
        // x := 10 + 3 * 2
        // """;    Test 1

        // String code = """
        // name := "Sitare"
        // >> name
        // """;   Test 2


        // String code = """
        // ? x > 5 =>
        // >> "ok"
        // """;    Test 3




        Tokenizer tokenizer = new Tokenizer(code);
        List<Token> tokens = tokenizer.tokenize();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}