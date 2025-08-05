package com.tharindu.oodp2.Interpreter;
/*
*****************************************************************************
  ✅ Congratulations! You found the code used in the lecture. Now You can use it.
  * Put this code in your Project under the package `com.tharindu.oodp2.Interpreter`.
  🙏 Thank you
*****************************************************************************
 */
import java.util.Stack;

interface Expression {
    int interpret();
}

class NumberExpression implements Expression {
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        System.out.println("Interpreting number: " + number);
        return number;
    }
}

class Add implements Expression {
    private final Expression left, right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        int a = left.interpret();
        int b = right.interpret();
        int result = a + b;
        System.out.println("Adding: " + a + " + " + b + " = " + result);
        return result;
    }
}

class Subtract implements Expression {
    private final Expression left, right;

    public Subtract(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        int a = left.interpret();
        int b = right.interpret();
        int result = a - b;
        System.out.println("Subtracting: " + a + " - " + b + " = " + result);
        return result;
    }
}

class Multiply implements Expression {
    private final Expression left, right;

    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        int a = left.interpret();
        int b = right.interpret();
        int result = a * b;
        System.out.println("Multiplying: " + a + " * " + b + " = " + result);
        return result;
    }
}

class Divide implements Expression {
    private final Expression left, right;

    public Divide(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        int a = left.interpret();
        int b = right.interpret();
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        int result = a / b;
        System.out.println("Dividing: " + a + " / " + b + " = " + result);
        return result;
    }
}

class ExpressionParser {
    /**
     * Parse a space‐delimited *infix* expression INTO an Expression tree.
     * Does *not* itself interpret; just builds the tree.
     * <p>
     * *සිංහල Explanation*
     * String value එකක් space එකකින් split කරලා එන values ටික,
     * Tree structure එකකට store කරලා format කරන්නේ මෙතනින්...
     * </p>
     */
    public static Expression parse(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Expression> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    // Grab left from stack, parse the *next* token as right
                    Expression leftAdd = stack.pop();
                    Expression rightAdd = new NumberExpression(Integer.parseInt(tokens[++i]));
                    stack.push(new Add(leftAdd, rightAdd));
                    break;

                case "-":
                    Expression leftSub = stack.pop();
                    Expression rightSub = new NumberExpression(Integer.parseInt(tokens[++i]));
                    stack.push(new Subtract(leftSub, rightSub));
                    break;

                case "*":
                    Expression leftMul = stack.pop();
                    Expression rightMul = new NumberExpression(Integer.parseInt(tokens[++i]));
                    stack.push(new Multiply(leftMul, rightMul));
                    break;

                case "/":
                    Expression leftDiv = stack.pop();
                    Expression rightDiv = new NumberExpression(Integer.parseInt(tokens[++i]));
                    // don’t interpret here; defer the zero‐check until interpret()
                    stack.push(new Divide(leftDiv, rightDiv));
                    break;

                default:
                    stack.push(new NumberExpression(Integer.parseInt(token)));
                    break;
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Malformed expression: leftover stack = " + stack);
        }
        return stack.pop();
    }
}

public class Apply_Interpreter {
    public static void main(String[] args) {
        String expression = "10 + 2 - 4";
        try {
            Expression parsedExpression = ExpressionParser.parse(expression);
            int result = parsedExpression.interpret();
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in expression");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}