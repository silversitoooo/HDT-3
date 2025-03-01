package org.example;

import java.util.Stack;

/**
 * Converts an infix expression (e.g. "3+4*2/(1-5)") to a postfix expression (e.g. "342*15-/+").
 */
public class InfixToPostfix {
    /**
     * Converts the given infix expression to postfix notation.
     * @param infix The infix expression without unnecessary spaces.
     * @return The converted postfix expression or an error message if unbalanced.
     */
    public static String convert(String infix) {
        // Remove all whitespace
        infix = infix.replaceAll("\\s+", "");

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // If operand (digit or letter), append to output
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // If '(' -> push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If ')' -> pop from stack until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "Error: Paréntesis desbalanceados";
                }
            }
            // Operator encountered
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    // For '^', which is right-associative, we break if it's also '^'
                    if (c == '^' && stack.peek() == '^') {
                        break;
                    }
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all remaining operators
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(' || top == ')') {
                return "Error: Paréntesis desbalanceados";
            }
            postfix.append(top);
        }
        return postfix.toString();
    }

    /**
     * Defines the precedence of the operators.
     * @param c Operator character.
     * @return Higher number means higher precedence.
     */
    private static int precedence(char c) {
        switch (c) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default:  return -1;
        }
    }
}