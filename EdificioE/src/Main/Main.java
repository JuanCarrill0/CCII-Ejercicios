package Main;

import Modelo.*;

public class Main {
    
    public static void main(String[] args){
        
        FachadaCreacionEdificio fachada = FachadaCreacionEdificio.getFachada();
        
        fachada.crearEdificio("Continental", 3);
        
        Edificio e = fachada.getEdificio();
        
        for(int i = 0; i<e.getPisos().size(); i++){
            Piso p = e.getPisos().get(i);
            System.out.println(p.getIdentificador());
            for(int j = 0; j<p.getDisposicion().size(); j++){
                System.out.println(p.getDisposicion().get(j).getEnvolturaDelEspacio().getParedTrasera().getNombre());
            }
        }
        
        
    }
    
}
