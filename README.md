# CALC - Expression Calculator

A Java-based calculator that parses and evaluates mathematical expressions using a custom-built parser and execution engine.

---

## 🚀 Features

- Supports variable assignments
- Evaluates mathematical expressions
- Custom Abstract Syntax Tree (AST) implementation
- Modular design with Parser and Evaluator components
- Clean separation between expressions and instructions

---

## 📂 Project Structure


CALC-
│── Parser/
│ ├── Instruction.java
│ ├── AssignInstruction.java
│ ├── Expression.java
│ └── ...
│
│── Evaluator/
│ ├── Environment.java
│ └── ...
│
│── Main.java


---

## 🧠 How It Works

### 1. Parsing
- Input expressions are converted into an **AST (Abstract Syntax Tree)**.
- Each node represents either:
  - an **Expression** (returns value)
  - an **Instruction** (performs action)

### 2. Execution
- Instructions are executed using an **Environment**.
- Environment stores variables and their values.

### 3. Example Flow


x = 5 + 10


- Expression `5 + 10` is evaluated → `15`
- Stored in environment:

x → 15


---

## ⚙️ Key Components

### 🔹 Instruction
- Represents executable actions
- Example: assignment, print, loops

```java
void execute(Environment env);
🔹 Expression
Computes and returns values
Object evaluate(Environment env);
🔹 Environment
Stores variable values
Acts like memory
▶️ How to Run
1. Compile
javac Main.java Parser/*.java Evaluator/*.java
2. Run
java Main
💡 Example Usage
Input:
x = 10
y = x + 5

Output:
y = 15
🛠️ Technologies Used
Java
Object-Oriented Programming (OOP)
AST (Abstract Syntax Tree)
👨‍💻 Contributors
Anushri Mishra
Janu Chaudhary
Prerna Rajnag
