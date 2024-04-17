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
import javax.swing.JLabel;
        
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

            obtenerRutaMasCorta(origen, destino);

            /*for (int i = 0; i < rutaMasCorta.size() - 1; i++) {
                String sigla = miRed.obtenerSigla(rutaMasCorta.get(i));
                JLabel posicionLabel = interfaz.obtenerLabelPorSigla(sigla);
                posicionLabel.setOpaque(true); // Asegúrate de que el JLabel sea opaco
                posicionLabel.setBackground(Color.green);
                posicionLabel.repaint(); // Repintar el JLabel para que los cambios sean visibles
            }
            */
        }
    }
    
    public List<Integer> obtenerRutaMasCorta(int origen, int destino){
        bellmanFord.setMatrizDeAdyacencias(miRed.getMatrizAdyacencia());
        
        String rutaMasCorta = bellmanFord.calcularRutaMasCorta(origen, destino);
        /*List<Integer> rutaSeparada = separarRuta(rutaMasCorta);
       
        //System.out.print(miRed.obtenerSigla(rutaSeparada.get(i)) + ",");    
        System.out.println("Distancia: " + rutaSeparada.get(rutaSeparada.size() - 1));
        System.out.println(rutaSeparada);
        return rutaSeparada;
        */
        return null;
    }
    
    private List<Integer> separarRuta(String ruta) {
        List<Integer> rutaSeparada = new ArrayList<>();
        String[] partes = ruta.split(",");
        for (String parte : partes) {
            rutaSeparada.add(Integer.valueOf(parte));
        }
        return rutaSeparada;
    }
}
