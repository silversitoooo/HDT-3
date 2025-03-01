package org.example;

import java.util.Stack;

/**
 * Convierte una expresión infija a una expresión posfija con tokens separados por espacios.
 */
public class InfixToPostfix {

    /**
     * Convierte la expresión infija proporcionada a una expresión posfija con tokens separados.
     * @param infix La expresión infija (ej. "3+4*2/(1-5)").
     * @return La expresión en formato posfijo o un mensaje de error.
     */
    public static String convert(String infix) {
        // Eliminar espacios en blanco
        infix = infix.replaceAll("\\s+", "");

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // Si es un dígito, agregarlo al número actual
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else {
                // Si había un número siendo construido, agregarlo al resultado y reiniciar
                if (currentNumber.length() > 0) {
                    postfix.append(currentNumber).append(" ");
                    currentNumber = new StringBuilder();
                }

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    boolean foundMatching = false;
                    while (!stack.isEmpty()) {
                        char top = stack.pop();
                        if (top == '(') {
                            foundMatching = true;
                            break;
                        }
                        postfix.append(top).append(" ");
                    }
                    if (!foundMatching) {
                        return "Error: Paréntesis desbalanceados";
                    }
                } else if (isOperator(c)) {
                    while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                        // Para el caso de potencia '^', la asociatividad es derecha
                        if (c == '^' && stack.peek() == '^') {
                            break;
                        }
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.push(c);
                }
            }
        }

        // Agregar el último número, si existe
        if (currentNumber.length() > 0) {
            postfix.append(currentNumber).append(" ");
        }

        // Verificar que no queden paréntesis de apertura sin cerrar
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(') {
                return "Error: Paréntesis desbalanceados";
            }
            postfix.append(top).append(" ");
        }

        // Eliminar el último espacio extra si existe
        if (postfix.length() > 0 && postfix.charAt(postfix.length() - 1) == ' ') {
            postfix.deleteCharAt(postfix.length() - 1);
        }

        return postfix.toString();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int precedence(char c) {
        switch (c) {
            case '^': return 3;
            case '*': case '/': return 2;
            case '+': case '-': return 1;
            default: return -1;
        }
    }
}