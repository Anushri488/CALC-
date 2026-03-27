package Tokenizer;

public enum TokenType {
    NUMBER,
    STRING,
    IDENTIFIER,

    ASSIGN,     // :=
    PRINT,      // >>
    IF,         // ?
    REPEAT,     // @
    ARROW,      // =>

    PLUS,       // +
    MINUS,      // -
    STAR,       // *
    SLASH,      // /
    GREATER,    // >
    LESS,       // <

    NEWLINE,
    EOF
}