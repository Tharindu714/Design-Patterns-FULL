package com.tharindu.oodp2.Interpreter;
/*
*****************************************************************************
  ✅ Congratulations! You found the code used in the lecture.
  * In this code, we implement a simple calculator that can interpret
    expressions like "10-2+4" without using the Interpreter design pattern.
    * But You can't use this code to show `Interpreter` design pattern.
  🙏 Thank you
*****************************************************************************
 */
class Cal{
    public int calculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }
        String[] token = expression.split(" ");
        int result = Integer.parseInt(token[0]);
        for (int i = 1; i < token.length; i++) {
            String operator = token[i];
            i++;
            int operand = Integer.parseInt(token[i]);
            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result /= operand;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }
        }
        return result;
    }
}

public class Interpreter_without_pattern {
    public static void main(String[] args) {
        Cal calculator = new Cal();
        String expression = "10 - 2 + 4";
        try {
            int result = calculator.calculate(expression);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
