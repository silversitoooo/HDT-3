package org.example;

import java.util.Stack;

/**
 * Evaluates a postfix expression (e.g. "342*15-/+").
 */
public class PostfixEvaluator {
    /**
     * Evaluates the given postfix expression and returns the numeric result.
     * @param postfix Postfix expression.
     * @return The result as a double.
     * @throws IllegalArgumentException If an invalid token or operator is encountered.
     */
    public static double evaluate(String postfix) throws IllegalArgumentException {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            // If it's a digit, convert to numeric value (assuming single-digit operands)
            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            }
            // If it's an operator, pop two values and apply the operation
            else if (isOperator(c)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión posfija inválida: falta operando.");
                }
                double b = stack.pop();
                double a = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        if (b == 0) {
                            throw new IllegalArgumentException("Error: División por cero.");
                        }
                        stack.push(a / b);
                        break;
                    case '^':
                        stack.push(Math.pow(a, b));
                        break;
                    default:
                        throw new IllegalArgumentException("Operador desconocido: " + c);
                }
            }
            // Ignore whitespace but throw error on any other invalid token
            else if (!Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Token inválido en la expresión posfija: " + c);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión posfija inválida: la evaluación no produjo un único resultado.");
        }
        return stack.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}