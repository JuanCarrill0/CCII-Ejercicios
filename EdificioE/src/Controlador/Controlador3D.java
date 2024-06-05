package Controlador;

//Librería Modelo y Vista

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Modelo.ElementosGrafo.Espacio;
import Modelo.ElementosEdificio.Edificio;
import Modelo.ElementosEdificio.Piso;
import Modelo.ElementosEdificio.FachadaCreacionEdificio;
import Modelo.ElementosGrafo.GrafoPanel;
import Modelo.ElementosGrafo.Arista;

import Vista.*;
import java.awt.Color;
import java.util.List;

public class Controlador3D implements ActionListener{
    
    private final MenuCreacion menuCreacion;
    private final Simulacion3D simulacion = new Simulacion3D();
    private final FachadaCreacionEdificio fachada = FachadaCreacionEdificio.getFachada();
    private final String[] args;
    
    public Controlador3D(MenuCreacion menuCreacion, String[] args){
        this.menuCreacion = menuCreacion;
        this.menuCreacion.Simular.addActionListener(e -> actionPerformed(e));
        
        this.args = args;
    }
    
    //Método para iniciar la ventana del menú
    public void iniciar() {
        menuCreacion.setVisible(true);
        menuCreacion.setEnabled(true);
        menuCreacion.setLocationRelativeTo(null);
        menuCreacion.setTitle("Proyecto Final - Habitabilidad Edificio");
        menuCreacion.setResizable(false);
    }
    
    public void iniciarVentanaSimulacion() {
        //System.out.println("Nodos creados antes de anadir: "+simulacion.getCantidadNodos());
        Edificio miEdificioGrafico = this.fachada.getEdificio();
        simulacion.setEdficio(miEdificioGrafico);
        //crearEdificioGrafico(miEdificioGrafico);
        //System.out.println("Nodos creados despues de anadir: "+simulacion.getCantidadNodos());
        simulacion.iniciarSimulacion3D(args);
        //System.out.println("Nodos después de cerrar la simulación: "+simulacion.getCantidadNodos());
    }
    
    
    
    //Método para inicializar el edificio
    public void crearEdificio(int cantidadPisos){
        this.fachada.crearEdificio("Continental", cantidadPisos);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuCreacion.Simular){
            //Inicialización de los valores en memoria
            this.crearEdificio(Integer.parseInt(menuCreacion.cantidadPisos.getText()));
            //Cerrar ventana de creación
            menuCreacion.setVisible(false);
            this.iniciarVentanaSimulacion();
        }

    } 
    
}
