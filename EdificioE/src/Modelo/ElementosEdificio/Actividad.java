/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ElementosEdificio;

import java.awt.Color;
import java.util.ArrayList;
import java.math.*;

/**
 *
 * @author tic-asisweb01
 */
public class Actividad {
    
    protected String identificador;
    protected ArrayList<FuenteInterna> fuentesInternas;
    protected int tolerancia;
    
    public Actividad(String identificador){
        this.identificador = identificador;
        fuentesInternas = new ArrayList<>();
    }
    
    public String getIdentificador(){
        return identificador;
    }
    
    public void inicializarActividad(){
        switch(identificador){
            case "Fiestas" -> {
                fuentesInternas.add(new FuenteInterna("Parlante", 80, 3600, "Música")); // Nivel alto de ruido
                fuentesInternas.add(new FuenteInterna("Gente Hablando", 70, 3600, "Charla")); // Nivel alto de ruido
                this.tolerancia = 120;
            }
            case "Oficina" -> {
                fuentesInternas.add(new FuenteInterna("Impresora", 50, 1800, "Trabajo")); // Nivel medio de ruido
                fuentesInternas.add(new FuenteInterna("Teclado", 40, 14400, "Trabajo")); // Nivel bajo de ruido
                fuentesInternas.add(new FuenteInterna("Teléfono", 60, 7200, "Trabajo")); // Nivel medio de ruido
                this.tolerancia = 65;
            }
            case "Cocina" -> {
                fuentesInternas.add(new FuenteInterna("Extractor", 70, 1800, "Cocina")); // Nivel alto de ruido
                fuentesInternas.add(new FuenteInterna("Refrigerador", 50, 7200, "Cocina")); // Nivel medio de ruido
                fuentesInternas.add(new FuenteInterna("Licuadora", 80, 1200, "Cocina")); // Nivel alto de ruido
                this.tolerancia = 90;
            }
            case "Dormitorio" -> {
                fuentesInternas.add(new FuenteInterna("Ventilador", 30, 28800, "Descanso")); // Nivel bajo de ruido
                fuentesInternas.add(new FuenteInterna("Reloj", 20, 43200, "Descanso")); // Nivel bajo de ruido
                this.tolerancia = 35;
            }
            case "Gimnasio" -> {
                fuentesInternas.add(new FuenteInterna("Cinta de correr", 90, 3600, "Ejercicio")); // Nivel alto de ruido
                fuentesInternas.add(new FuenteInterna("Pesas", 70, 5400, "Ejercicio")); // Nivel alto de ruido
                this.tolerancia = 100;
            }
            case "Biblioteca" -> {
                fuentesInternas.add(new FuenteInterna("Página de libro", 30, 28800, "Estudio")); // Nivel bajo de ruido
                fuentesInternas.add(new FuenteInterna("Tos ocasional", 40, 14400, "Estudio")); // Nivel bajo de ruido
                this.tolerancia = 50;
            }
            default -> System.out.println("Identificador de actividad no validado");
        }
    }
    
     // Método para inicializar las fuentes internas de la actividad (como lo hicimos anteriormente)

    public int calcularDecibelesTotales() {
        int totalDecibeles = 0;
        for (FuenteInterna fuente : fuentesInternas) {
            totalDecibeles += Math.pow(10, fuente.getFrecuencia()/10);
        }
        
        totalDecibeles = (int) (10*(Math.log10(totalDecibeles)));
        return totalDecibeles;
    }

    public Color getColorPorDecibeles(int decibeles) {
        System.out.println(decibeles);
        if (tolerancia-decibeles > 10) {
            return Color.RED; // Desfase alto
        } else if (tolerancia - decibeles > 5) {
            return Color.YELLOW; // Desfase medio
        } else {
            return Color.GREEN; // Desfase bajo o sin desfase
        }
    }
    
}
