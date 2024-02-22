
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Busquedas {
    
    //Atributos:
    private ArrayList<Producto> listaDeProductos;
    private int posicionEnElArreglo;
    private Producto productoEncontrado;
    private double tiempoInicialSecuencial, tiempoInicialBinario, tiempoTotalSecuencial, tiempoTotalBinario;
    
    //Búsqueda secuencial:
    public Producto buscarProductoSecuencialmente(int identificadorDelProducto){
        
        tiempoInicialSecuencial=System.nanoTime();
        
        for(int i=0; i<listaDeProductos.size(); i++){
            if(listaDeProductos.get(i).getIdentificador()==identificadorDelProducto){
                this.tiempoTotalSecuencial = System.nanoTime() - tiempoInicialSecuencial;
                return listaDeProductos.get(i);
            }
            
            this.tiempoTotalSecuencial= System.nanoTime() - tiempoInicialSecuencial;
        }
        
        JOptionPane.showMessageDialog(null, "ERROR: el índice agregado no existe");
        return null;
    } 
    
    //Búsqueda binaria:
    public Producto buscarProductoBinariamente(int identificadorDelProducto){
        
        tiempoInicialBinario = System.nanoTime();
        
        //Variables locales:
        int inicioArreglo = 0;
        int finalArreglo = listaDeProductos.size()-1;
        
        while(inicioArreglo <=finalArreglo){
            
            int medioArreglo = inicioArreglo  + (finalArreglo - inicioArreglo ) / 2;
            
            if(listaDeProductos.get(medioArreglo).getIdentificador()==identificadorDelProducto){
                this.tiempoTotalBinario = System.nanoTime() - tiempoInicialBinario;
                return listaDeProductos.get(medioArreglo);
            }
            
            if(listaDeProductos.get(medioArreglo).getIdentificador() < identificadorDelProducto){
                inicioArreglo  = medioArreglo+1;
            }else{
                finalArreglo= medioArreglo-1;
            }
            
            this.tiempoTotalBinario= System.nanoTime() - tiempoInicialBinario;
        }
        
        JOptionPane.showMessageDialog(null, "ERROR: el índice agregado no existe");
        
        return null;  
    }
       
   
    public void setProductos(ArrayList<Producto> listaDeProductos){
        this.listaDeProductos = listaDeProductos;
        /*
        for(Producto elemento: listaDeProductos){
            System.out.println(elemento.getNombre());
        }
        */
    }

    //Setters y Getters:
    public ArrayList<Producto> getListaDeProductos() {
        return listaDeProductos;
    }
    
    public double getTiempoTotalSecuencial(){
        return tiempoTotalSecuencial;
    }
     
    public double getTiempoTotalBinario(){
        return tiempoTotalBinario;
    }
}
