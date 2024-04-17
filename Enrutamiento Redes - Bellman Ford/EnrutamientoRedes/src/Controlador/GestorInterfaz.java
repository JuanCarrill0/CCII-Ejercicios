/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Vista;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author tic-asisweb01
 */
public class GestorInterfaz {
    private final Vista ventana;
    
    public GestorInterfaz(Vista ventana){
        this.ventana = ventana;
    }
    
    public JLabel obtenerLabelPorSigla(String sigla) {
        return switch (sigla) {
            case "SA" -> ventana.SA;
            case "SB" -> ventana.SB;
            case "SC" -> ventana.SC;
            case "SD" -> ventana.SD;
            case "SE" -> ventana.SE;
            case "SF" -> ventana.SF;
            case "RN1" -> ventana.RN1;
            case "RN2" -> ventana.RN2;
            case "RN3" -> ventana.RN3;
            case "RD1" -> ventana.RD1;
            case "RD2" -> ventana.RD2;
            case "RD3" -> ventana.RD3;
            case "RD4" -> ventana.RD4;
            case "RD5" -> ventana.RD5;
            case "RD6" -> ventana.RD6;
            case "RD7" -> ventana.RD7;
            case "RD8" -> ventana.RD8;
            case "RD9" -> ventana.RD9;
            case "RD10" -> ventana.RD10;
            case "RD11" -> ventana.RD11;
            case "RD12" -> ventana.RD12;
            default -> null;
        }; // Devuelve null si la sigla no coincide con ninguna variable JLabel
    }
    
    public String obtenerSigla(int posicion) {
        String[] siglas = {"SA", "SB", "SC", "SD", "SE", "SF", "RN1", "RN2", "RN3", "RD1", "RD2", "RD3", "RD4", "RD5", "RD6", "RD7", "RD8", "RD9", "RD10", "RD11", "RD12"};
        if (posicion >= 0 && posicion < siglas.length) {
            return siglas[posicion];
        } else {
            return "Posición no válida";
        }
    }
// Dentro de la clase que contiene el método pintarRecorrido
    public void pintarRecorrido(int sigla) {
        SwingUtilities.invokeLater(() -> {
            String siglaRecorrido = obtenerSigla(sigla);
            System.out.println(siglaRecorrido);
            JLabel posicionLabel = obtenerLabelPorSigla(siglaRecorrido);
            System.out.println(posicionLabel);
            if (posicionLabel != null) {
                posicionLabel.setOpaque(true); // Asegúrate de que el JLabel sea opaco
                posicionLabel.setBackground(Color.orange);
                posicionLabel.repaint(); // Repintar el JLabel para que los cambios sean visibles
            } else {
                System.err.println("El JLabel para la sigla " + siglaRecorrido + " es nulo.");
            }
        });
    }
    
}
