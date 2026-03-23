import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int current = 0;
    private int line = 1;

    public Tokenizer(String source) {
        this.source = source;
    }

    public List<Token> tokenize() {
        while (!isAtEnd()) {
            char c = advance();

            switch (c) {
                case ' ':
                case '\t':
                case '\r':
                    // ignore whitespace
                    break;

                case '\n':
                    tokens.add(new Token(TokenType.NEWLINE, "\\n", line));
                    line++;
                    break;

                case '+':
                    tokens.add(new Token(TokenType.PLUS, "+", line));
                    break;

                case '-':
                    tokens.add(new Token(TokenType.MINUS, "-", line));
                    break;

                case '*':
                    tokens.add(new Token(TokenType.STAR, "*", line));
                    break;

                case '/':
                    tokens.add(new Token(TokenType.SLASH, "/", line));
                    break;

                case '<':
                    tokens.add(new Token(TokenType.LESS, "<", line));
                    break;

                case '?':
                    tokens.add(new Token(TokenType.IF, "?", line));
                    break;

                case '@':
                    tokens.add(new Token(TokenType.REPEAT, "@", line));
                    break;

                case ':':
                    if (match('=')) {
                        tokens.add(new Token(TokenType.ASSIGN, ":=", line));
                    } else {
                        throw new RuntimeException("Unexpected ':' at line " + line);
                    }
                    break;

                case '=':
                    if (match('>')) {
                        tokens.add(new Token(TokenType.ARROW, "=>", line));
                    } else {
                        throw new RuntimeException("Unexpected '=' at line " + line);
                    }
                    break;

                case '>':
                    if (match('>')) {
                        tokens.add(new Token(TokenType.PRINT, ">>", line));
                    } else {
                        tokens.add(new Token(TokenType.GREATER, ">", line));
                    }
                    break;

                case '"':
                    readString();
                    break;

                default:
                    if (isDigit(c)) {
                        readNumber(c);
                    } else if (isAlpha(c)) {
                        readIdentifier(c);
                    } else {
                        throw new RuntimeException("Unexpected character '" + c + "' at line " + line);
                    }
            }
        }

        tokens.add(new Token(TokenType.EOF, "", line));
        return tokens;
    }

    private void readString() {
        StringBuilder sb = new StringBuilder();

        while (!isAtEnd() && peek() != '"') {
            if (peek() == '\n') {
                throw new RuntimeException("Unterminated string at line " + line);
            }
            sb.append(advance());
        }

        if (isAtEnd()) {
            throw new RuntimeException("Unterminated string at line " + line);
        }

        advance(); // closing quote consume karo
        tokens.add(new Token(TokenType.STRING, sb.toString(), line));
    }

    private void readNumber(char firstChar) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstChar);

        while (!isAtEnd() && isDigit(peek())) {
            sb.append(advance());
        }

        // decimal part
        if (!isAtEnd() && peek() == '.' && hasNextDigit()) {
            sb.append(advance()); // dot

            while (!isAtEnd() && isDigit(peek())) {
                sb.append(advance());
            }
        }

        tokens.add(new Token(TokenType.NUMBER, sb.toString(), line));
    }

    private void readIdentifier(char firstChar) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstChar);

        while (!isAtEnd() && isAlphaNumeric(peek())) {
            sb.append(advance());
        }

        tokens.add(new Token(TokenType.IDENTIFIER, sb.toString(), line));
    }

    private boolean hasNextDigit() {
        if (current + 1 >= source.length()) {
            return false;
        }
        return Character.isDigit(source.charAt(current + 1));
    }

    private boolean match(char expected) {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;
        current++;
        return true;
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private char advance() {
        return source.charAt(current++);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               c == '_';
    }

    private boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isDigit(c);
    }
}