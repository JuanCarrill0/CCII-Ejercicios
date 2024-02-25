package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Hash {
    
    private int[] hashMap = new int[10];
    
    public int transformarFecha(String fecha){
        
        int dia, mes, año, hora, minuto, fechaDef = 0;
        Calendar calendario = Calendar.getInstance();
        
        try{
            
            Date f = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(fecha);
            calendario.setTime(f);
            
            dia = calendario.get(Calendar.DAY_OF_MONTH);
            mes = calendario.get(Calendar.MONTH)+1;
            año = calendario.get(Calendar.YEAR);
            hora = calendario.get(Calendar.HOUR);
            minuto = calendario.get(Calendar.MINUTE);
            
            fechaDef = dia+mes+año+hora+minuto;
            
            
            
        }catch(Exception SimpleDateFormat){
            JOptionPane.showMessageDialog(null,"Error del formato en la fecha");
        }
        
        return fechaDef;
    }
    
    
    public void crearHash(int idComprador, int idVendedor,int idTransaccion, int idProducto, String fecha){
        
        int hash = idComprador + idVendedor + idTransaccion + idProducto + transformarFecha(fecha);
        
        hashMap[hash%hashMap.length] = hash;
    }
    
    
    
}
