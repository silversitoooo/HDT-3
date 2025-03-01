package org.example;

/**
 * Demonstrates how to convert and evaluate infix expressions.
 */
public class Main {
    public static void main(String[] args) {
        String expr1 = "3+4*2/(1-5)";
        String expr2 = "(5+3)*2^3/(10-2*(1+1))";

        String postfix1 = InfixToPostfix.convert(expr1);
        String postfix2 = InfixToPostfix.convert(expr2);

        System.out.println("Expresión infija: " + expr1);
        System.out.println("Posfija creada: " + postfix1);
        try {
            double result1 = PostfixEvaluator.evaluate(postfix1);
            System.out.println("Resultado de evaluar \"" + expr1 + "\": " + result1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al evaluar \"" + expr1 + "\": " + e.getMessage());
        }

        System.out.println("-------------------------------------------");

        System.out.println("Expresión infija: " + expr2);
        System.out.println("Posfija creada: " + postfix2);
        try {
            double result2 = PostfixEvaluator.evaluate(postfix2);
            System.out.println("Resultado de evaluar \"" + expr2 + "\": " + result2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al evaluar \"" + expr2 + "\": " + e.getMessage());
        }
    }
}