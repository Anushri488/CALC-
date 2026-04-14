# 🧮 CALC — Mini Expression Interpreter

A Java-based mini interpreter that parses and evaluates expressions using a custom-built **Abstract Syntax Tree (AST)** and an execution environment.

---

## 📌 Overview

**CALC** is a simple interpreter written in Java that simulates how programming languages work internally.

It demonstrates:
- Parsing input expressions
- Constructing an Abstract Syntax Tree (AST)
- Executing instructions using an environment (memory)

---

## 🚀 Features

| Feature | Status |
|---|---|
| Variable assignments (e.g., `x = 10`) | ✅ |
| Mathematical expression evaluation (e.g., `x + 5`) | ✅ |
| Custom Abstract Syntax Tree (AST) | ✅ |
| Modular architecture (Parser + Evaluator) | ✅ |
| Clear separation of Expressions and Instructions | ✅ |

> **Expressions** → return values &nbsp;&nbsp;|&nbsp;&nbsp; **Instructions** → perform actions

---

## 💡 Why This Project?

This project helps you understand core concepts behind **interpreters and compilers**:

- Parsing raw input into a structured format
- Building AST nodes
- Executing instructions step-by-step
- Managing variables using an environment

---

## 📂 Project Structure

```
CALC/
├── Parser/
│   ├── Instruction.java
│   ├── AssignInstruction.java
│   ├── Expression.java
│   └── ...
│
├── Evaluator/
│   ├── Environment.java
│   └── ...
│
└── Main.java
```

---

## 🧠 How It Works

### 1️⃣ Parsing

Converts raw input into an **Abstract Syntax Tree (AST)**.

Each node represents either:
- An **Expression** — computes and returns a value
- An **Instruction** — performs an action (e.g., assignment)

### 2️⃣ Execution

Instructions are executed sequentially using an **Environment** that stores variables like program memory.

### 3️⃣ Example Flow

```
x = 5 + 10
```

- Expression `5 + 10` → evaluates to `15`
- Result stored in environment:

```
x → 15
```

---

## ⚙️ Key Components

### 🔹 Instruction

```java
void execute(Environment env);
```

Represents actions such as assignment, print, etc.

### 🔹 Expression

```java
Object evaluate(Environment env);
```

Computes and returns a value.

### 🔹 Environment

- Stores variables and their values
- Works like program memory

---

## ▶️ How to Run

### 1. Compile

```bash
javac Main.java Parser/*.java Evaluator/*.java
```

### 2. Run

```bash
java Main
```

---

## 💻 Example Usage

**Input:**

```
x = 10
y = x + 5
```

**Output:**

```
y = 15
```

---

## 🛠️ Technologies Used

- **Java**
- **Object-Oriented Programming (OOP)**
- **Abstract Syntax Tree (AST)**

---

## 👥 Contributors

- [Anushri Mishra](https://github.com/)
- [Janu Chaudhary](https://github.com/)
- [Prerna Rajnag](https://github.com/)
