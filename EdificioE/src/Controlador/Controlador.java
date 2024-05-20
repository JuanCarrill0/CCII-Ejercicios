package Controlador;

import Vista.MostrarHabitacionesPanel;
import Modelo.*;
import Vista.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
    
    private MenuCreacion menuCreacion;
    private Simulacion simulacion = new Simulacion();
    private FachadaCreacionEdificio fachada = FachadaCreacionEdificio.getFachada();
    
    public Controlador(MenuCreacion ventana){
        this.menuCreacion = ventana;
        
        this.menuCreacion.Simular.addActionListener(e -> actionPerformed(e));
        
        this.simulacion.simularPiso.addActionListener(e -> actionPerformed(e));
    }
    
    public void iniciar() {
        menuCreacion.setVisible(true);
        menuCreacion.setEnabled(true);
        menuCreacion.setLocationRelativeTo(null);
        menuCreacion.setTitle("Proyecto Final - Habitabilidad Edificio");
        menuCreacion.setResizable(false);
    }
    
    public void iniciarVentanaSimulacion() {
        simulacion.setVisible(true);
        simulacion.setEnabled(true);
        simulacion.setLocationRelativeTo(null);
        simulacion.setTitle("Proyecto Final - Habitabilidad Edificio");
        simulacion.setResizable(false);
    }
    
    public void crearEdificio(int cantidadPisos){
        this.fachada.crearEdificio("Continental", cantidadPisos);
    }
    
    public void mostrarEdificioConsola(){
        Edificio miEdificio = this.fachada.getEdificio();
        mostrarEdificio(miEdificio);  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == menuCreacion.Simular){
            //Inicialización de los valores en memoria
            this.crearEdificio(Integer.parseInt(menuCreacion.cantidadPisos.getText()));
            //Muestro en consola
            mostrarEdificioConsola();
            //Cerrar ventana de creación
            menuCreacion.setVisible(false);
            this.iniciarVentanaSimulacion();
        }
        
        if(e.getSource() == simulacion.simularPiso){
            Edificio miEdificio = this.fachada.getEdificio();
            System.out.println(miEdificio.getIdentificador());
            System.out.println(miEdificio.getPisos().size());
            Piso primerPiso = miEdificio.getPisos().get(0); // Suponiendo que quieres mostrar el primer piso
            System.out.println(primerPiso.getDisposicion().get(2).getIdentificador());
            MostrarHabitacionesPanel panel = new MostrarHabitacionesPanel(primerPiso.getDisposicion());
            simulacion.setDisplayPanel(panel);
        }
    }
    
    public static void mostrarEdificio(Edificio miEdificio){
        mostrarPisos(miEdificio);
    }
   
    public static void mostrarPisos(Edificio miEdificio){
        System.out.println("\n---------------------------------- PISOS DEL EDIFICIO ----------------------------------");
        System.out.println("\nEdificio: " + miEdificio.getIdentificador());
        System.out.println("\n           _           ");
        System.out.println("          | |          ");
        System.out.println("          | |          ");
        System.out.println("       _________       ");
        System.out.println("      |         |      ");
        System.out.println("    _______________    ");
        System.out.println("   |  " + miEdificio.getIdentificador() + "  |   ");
        System.out.println("_______________________");
        
        for(int i = miEdificio.getPisos().size()-1; i>=0; i--){
            System.out.println("| \t" + miEdificio.getPisos().get(i).getIdentificador()+"\t      |");
            System.out.println("_______________________");
        }
        
        System.out.println("\n---------------------------------- HABITACIONES ----------------------------------");
        
        for(int i = 0; i<miEdificio.getPisos().size(); i++){
            System.out.println("\n---------------- " + miEdificio.getPisos().get(i).getIdentificador()+" ----------------\n");
            System.out.println("_________________________________________________________________________________________________________________________________________________________________________");
            mostrarHabitaciones(miEdificio.getPisos().get(i));
        }
        
        System.out.println("\n---------------------------------- HABITACION CON FUENTE ----------------------------------\n");
        System.out.println(miEdificio.getPisos().get(0).getIdentificador()+" | "+miEdificio.getPisos().get(0).getDisposicion().get(11).getIdentificador()+"\n");
        mostrarEnvoltura(miEdificio.getPisos().get(0).getDisposicion().get(0));
        mostrarHabitacionConFuente(miEdificio.getPisos().get(0).getDisposicion().get(0));
        
    }
    
    public static void mostrarHabitaciones(Piso piso){
        
        for(int i = 0; i < piso.getDisposicion().size(); i++){
            System.out.print("\t"+ piso.getDisposicion().get(i).getIdentificador() +"\t|");
            if ((i + 1) % 7 == 0) {
                System.out.print("\n_________________________________________________________________________________________________________________________________________________________________________\n");
            }
        }  
    }
    
    public static void mostrarHabitacionConFuente(Espacio habitacion){
        
        Fuente fuente = new FuenteInterna("Radio",10000,60,"Electromagnetica");
        habitacion.getEspacioHabitacion().get(3).agregarFuente(fuente);
        
        for(int i = 0; i < habitacion.getEspacioHabitacion().size(); i++){
            System.out.print("\t"+ habitacion.getEspacioHabitacion().get(i).getFuentes() +"\t|");
            if ((i + 1) % 5 == 0) {
                System.out.print("\n_________________________________________________________________________________\n");
            }
        }  
        
        System.out.println("\n\nFuente: "+habitacion.getEspacioHabitacion().get(3).getFuentes().get(0).getIdentificador()+" | Frecuencia: "+habitacion.getEspacioHabitacion().get(3).getFuentes().get(0).getFrecuencia() + " Hz");
        System.out.println("\nDuracion: "+habitacion.getEspacioHabitacion().get(3).getFuentes().get(0).getDuracion()+" segundos | Tipo: "+habitacion.getEspacioHabitacion().get(3).getFuentes().get(0).getTipo());
    }   
    
    public static void mostrarEnvoltura(Espacio habitacion){
        System.out.println("Pared Derecha: "+habitacion.getEnvolturaDelEspacio().getParedDerecha().getNombre()+"\t | Grosor: "+habitacion.getEnvolturaDelEspacio().getParedDerecha().getGrosor()+"cm \t | Absorcion acustica: " +habitacion.getEnvolturaDelEspacio().getParedDerecha().getAbsorcionAcustica()+"dB");
        System.out.println("Pared Izquierda: "+habitacion.getEnvolturaDelEspacio().getParedIzquierda().getNombre()+"\t | Grosor: "+habitacion.getEnvolturaDelEspacio().getParedIzquierda().getGrosor()+"cm \t | Absorcion acustica: " +habitacion.getEnvolturaDelEspacio().getParedIzquierda().getAbsorcionAcustica()+"dB");
        System.out.println("Pared Frontal: "+habitacion.getEnvolturaDelEspacio().getParedFrontal().getNombre()+"\t | Grosor: "+habitacion.getEnvolturaDelEspacio().getParedFrontal().getGrosor()+"cm \t | Absorcion acustica: " +habitacion.getEnvolturaDelEspacio().getParedFrontal().getAbsorcionAcustica()+"dB");
        System.out.println("Pared Trasera: "+habitacion.getEnvolturaDelEspacio().getParedTrasera().getNombre()+"\t | Grosor: "+habitacion.getEnvolturaDelEspacio().getParedTrasera().getGrosor()+"cm \t | Absorcion acustica: " +habitacion.getEnvolturaDelEspacio().getParedTrasera().getAbsorcionAcustica()+"dB");
        System.out.println("Techo: "+habitacion.getEnvolturaDelEspacio().getTecho().getNombre()+"\t | Grosor: "+habitacion.getEnvolturaDelEspacio().getTecho().getGrosor()+"cm \t | Absorcion acustica: " +habitacion.getEnvolturaDelEspacio().getTecho().getAbsorcionAcustica()+"dB");
        System.out.println("Suelo: "+habitacion.getEnvolturaDelEspacio().getSuelo().getNombre()+"\t | Grosor: "+habitacion.getEnvolturaDelEspacio().getSuelo().getGrosor()+"cm \t | Absorcion acustica: " +habitacion.getEnvolturaDelEspacio().getSuelo().getAbsorcionAcustica()+"dB");
        System.out.println("\n");
    }
    
}
