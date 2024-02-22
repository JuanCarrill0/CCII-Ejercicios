
package controlador;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.Busquedas;
import modelo.CreadorProductos;
import modelo.Producto;
import vista.Vista;

public class Controlador {
    
    //OBJETOS
    private Vista vista;
    private CreadorProductos creadorProductos;
    private Busquedas busquedas;
    private Producto producto;
    
    public Controlador(Vista vista, CreadorProductos creadorProductos, Busquedas busquedas){
        
        this.vista = vista;
        this.creadorProductos = creadorProductos;
        this.busquedas = busquedas;
        //Botones:
        
        vista.btnGenerar.addActionListener(e -> actionPerformed(e));
        vista.btnBinaria.addActionListener(e -> actionPerformed(e));
        vista.btnSecuencial.addActionListener(e -> actionPerformed(e));
        
    }
    
    
    public void iniciar(){
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("Búsqueda secuencial y binaria");
        vista.setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==vista.btnGenerar){
            try{
                
                //Número de productos para crear:
                int numeroDeProductos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de productos que desea generar"));
                //creación y fijación de los productos creados
                creadorProductos.crearProductos(numeroDeProductos );
                busquedas.setProductos(creadorProductos.getListaDeProductos());
                JOptionPane.showMessageDialog(null, "Productos creados exitosamente");
               
            }catch(Exception x){
                JOptionPane.showMessageDialog(null, "Número no válido");
            } 
        }
        
        else if(e.getSource()==vista.btnSecuencial){
            
            try{

                //Obtenemos de vuelta el producto encontrado:
                Producto productoEncontrado= busquedas.buscarProductoSecuencialmente(Integer.parseInt(vista.txtBusqueda.getText()));
                imprimirProducto(productoEncontrado, false); 
                
            }catch(Exception x){
                
            }
            
        }else if(e.getSource()==vista.btnBinaria){
            
            try{

                //Obtenemos de vuelta el producto encontrado:
                Producto productoEncontrado = busquedas.buscarProductoBinariamente(Integer.parseInt(vista.txtBusqueda.getText()));
                imprimirProducto(productoEncontrado, true);
                
            }catch(Exception x){
           
            }
            
        }
    }   
    
    public void imprimirProducto(Producto productoEncontrado, boolean esBinaria){
        
        //Obtenemos los atributos del producto encontrado:
        int id = productoEncontrado.getIdentificador();
        String nombre = productoEncontrado.getNombre();
        double precio = productoEncontrado.getPrecio();
        String descripcion = productoEncontrado.getDescripcion();
        
        //Los imprimimos en la vista:
        
        if(esBinaria==false){
            vista.lblIDSecuencial.setText("ID: "+String.valueOf(id));
            vista.lblNombreSecuencial.setText("Nombre: "+nombre);
            vista.lblPrecioSecuencial.setText("Precio: "+String.format("%.2f", precio));
            vista.lblDescripcionSecuencial.setText("Descripcion: "+descripcion);
            vista.lblTiempoSecuencial.setText("Tiempo para búsqueda secuencial: "+busquedas.getTiempoTotalSecuencial());
            
        }else if(esBinaria==true){
            vista.lblIDBinaria.setText("ID: "+String.valueOf(id));
            vista.lblNombreBinaria.setText("Nombre: "+nombre);
            vista.lblPrecioBinaria.setText("Precio: "+String.format("%.2f", precio));
            vista.lblDescripcionBinaria.setText("Descripcion: "+descripcion); 
            vista.lblTiempoBinaria.setText("Tiempo para búsqueda binaria: "+busquedas.getTiempoTotalBinario());
        }

  
    }
    
}
