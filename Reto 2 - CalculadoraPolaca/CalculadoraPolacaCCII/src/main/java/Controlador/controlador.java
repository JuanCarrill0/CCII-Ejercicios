/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author juanc
 */

import Modelo.*;
import Modelo.arbolBinario.Nodo;
import Vista.Ventana;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;

public class controlador implements ActionListener {

    private Ventana ventana;
    private calculadoraPolaca calculadora = new calculadoraPolaca();
    private JButton[] numeros;
    private JButton[] operadores;

    private String[] valoresNumeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private String[] valoresOperadores = {"+", "-", "*", "/"};
    
    private String textoActual = "";
    private arbolBinario miArbol = new arbolBinario();

    public controlador(Ventana ventana) {
        this.ventana = ventana;
        
        this.ventana.borrar.addActionListener(e -> actionPerformed(e));
        this.ventana.enter.addActionListener(e -> actionPerformed(e));
        
        this.numeros = new JButton[]{ventana.uno, ventana.dos, ventana.tres, ventana.cuatro, ventana.cinco,
                                      ventana.seis, ventana.siete, ventana.ocho, ventana.nueve, ventana.cero};
        this.operadores = new JButton[]{ventana.suma, ventana.resta, ventana.multiplicacion, ventana.division};

        for (JButton boton : numeros) {
            boton.addActionListener(this);
        }

        for (JButton boton : operadores) {
            boton.addActionListener(this);
        }
    }

    public void iniciar() {
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Calculadora Polaca");
        ventana.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();
        String valorBoton = obtenerValorBoton(botonPresionado);
        
        if (valorBoton != null) {
            if(esNumero(botonPresionado)){
                ventana.tablero.setText(textoActual + valorBoton);
                textoActual = ventana.tablero.getText(); 
            }
            
            if(esOperador(botonPresionado)){
                ventana.tablero.setText(textoActual + "\n" + valorBoton);
                textoActual = ventana.tablero.getText();
                
                int resultado = calculadora.evaluarExpresion(textoActual);
                
                if (resultado == -1) {
                    // Dividir el texto actual en líneas
                    String[] lineas = textoActual.split("\\r?\\n");

                    // Tomar todas las líneas excepto las dos últimas
                    StringBuilder nuevoTexto = new StringBuilder();
                    for (int i = 0; i < lineas.length - 2; i++) {
                        nuevoTexto.append(lineas[i]).append("\n");
                    }

                    // Actualizar textoActual
                    textoActual = nuevoTexto.toString();
                    
                    // Actualizar el texto en la ventana
                    ventana.tablero.setText(textoActual);  
                }else{
                    String[] lineas = textoActual.split("\\r?\\n");

                    // Tomar las últimas tres líneas si hay más de tres líneas
                    int inicio = Math.max(0, lineas.length - 3);
                    StringBuilder nuevoTexto = new StringBuilder();
                    for (int i = 0; i < inicio; i++) {
                        nuevoTexto.append(lineas[i]).append("\n");
                    }
                    nuevoTexto.append(resultado).append("\n");

                    // Actualizar textoActual
                    textoActual = nuevoTexto.toString();

                    // Actualizar el texto en la ventana
                    ventana.tablero.setText(textoActual);    
                }
            }
            
            Random random = new Random();
            this.miArbol.insertar(valorBoton);
            actualizarVista();
        }
        
         //Borrar tablero
        if (e.getSource() == ventana.borrar){
            ventana.tablero.setText(" ");
            this.textoActual = "";
        }
        
        //Si el botón es enter añade un salto de linea en el cuadro de texto
        if(e.getSource() == ventana.enter){
            ventana.tablero.setText(textoActual + "\n");
            textoActual = ventana.tablero.getText();
        }
    }

    private String obtenerValorBoton(JButton boton) {
        for (int i = 0; i < numeros.length; i++) {
            if (boton == numeros[i]) {
                return valoresNumeros[i];
            }
        }

        for (int i = 0; i < operadores.length; i++) {
            if (boton == operadores[i]) {
                return valoresOperadores[i];
            }
        }

        return null;
    }
    
     public boolean esNumero(JButton botonPresionado) {
        for (JButton boton : numeros) {
            if (boton == botonPresionado) {
                return true;
            }
        }
        return false;
    }

    public boolean esOperador(JButton botonPresionado) {
        for (JButton boton : operadores) {
            if (boton == botonPresionado) {
                return true;
            }
        }
        return false;
    }
    
    
    private void actualizarVista(){
        ventana.getJScrollPane2().removeAll();
        //miArbol = new arbolBinario();  // Crear un nuevo objeto arbolBinario
        Rectangle rectangulo = ventana.getJPanel1().getBounds();
        ventana.setJPanel1(this.miArbol.getDibujo());
        ventana.getJPanel1().setBounds(rectangulo);
        ventana.getJPanel1().setVisible(true);
        ventana.getJScrollPane2().add(ventana.getJPanel1());
        ventana.getJScrollPane2().updateUI();
        
    }

}

