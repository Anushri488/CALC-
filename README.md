# CALC - Mini Expression Interpreter

A Java-based mini interpreter that parses and evaluates expressions using a custom-built **Abstract Syntax Tree (AST)** and an execution environment.

---

## 🎯 Overview

**CALC** is a simple expression interpreter written in Java. It demonstrates how programming languages process input by:

- Parsing expressions  
- Constructing an Abstract Syntax Tree (AST)  
- Executing instructions using an environment that stores variable values  

This project helps in understanding the internal working of **interpreters and compilers** in a simple and practical way.

---

## 🚀 Features

- Supports **variable assignments**
- Evaluates **mathematical expressions**
- Uses a custom-built **Abstract Syntax Tree (AST)**
- Modular design with separate **Parser** and **Evaluator**
- Clear separation between:
  - **Expressions** (return values)
  - **Instructions** (perform actions)

---

## 💡 Why This Project?

This project demonstrates core programming language concepts:

- **Parsing** user input into structured format  
- **Building AST nodes**  
- **Executing instructions step-by-step**  
- **Managing variables using an environment**  

---

## 📂 Project Structure

```text
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
```
🧠 How It Works
1. Parsing

Input expressions are converted into an Abstract Syntax Tree (AST).

Each node represents:

an Expression (returns value)
an Instruction (performs action)
2. Execution

Instructions are executed using an Environment.

The environment stores variables and their values.

3. Example Flow
x = 5 + 10
Expression 5 + 10 → evaluated to 15
Stored in environment:
x → 15
⚙️ Key Components
🔹 Instruction
void execute(Environment env);
🔹 Expression
Object evaluate(Environment env);
🔹 Environment

Stores variable values and acts like program memory.

▶️ How to Run
1. Compile
javac Main.java Parser/*.java Evaluator/*.java
2. Run
java Main
💻 Example Usage
Input
x = 10
y = x + 5
Output
y = 15
🛠️ Technologies Used
Java
Object-Oriented Programming (OOP)
Abstract Syntax Tree (AST)
👥 Contributors
Anushri Mishra
Janu Chaudhary
Prerna Rajnag
