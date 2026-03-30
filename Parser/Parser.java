package Parser;

import java.util.ArrayList;
import java.util.List;
import Tokenizer.Token;
import Tokenizer.TokenType;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    // Step 1: The Main Loop
    public List<Instruction> parse() {
        List<Instruction> instructions = new ArrayList<>();

        while (!isAtEnd()) {
            // Skip empty newlines
            if (peek().getType() == TokenType.NEWLINE) {
                advance();
                continue;
            }
            instructions.add(parseInstruction());
        }

        return instructions;
    }

    // Step 2: Figuring out which instruction we are looking at
    private Instruction parseInstruction() {
        Token token = peek();

        if (token.getType() == TokenType.PRINT) {
            return parsePrint();
        } else if (token.getType() == TokenType.IF) {
            return parseIf();
        } else if (token.getType() == TokenType.REPEAT) {
            return parseRepeat();
        } else if (token.getType() == TokenType.IDENTIFIER) {
            return parseAssign();
        }

        throw new RuntimeException("Unknown instruction starting with: " + token.getValue() + " at line " + token.getLine());
    }

    // --- Instruction Parsers ---

    private Instruction parsePrint() {
        advance(); // Consume '>>'
        Expression expr = parseComparison(); // Parse the math/string to print
        return new PrintInstruction(expr);
    }

    private Instruction parseAssign() {
        String varName = advance().getValue(); // Consume the variable name

        if (advance().getType() != TokenType.ASSIGN) { // Consume ':='
            throw new RuntimeException("Expected ':=' after variable name.");
        }

        Expression value = parseComparison(); // Parse the right side of the assignment
        return new AssignInstruction(varName, value);
    }

    private Instruction parseIf() {
        advance(); // Consume '?'
        Expression condition = parseComparison();

        if (advance().getType() != TokenType.ARROW) { // Consume '=>'
            throw new RuntimeException("Expected '=>' after if condition.");
        }

        // Note: For simplicity, this grabs the very next instruction as the body.
        // For multi-line blocks, you would read until a specific end token or EOF.
        List<Instruction> body = new ArrayList<>();
        body.add(parseInstruction());

        return new IfInstruction(condition, body);
    }

    private Instruction parseRepeat() {
        advance(); // Consume '@'
        Expression count = parseComparison();

        if (advance().getType() != TokenType.ARROW) { // Consume '=>'
            throw new RuntimeException("Expected '=>' after repeat count.");
        }

        List<Instruction> body = new ArrayList<>();
        body.add(parseInstruction());

        return new RepeatInstruction(count, body);
    }

    // --- Expression Parsers (The Math Engine) ---

    // Handles > and <
    private Expression parseComparison() {
        Expression left = parseExpression();

        while (!isAtEnd() && (peek().getType() == TokenType.GREATER || peek().getType() == TokenType.LESS)) {
            String operator = advance().getValue();
            Expression right = parseExpression();
            left = new BinaryOpNode(left, operator, right);
        }
        return left;
    }

    // Handles + and -
    private Expression parseExpression() {
        Expression left = parseTerm();

        while (!isAtEnd() && (peek().getType() == TokenType.PLUS || peek().getType() == TokenType.MINUS)) {
            String operator = advance().getValue();
            Expression right = parseTerm();
            left = new BinaryOpNode(left, operator, right); // Creates a node [cite: 115-117]
        }
        return left;
    }

    // Handles * and /
    private Expression parseTerm() {
        Expression left = parsePrimary();

        while (!isAtEnd() && (peek().getType() == TokenType.STAR || peek().getType() == TokenType.SLASH)) {
            String operator = advance().getValue();
            Expression right = parsePrimary();
            left = new BinaryOpNode(left, operator, right);
        }
        return left;
    }

    // Handles single numbers, strings, or variables
    private Expression parsePrimary() {
        Token token = advance();

        if (token.getType() == TokenType.NUMBER) {
            return new NumberNode(Double.parseDouble(token.getValue()));
        } else if (token.getType() == TokenType.STRING) {
            return new StringNode(token.getValue());
        } else if (token.getType() == TokenType.IDENTIFIER) {
            return new VariableNode(token.getValue());
        }

        throw new RuntimeException("Expected expression but found '" + token.getValue() + "' at line " + token.getLine());
    }

    // --- Utility Methods ---

    private Token peek() {
        return tokens.get(current);
    }

    private Token advance() {
        if (!isAtEnd()) current++;
        return tokens.get(current - 1);
    }

    private boolean isAtEnd() {
        return peek().getType() == TokenType.EOF;
    }
}
