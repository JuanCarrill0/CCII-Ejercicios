package Modelo.ElementosGrafo;

import Modelo.ElementosEdificio.Actividad;
import Modelo.ElementosEdificio.MaterialEnvolvente;
import Modelo.ElementosEdificio.MetroCuadrado;
import Modelo.ElementosEdificio.Fuente;
import Modelo.ElementosEdificio.Envoltura;
import java.awt.Color;
import java.util.ArrayList;

public class Espacio{
    
    //Variables de información del espacio
    protected ArrayList<MetroCuadrado> espacioHabitacion;
    protected ArrayList<Fuente> fuentesExternas;
    protected ArrayList<MaterialEnvolvente> materialesEnvolventes;
    protected String identificador;
    protected int tiempoDeReverberacion;
    protected short cantidadDePersonas;
    protected short indiceDeHabitabilidad;
    protected Envoltura envolturaDelEspacio;
    protected boolean esPerimetral;
    protected String orientacionPerimetro;
    protected int numeroEspacio;
    
    //Variables de posición en el grafo
    public int x, y;
    public Color colorEspacio;
    public Color colorGrafico;
    
    //Variables de actividad
    public Actividad actividad;
    
    public Espacio(String identificador, boolean esPerimetral, String orientacionPerimetro){
        this.identificador = identificador;
        this.esPerimetral = esPerimetral;
        this.orientacionPerimetro = orientacionPerimetro;
        espacioHabitacion = new ArrayList<>();
        fuentesExternas = new ArrayList<>();
        generarMaterialesEnvolventes();
        crearEnvoltura(esPerimetral,orientacionPerimetro);
    }
    
    public Espacio(int x, int y, Color colorEspacio, Color colorGrafico, Actividad actividad, int numeroEspacio) {
        this.x = x;
        this.y = y;
        this.colorEspacio = colorEspacio;
        this.colorGrafico = colorGrafico;
        this.actividad = actividad;
        this.numeroEspacio = numeroEspacio;
        espacioHabitacion = new ArrayList<>();
        fuentesExternas = new ArrayList<>();
    }
    
    public void agregarFuenteExterna(){
        
    }
    
    public void calcularReverberacion(){
        
    }
    
    public void calcularHabitabilidad(){
        
    }
    
    public void crearEnvoltura(boolean esPerimetral, String orientacionPerimetro){
       
        if(esPerimetral == true){
            switch(orientacionPerimetro){
                case "norte":
                    envolturaDelEspacio = new Envoltura("NN",materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(0),materialesEnvolventes.get(1),materialesEnvolventes.get(4),materialesEnvolventes.get(4));
                    break;
                case "sur":
                    envolturaDelEspacio = new Envoltura("NN",materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(0),materialesEnvolventes.get(4),materialesEnvolventes.get(4));
                    break;
                case "este":
                    envolturaDelEspacio = new Envoltura("NN",materialesEnvolventes.get(0),materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(4),materialesEnvolventes.get(4));
                    break;
                case "oeste":
                    envolturaDelEspacio = new Envoltura("NN",materialesEnvolventes.get(1),materialesEnvolventes.get(0),materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(4),materialesEnvolventes.get(4));
                    break;
                default:
                    envolturaDelEspacio = new Envoltura("NN",materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(4),materialesEnvolventes.get(4));
            }
        }else{
            envolturaDelEspacio = new Envoltura("NN",materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(1),materialesEnvolventes.get(4),materialesEnvolventes.get(4));
        }
    }
    
    protected void generarMaterialesEnvolventes(){
        materialesEnvolventes = new ArrayList<>();
        
        MaterialEnvolvente vidrio = new MaterialEnvolvente("Vidrio",(float) 27,(float) 0.03);
        MaterialEnvolvente ladrilloCeramico = new MaterialEnvolvente("Ladrillo ceramico",(float) 49,(float) 13);
        MaterialEnvolvente hormigonArmado = new MaterialEnvolvente("Hormigon armado",(float) 52,(float) 12);
        MaterialEnvolvente tabiqueHuecoDoble = new MaterialEnvolvente("Tabique hueco doble",(float) 36,(float) 12);
        MaterialEnvolvente losaAlveolarMaciza = new MaterialEnvolvente("Lozas alveolares sencillas",(float) 71,(float) 15);
        
        materialesEnvolventes.add(vidrio);
        materialesEnvolventes.add(hormigonArmado);
        materialesEnvolventes.add(ladrilloCeramico);
        materialesEnvolventes.add(tabiqueHuecoDoble);
        materialesEnvolventes.add(losaAlveolarMaciza);
        
    }
    
    public void agregarMetro(MetroCuadrado metroCuadrado){
        espacioHabitacion.add(metroCuadrado);
    }
    
    public ArrayList<MetroCuadrado> getEspacioHabitacion(){
        return espacioHabitacion;
    }
    
    public String getIdentificador(){
        return identificador;
    }
    
    public Envoltura getEnvolturaDelEspacio() {
        return envolturaDelEspacio;
    }

    public Color getColor() {
        return colorEspacio;
    }
    
    public int getNumeroEspacio(){
        return numeroEspacio;
    }
}
