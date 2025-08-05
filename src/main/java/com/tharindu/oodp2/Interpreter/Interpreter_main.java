package com.tharindu.oodp2.Interpreter;
/*
*****************************************************************************
  This Code is Developed by Tharindu Chanaka (Me).

  ⚠️ If you are looking for the Lecturer's code, this is NOT it.
  👉 Open `Apply_Interpreter.java` for the code used in the lecture.

  ✅ If you use this code, please credit: Tharindu714 on GitHub.
  🙏 Thank you for understanding.
*****************************************************************************
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculator {
    // Supported functions
    private static final Set<String> FUNCTIONS = Set.of("sqrt");
    // Operator precedence
    private static final Map<String, Integer> PRECEDENCE = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    /**
     * Evaluate an infix expression and return the result.
     * @param expression tokens separated by spaces or not (we tokenize with regex).
     */
    public double evaluate(String expression) {
        List<String> tokens = tokenize(expression);
        List<String> rpn    = toRPN(tokens);
        return evalRPN(rpn);
    }

    /**
     * Convert infix tokens to Reverse Polish Notation using the Shunting-Yard algorithm.
     */
    List<String> toRPN(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Deque<String> ops   = new ArrayDeque<>();

        for (String tok : tokens) {
            if (isNumber(tok)) {
                output.add(tok);
            } else if (FUNCTIONS.contains(tok)) {
                ops.push(tok);
            } else if (isOperator(tok)) {
                while (!ops.isEmpty() && (
                        (FUNCTIONS.contains(ops.peek())) ||
                                (isOperator(ops.peek()) &&
                                        PRECEDENCE.get(ops.peek()) >= PRECEDENCE.get(tok))
                )
                ) {
                    output.add(ops.pop());
                }
                ops.push(tok);
            } else if ("(".equals(tok)) {
                ops.push(tok);
            } else if (")".equals(tok)) {
                while (!ops.isEmpty() && !"(".equals(ops.peek())) {
                    output.add(ops.pop());
                }
                if (ops.isEmpty() || !"(".equals(ops.pop())) {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
                if (!ops.isEmpty() && FUNCTIONS.contains(ops.peek())) {
                    output.add(ops.pop());
                }
            } else {
                throw new IllegalArgumentException("Unknown token: " + tok);
            }
        }
        while (!ops.isEmpty()) {
            String op = ops.pop();
            if ("(".equals(op) || ")".equals(op)) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(op);
        }
        return output;
    }

    /**
     * Evaluate an expression in Reverse Polish Notation.
     */
    private double evalRPN(List<String> rpn) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String tok : rpn) {
            if (isNumber(tok)) {
                stack.push(Double.parseDouble(tok));
            } else if (FUNCTIONS.contains(tok)) {
                if (stack.isEmpty()) throw new IllegalStateException("Insufficient operands for " + tok);
                double v = stack.pop();
                if (tok.equals("sqrt")) {
                    stack.push(Math.sqrt(v));
                } else {
                    throw new IllegalStateException("Unknown function " + tok);
                }
            } else if (isOperator(tok)) {
                if (stack.size() < 2) throw new IllegalStateException("Insufficient operands for " + tok);
                double b = stack.pop(), a = stack.pop();
                switch (tok) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                    default: throw new IllegalStateException("Unknown operator " + tok);
                }
            } else {
                throw new IllegalStateException("Bad RPN token: " + tok);
            }
        }
        if (stack.size() != 1) throw new IllegalStateException("Invalid RPN expression");
        return stack.pop();
    }

    /**
     * Split the input string into tokens: numbers, identifiers, operators, and parentheses.
     */
    List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile(
                "\\d*\\.?\\d+|sqrt|[()+\\-*/]"
        ).matcher(expr);
        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    private boolean isNumber(String s) {
        return s.matches("\\d*\\.?\\d+");
    }
    private boolean isOperator(String s) {
        return PRECEDENCE.containsKey(s);
    }
}

public class Interpreter_main {
    // Width of the box for printing
    private static final int BOX_WIDTH = 40;

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        List<String> expressions = List.of(
                "10 - 2 + 4",
                "5 + 3 * 2 - 4 / 2",
                "100 / 5 + 20 - 10 * 2",
                "8 * 3 - 6 + 2 / 1",
                "15 + 5 - 3 * 2 / 1",
                "sqrt 9 + 7",
                "16 + sqrt(25) * 2"
        );

        for (String expr : expressions) {
            double result = calc.evaluate(expr);
            List<String> rpn = calc.toRPN(calc.tokenize(expr));
            printBox(expr, String.join(" ", rpn), result);
        }
    }

    /**
     * Print the expression, its RPN, and the result inside a Unicode box.
     */
    private static void printBox(String expr, String rpn, double result) {
        String top    = "╔" + "═".repeat(BOX_WIDTH - 2) + "╗";
        String bottom = "╚" + "═".repeat(BOX_WIDTH - 2) + "╝";

        System.out.println(top);
        printLine("Expr: " + expr);
        printLine("RPN : " + rpn);
        printLine("Res : " + result);
        System.out.println(bottom);
        System.out.println();
    }

    private static void printLine(String content) {
        if (content.length() > BOX_WIDTH - 4) {
            content = content.substring(0, BOX_WIDTH - 4);
        }
        String padding = " ".repeat(BOX_WIDTH - 2 - content.length());
        System.out.println("║ " + content + padding + "║");
    }
}