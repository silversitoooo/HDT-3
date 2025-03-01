package org.example;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Evalúa una expresión posfija donde los tokens están separados por espacios.
 */
public class PostfixEvaluator {

    /**
     * Evalúa la expresión posfija y retorna el resultado numérico.
     * @param postfix La expresión en formato posfijo con tokens separados por espacios.
     * @return El resultado de la evaluación.
     * @throws IllegalArgumentException Si hay un token inválido o error de sintaxis.
     */
    public static double evaluate(String postfix) throws IllegalArgumentException {
        // Si la expresión está en el formato sin espacios, intentamos convertirla
        if (!postfix.contains(" ")) {
            postfix = convertToSpacedFormat(postfix);
        }

        Stack<Double> stack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(postfix, " ");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            // Verificar si el token es un operador
            if (token.length() == 1 && isOperator(token.charAt(0))) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión posfija inválida: faltan operandos");
                }

                double b = stack.pop();
                double a = stack.pop();

                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/':
                        if (b == 0) {
                            throw new IllegalArgumentException("Error: División por cero");
                        }
                        stack.push(a / b);
                        break;
                    case '^': stack.push(Math.pow(a, b)); break;
                }
            }
            // Si no es un operador, debe ser un número
            else {
                try {
                    double value = Double.parseDouble(token);
                    stack.push(value);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Token inválido: " + token);
                }
            }
        }

        // Al final, la pila debe tener exactamente un resultado
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión posfija inválida: la evaluación no produjo un único resultado");
        }

        return stack.pop();
    }

    /**
     * Intenta convertir una expresión posfija sin espacios a una con espacios.
     * Este método es un intento de recuperación para expresiones malformadas.
     */
    private static String convertToSpacedFormat(String postfix) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentNumber = new StringBuilder();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else {
                if (currentNumber.length() > 0) {
                    result.append(currentNumber).append(" ");
                    currentNumber = new StringBuilder();
                }
                result.append(c).append(" ");
            }
        }

        if (currentNumber.length() > 0) {
            result.append(currentNumber).append(" ");
        }

        return result.toString().trim();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}