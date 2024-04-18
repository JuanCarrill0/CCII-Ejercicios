/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author tic-asisweb01
 */

import Modelo.*;
import Vista.Vista;
import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
        
public class Controlador implements ActionListener {
    private final Vista ventana;
    private RedLocal miRed;
    private AlgoritmoBellmanFord bellmanFord;
    private GestorInterfaz interfaz;
    
    public Controlador(Vista ventana){
        this.ventana = ventana;
        
        this.ventana.iniciar.addActionListener(e -> actionPerformed(e));
    }
    
    public void iniciar(){
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Enrutamiento de Paquetes");
        ventana.setResizable(false);
        
        this.interfaz = new GestorInterfaz(ventana);
        this.bellmanFord = new AlgoritmoBellmanFord(interfaz);
        this.miRed = new RedLocal(bellmanFord);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.iniciar) {
            int origen = ventana.comboBoxOrigen.getSelectedIndex();
            int destino = ventana.comboBoxDestino.getSelectedIndex();

            SwingWorker<String, Integer> worker = new SwingWorker<>() {
                @Override
                protected String doInBackground() throws Exception {
                    return obtenerRutaMasCorta(origen, destino);
                }

                @Override
                protected void done() {
                    try {
                        String rutaMasCorta = get(); // Obtener el resultado del cálculo
                        System.out.println("La ruta mas corta ES = "+rutaMasCorta);
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }
                }
            };

            worker.execute(); // Iniciar el trabajo en segundo plano
        }
    }
    
    public String obtenerRutaMasCorta(int origen, int destino) throws ExecutionException {
        bellmanFord.setMatrizDeAdyacencias(miRed.getMatrizAdyacencia());
        SwingWorker<String, Integer> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                return bellmanFord.calcularRutaMasCorta(origen, destino);
            }
        };

        worker.execute(); // Iniciar el trabajo en segundo plano
        try {
            // Esperar hasta que el trabajo en segundo plano haya terminado y devolver el resultado
            return worker.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }


}
