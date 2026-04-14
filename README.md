# CALC - Mini Expression Interpreter

A Java-based mini interpreter that parses and evaluates expressions using a custom-built Abstract Syntax Tree (AST) and execution environment.

## 🎯 Demo

**Input:**
```text
x = 10
y = x + 5

Output:

y = 15
---
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
Input expressions are converted into an AST (Abstract Syntax Tree)
Each node represents:
an Expression (returns value)
an Instruction (performs action)
2. Execution
Instructions are executed using an Environment
Environment stores variables and their values
3. Example Flow
x = 5 + 10
Expression 5 + 10 is evaluated to 15
Stored in environment:
x → 15
⚙️ Key Components
🔹 Instruction
void execute(Environment env);
🔹 Expression
Object evaluate(Environment env);
🔹 Environment

Stores variable values and acts like memory.

▶️ How to Run
1. Compile
javac Main.java Parser/*.java Evaluator/*.java
2. Run
java Main
💻 Example Usage

Input:

x = 10
y = x + 5  ```

Output:

y = 15
---
🛠️ Technologies Used
Java
Object-Oriented Programming (OOP)
Abstract Syntax Tree (AST)
👥 Contributors
Anushri Mishra
Janu Chaudhary
Prerna Rajnag
