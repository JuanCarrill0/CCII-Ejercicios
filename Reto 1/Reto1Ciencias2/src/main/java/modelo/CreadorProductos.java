
package modelo;

import java.util.ArrayList;
import java.util.Random;

public class CreadorProductos {
    
    //Atributos:
    private ArrayList<Producto> listaDeProductos;
    private static CreadorProductos fachadaCreacionDeProductos;
    
    //Método constructor:
    public CreadorProductos(){
        
        listaDeProductos = new ArrayList<Producto>();
    }
     
    //Método para la instancia CreadorProductos:
    public static CreadorProductos crearFachada(){
        
        if(fachadaCreacionDeProductos==null){
            fachadaCreacionDeProductos = new CreadorProductos();
        }
        
        return fachadaCreacionDeProductos;  
    }
    
    //Métodos para añadir productos:
    public void añadirProducto(Producto productoNuevo){
        listaDeProductos.add(productoNuevo);  
    }
    
    public void crearProductos(int cantidadDeProductos){
        
        Random random = new Random();
        
        for(int i=0; i<cantidadDeProductos; i++){
            Producto nuevoProducto = new Producto(i+(i+random.nextInt(2))+1, generarPrecioAleatorio(), generarNombreAleatorio(), generarDescripcionAleatoria());
            añadirProducto(nuevoProducto);
        }
    }
    
    //Métodos para crear cada uno de los atributos del producto de forma aleatoria:
    
    //Creación del precio:
    
    public double generarPrecioAleatorio(){
        return 10 + (10000-10) * new Random().nextDouble();
    }
    
    //Creación del nombre:
    public String generarNombreAleatorio(){
        
        String[] palabrasIniciales = {"Tomate ","Papa ","Cebolla ","Carne ","Mora ", "Pavo ", "Fríjol ", "Manzana "};
        String[] conectoresDePalabras = {"de ","para ","diseñado para ","en polvo para ", "jugoso para ", "deshídratado para ", "en pulpa para "};
        String[] palabrasFinales = {"condimentar","picar","exprimir", "guisar ", "asar", "hornear", "gratinar", "moler"};
        
        String nombreProducto= 
                
                elegirPalabraAleatoria(palabrasIniciales)+
                               
                elegirPalabraAleatoria(conectoresDePalabras)+
                               
                elegirPalabraAleatoria(palabrasFinales);
        
        return nombreProducto;
      
    }
    
    //Cración de la descripción:
    public String generarDescripcionAleatoria(){
        
            String[] palabrasIniciales = {"Innovador ", "Exclusivo ","Practico ","Ecologico ","Personalizado ", "ideal"};
            String[] conectoresDePalabras = {"para ","con ","dirigido hacia ","pensando en ", "concebido para ", "ideado para "};
            String[] palabrasFinales = {"tu salud ", "la familia "," el hogar moderno"," el bienestar diario", "tu dieta", "tu economía"};
            
            String descripcionProducto=
                    
                    elegirPalabraAleatoria(palabrasIniciales)+
                    
                    elegirPalabraAleatoria(conectoresDePalabras)+
                    
                    elegirPalabraAleatoria(palabrasFinales);
            
            return descripcionProducto;
    }
    
    //Eligir palabras de forma aleatoria:
    public String elegirPalabraAleatoria(String palabras[]){
        
        Random random = new Random();
        
        return palabras[random.nextInt(palabras.length)];
    }

    //Getter:
    public ArrayList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }
        
}
