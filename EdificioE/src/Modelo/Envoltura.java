package Modelo;

public class Envoltura{

    private String identificador;
    private MaterialEnvolvente paredDerecha;
    private MaterialEnvolvente paredIzquierda;
    private MaterialEnvolvente paredFrontal;
    private MaterialEnvolvente paredTrasera;
    private MaterialEnvolvente techo;
    private MaterialEnvolvente suelo;
    
    
    public Envoltura(String identificador, MaterialEnvolvente paredDerecha, MaterialEnvolvente paredIzquierda, MaterialEnvolvente paredFrontal, MaterialEnvolvente paredTrasera, MaterialEnvolvente techo, MaterialEnvolvente suelo){
        this.identificador = identificador;
        this.paredDerecha = paredDerecha;
        this.paredIzquierda = paredIzquierda;
        this.paredFrontal = paredFrontal;
        this.paredTrasera = paredTrasera;
        this.techo = techo;
        this.suelo = suelo;
    }
    
    public int calcularReverberacion(){
        return 0;
    }
    
    public String getIdentificador() {
        return identificador;
    }
    
    public MaterialEnvolvente getParedDerecha() {
        return paredDerecha;
    }

    public MaterialEnvolvente getParedIzquierda() {
        return paredIzquierda;
    }

    public MaterialEnvolvente getParedFrontal() {
        return paredFrontal;
    }

    public MaterialEnvolvente getParedTrasera() {
        return paredTrasera;
    }

    public MaterialEnvolvente getTecho() {
        return techo;
    }

    public MaterialEnvolvente getSuelo() {
        return suelo;
    }

}
