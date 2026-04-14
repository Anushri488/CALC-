# CALC - Expression Calculator

A Java-based calculator that parses and evaluates mathematical expressions using a custom-built parser and execution engine.

## 🎯 Demo

```text
Input:
x = 10
y = x + 5

Output:
y = 15
🚀 Features
Supports variable assignments
Evaluates mathematical expressions
Custom Abstract Syntax Tree (AST) implementation
Modular design with Parser and Evaluator components
Clean separation between expressions and instructions
💡 Why This Project?

This project demonstrates how programming languages internally:

Parse expressions
Build Abstract Syntax Trees (AST)
Execute instructions using an environment

It mimics the core idea behind interpreters and compilers.

📂 Project Structure
CALC-
├── Parser/
│   ├── Instruction.java
│   ├── AssignInstruction.java
│   ├── Expression.java
│   └── ...
├── Evaluator/
│   ├── Environment.java
│   └── ...
└── Main.java
🧠 How It Works
1. Parsing
Input expressions are converted into an AST (Abstract Syntax Tree).
Each node represents either:
an Expression (returns a value)
an Instruction (performs an action)
2. Execution
Instructions are executed using an Environment.
The environment stores variables and their values.
3. Example Flow
x = 5 + 10
Expression 5 + 10 is evaluated → 15
Stored in environment as:
x → 15
⚙️ Key Components
🔹 Instruction

Represents executable actions such as assignment, print, loops, or other statements.

void execute(Environment env);
🔹 Expression

Represents values or computations that return a result.

Object evaluate(Environment env);
🔹 Environment

Stores variable names and values during execution. It acts like the program’s memory.

▶️ How to Run
1. Compile
javac Main.java Parser/*.java Evaluator/*.java
2. Run
java Main
💻 Example Usage
Input:
x = 10
y = x + 5

Output:
y = 15
🛠️ Technologies Used
Java
Object-Oriented Programming (OOP)
Abstract Syntax Tree (AST)
👥 Contributors
Anushri Mishra
Janu Chaudhary
Prerna Rajnag
