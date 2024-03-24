package Controlador;

import Modelo.*;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class Controlador implements ActionListener{
    private Ventana ventana;
    private Gestor gestor = new Gestor(20);
    
    private String[] listaNombresMunicipios = gestor.crearMunicipios();
    
    public Controlador(Ventana ventana){
        this.ventana = ventana;
        
        this.ventana.CalcularDistancias.addActionListener(e -> actionPerformed(e));
    }
    
    public void iniciar() {
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Distancia municipios");
        ventana.setResizable(false);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventana.CalcularDistancias){
            int origen = ventana.ComboBoxOrigen.getSelectedIndex();
            int destino = ventana.ComboBoxDestino.getSelectedIndex();
            mostrarDijstrak(origen,destino);
            mostrarKruskal(origen,destino);
        }
    }
    
    public String listarResultado(int origen, int destino){
        String[] partes = gestor.calcularDijkstra(origen, destino).split(",");

            // Obtener la distancia
        int distancia = Integer.parseInt(partes[partes.length - 1]);

        // Obtener las posiciones
        String[] posiciones = Arrays.copyOf(partes, partes.length - 1);
        StringBuilder textoFinal = new StringBuilder();

        // Reemplazar las posiciones por los nombres del array
        for (String posicion : posiciones) {
            int indice = Integer.parseInt(posicion);
            if (indice >= 0 && indice < listaNombresMunicipios.length) {
                textoFinal.append(listaNombresMunicipios[indice]).append("\n");
            } else {
                System.out.println("La posición " + indice + " está fuera de rango.");
            }
        }

        // Agregar la distancia al texto final
        textoFinal.append(" Distancia = ");
        textoFinal.append(distancia);

        // Imprimir el texto final
        String resultado = "Ciudades recorridas: \n" + textoFinal.toString();
        return resultado;
    }
    
    public void mostrarDijstrak(int origen, int destino){
        ventana.ResultadoDijstrak.setText(listarResultado(origen,destino));
    }
    
    public void mostrarKruskal(int origen, int destino){
        ventana.ResultadoBelmanFord.setText(listarResultado(origen,destino));
    }
}
