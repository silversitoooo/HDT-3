package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Programa principal para convertir y evaluar expresiones matemáticas.
 */
public class Main {

    public static void main(String[] args) {
        // Prueba con expresiones hardcodeadas para diagnóstico
        evaluateExpression("3+4*2/(1-5)");
        evaluateExpression("(5+3)*2^3/(10-2*(1+1))");

        // Leer expresiones desde el archivo
        try {
            List<String> expressions = readExpressionsFromFile("expression.txt");
            for (String expr : expressions) {
                evaluateExpression(expr);
                System.out.println("-----------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee expresiones línea por línea desde un archivo.
     */
    private static List<String> readExpressionsFromFile(String filename) throws IOException {
        List<String> expressions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    expressions.add(line.trim());
                }
            }
        }
        return expressions;
    }

    /**
     * Evalúa una única expresión infija.
     */
    private static void evaluateExpression(String infixExpr) {
        System.out.println("Expresión infija: " + infixExpr);
        String postfixExpr = InfixToPostfix.convert(infixExpr);

        // Verificar si hay error en la conversión
        if (postfixExpr.startsWith("Error")) {
            System.out.println(postfixExpr);
            return;
        }

        System.out.println("Expresión posfija: " + postfixExpr);

        try {
            double result = PostfixEvaluator.evaluate(postfixExpr);
            System.out.println("Resultado: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al evaluar la expresión '" + infixExpr + "': " + e.getMessage());
        }
    }
}