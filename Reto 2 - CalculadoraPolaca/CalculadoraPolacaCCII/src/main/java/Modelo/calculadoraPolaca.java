/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juanc
 */
import java.util.Arrays;
import java.util.Stack;

// Clase CalculadoraPolaca para evaluar expresiones en notación polaca
public class calculadoraPolaca {
    private arbolBinario<String> arbol;

    // Constructor de la clase CalculadoraPolaca
    public calculadoraPolaca() {
        arbol = new arbolBinario<>();
    }

    // Método para evaluar una expresión en notación polaca y devolver el resultado
    public int evaluarExpresion(String expresion) {
        // Dividir la expresión en tokens separados por saltos de línea
        String[] lineas = expresion.split("\\r?\\n");

        // Tomar las últimas tres líneas si hay más de tres líneas
        int inicio = Math.max(0, lineas.length - 3);
        String[] ultimasLineas = Arrays.copyOfRange(lineas, inicio, lineas.length);

        Stack<Double> operandos = new Stack<>();

        // Recorrer cada línea de las últimas tres líneas
        for (String linea : ultimasLineas) {
            // Dividir la línea en tokens separados por espacios
            String[] tokens = linea.trim().split("\\s+");

            // Recorrer los tokens de la línea
            for (String token : tokens) {
                if (esOperador(token)) {
                    double operando2 = operandos.pop();
                    double operando1 = operandos.pop();
                    double resultado = aplicarOperador(token, operando1, operando2);
                    operandos.push(resultado);
                } else {
                    operandos.push(Double.valueOf(token));
                }
            }
        }

        return operandos.pop().intValue();
    }

    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private double aplicarOperador(String operador, double operando1, double operando2) {
        switch (operador) {
            case "+" -> {
                return operando1 + operando2;
            }
            case "-" -> {
                return operando1 - operando2;
            }
            case "*" -> {
                return operando1 * operando2;
            }
            case "/" -> {
                if (operando2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return operando1 / operando2;
            }
            default -> throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
}

