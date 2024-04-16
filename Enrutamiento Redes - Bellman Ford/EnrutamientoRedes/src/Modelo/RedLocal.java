/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author tic-asisweb01
 */
public class RedLocal {
    
    private final AlgoritmoBellmanFord bellmanFord = new AlgoritmoBellmanFord();
    
    // Creación de servidores
    Servidor servidorA = new Servidor(100, 90, 5, 8080, "192.168.1.1");
    Servidor servidorB = new Servidor(120, 100, 6, 8181, "192.168.1.2");
    Servidor servidorC = new Servidor(80, 70, 4, 8282, "192.168.1.3");
    Servidor servidorD = new Servidor(150, 130, 7, 8383, "192.168.1.4");
    Servidor servidorE = new Servidor(110, 95, 55, 8484, "192.168.1.5");
    Servidor servidorF = new Servidor(90, 80, 45, 8585, "192.168.1.6");
    // Creación de Router Nucleo
    RouterNucleo routerNucleo1 = new RouterNucleo(1000, 900, 8, "RouterNucleo1", 24);
    RouterNucleo routerNucleo2 = new RouterNucleo(1200, 1000, 9, "RouterNucleo2", 48);
    RouterNucleo routerNucleo3 = new RouterNucleo(800, 700, 7, "RouterNucleo3", 16);
    // Creación de Router de Distribución
    RouterDistribucion routerDistribucion1 = new RouterDistribucion(1000, 900, 8, "00:11:22:33:44:55", "192.168.1.1");
    RouterDistribucion routerDistribucion2 = new RouterDistribucion(1200, 1000, 9, "11:22:33:44:55:66", "192.168.1.2");
    RouterDistribucion routerDistribucion3 = new RouterDistribucion(800, 700, 7, "22:33:44:55:66:77", "192.168.1.3");
    RouterDistribucion routerDistribucion4 = new RouterDistribucion(1500, 950, 75, "33:44:55:66:77:88", "192.168.1.4");
    RouterDistribucion routerDistribucion5 = new RouterDistribucion(1300, 800, 65, "44:55:66:77:88:99", "192.168.1.5");
    RouterDistribucion routerDistribucion6 = new RouterDistribucion(1100, 900, 8, "55:66:77:88:99:00", "192.168.1.6");
    RouterDistribucion routerDistribucion7 = new RouterDistribucion(1200, 1000, 9, "66:77:88:99:00:11", "192.168.1.7");
    RouterDistribucion routerDistribucion8 = new RouterDistribucion(800, 700, 7, "77:88:99:00:11:22", "192.168.1.8");
    RouterDistribucion routerDistribucion9 = new RouterDistribucion(1100, 950, 75, "88:99:00:11:22:33", "192.168.1.9");
    RouterDistribucion routerDistribucion10 = new RouterDistribucion(900, 800, 65, "99:00:11:22:33:44", "192.168.1.10");
    RouterDistribucion routerDistribucion11 = new RouterDistribucion(1000, 900, 8, "AA:BB:CC:DD:EE:FF", "192.168.1.11");
    RouterDistribucion routerDistribucion12 = new RouterDistribucion(1200, 1000, 9, "BB:CC:DD:EE:FF:00", "192.168.1.12");

    
    //Listado de conexiones de sección a sección
    
    //Conexiones de frontera izquierda a primera sección nucleo y distribución
    int SA_RD1 = calcularConexion(this.servidorA.getRelacionSR(),this.routerDistribucion1.getRelacionSR());
    int SA_RN1 = calcularConexion(this.servidorA.getRelacionSR(),this.routerNucleo1.getRelacionSR());
    int SB_RN1 = calcularConexion(this.servidorB.getRelacionSR(),this.routerNucleo1.getRelacionSR());
    int SC_RD2 = calcularConexion(this.servidorC.getRelacionSR(),this.routerDistribucion2.getRelacionSR());
    int SC_RD3 = calcularConexion(this.servidorC.getRelacionSR(),this.routerDistribucion3.getRelacionSR());
    //Conexiones de primera sección nucleo y distribucion a 2
    int RD1_RD4 = calcularConexion(this.routerDistribucion1.getRelacionSR(),this.routerDistribucion4.getRelacionSR());
    int RN1_RD5 = calcularConexion(this.routerNucleo1.getRelacionSR(), this.routerDistribucion5.getRelacionSR());
    int RD2_RN2 = calcularConexion(this.routerDistribucion2.getRelacionSR(),this.routerNucleo2.getRelacionSR());
    int RD3_RN2 = calcularConexion(this.routerDistribucion3.getRelacionSR(),this.routerNucleo2.getRelacionSR());
    //Conexion de segunda sección nucleo y distribución a 3
    int RD1_RD6 = calcularConexion(this.routerDistribucion1.getRelacionSR(),this.routerDistribucion6.getRelacionSR());
    int RD4_RN3 = calcularConexion(this.routerDistribucion4.getRelacionSR(),this.routerNucleo3.getRelacionSR());
    int RD5_RN3 = calcularConexion(this.routerDistribucion5.getRelacionSR(),this.routerNucleo3.getRelacionSR());
    int RN2_RD7 = calcularConexion(this.routerNucleo2.getRelacionSR(), this.routerDistribucion7.getRelacionSR());
    int RN2_RD8 = calcularConexion(this.routerNucleo2.getRelacionSR(), this.routerDistribucion8.getRelacionSR());  
    //Conexiones de tercera sección nucleo y distribución a 4
    int RN3_RD9 = calcularConexion(this.routerNucleo3.getRelacionSR(), this.routerDistribucion9.getRelacionSR());
    int RN3_RD10 = calcularConexion(this.routerNucleo3.getRelacionSR(), this.routerDistribucion10.getRelacionSR());
    int RN3_RD11 = calcularConexion(this.routerNucleo3.getRelacionSR(), this.routerDistribucion11.getRelacionSR());
    int RD7_RD11 = calcularConexion(this.routerDistribucion7.getRelacionSR(),this.routerDistribucion11.getRelacionSR());
    int RD8_RD11 = calcularConexion(this.routerDistribucion8.getRelacionSR(),this.routerDistribucion11.getRelacionSR());
    //Conexiones de cuarta seccion nucle y distribucion a Frontera Derecha
    int RD9_SD = calcularConexion(this.routerDistribucion9.getRelacionSR(),this.servidorD.getRelacionSR());
    int RD10_SD = calcularConexion(this.routerDistribucion10.getRelacionSR(),this.servidorD.getRelacionSR());
    int RD10_SE = calcularConexion(this.routerDistribucion10.getRelacionSR(),this.servidorE.getRelacionSR());
    int RD12_SF = calcularConexion(this.routerDistribucion12.getRelacionSR(),this.servidorF.getRelacionSR());
    
    //Listado de conexiones entre secciones
    
    //Sección de nucleo y distribución 1
    
    int RD1_RN1 = calcularConexion(this.routerDistribucion1.getRelacionSR(),this.routerNucleo1.getRelacionSR());
    int RD2_RN1 = calcularConexion(this.routerDistribucion2.getRelacionSR(),this.routerNucleo1.getRelacionSR());
    int RD2_RD3 = calcularConexion(this.routerDistribucion2.getRelacionSR(),this.routerDistribucion3.getRelacionSR());
    
    //Sección de nucleo y distribución 2
    int RD4_RD5 = calcularConexion(this.routerDistribucion4.getRelacionSR(),this.routerDistribucion5.getRelacionSR());
    int RD5_RN2 = calcularConexion(this.routerDistribucion5.getRelacionSR(),this.routerNucleo2.getRelacionSR());
    
    //Sección de nucleo y distribución 3
    int RD6_RN3 = calcularConexion(this.routerDistribucion6.getRelacionSR(),this.routerNucleo3.getRelacionSR());
    int RD7_RN3 = calcularConexion(this.routerDistribucion7.getRelacionSR(),this.routerNucleo3.getRelacionSR());
    int RD7_RD8 = calcularConexion(this.routerDistribucion7.getRelacionSR(),this.routerDistribucion8.getRelacionSR());
    
    //Sección de nucleo y distribución 4
    int RD9_RD10 = calcularConexion(this.routerDistribucion9.getRelacionSR(),this.routerDistribucion10.getRelacionSR());
    int RD10_RD11 = calcularConexion(this.routerDistribucion10.getRelacionSR(),this.routerDistribucion11.getRelacionSR());
    int RD11_RD12 = calcularConexion(this.routerDistribucion11.getRelacionSR(),this.routerDistribucion12.getRelacionSR());
    //Método para calcular las conexiones entre 2 nodos
    
    public int calcularConexion(double relacionSR1, double relacionSR2){
        return (int)(relacionSR1 + relacionSR2);
    }
    public int[][] matrizAdyacenciaRedLocal = {
    //SA-SB-SC-SD-SE-SF-RN1-RN2-RN3-RD1-RD2-RD3-RD4-RD5-RD6-RD7-RD8-RD9-RD10-RD11-RD12
    /*SA 0*/     {0, 0, 0, 0, 0, 0, SA_RN1, 0, 0, SA_RD1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
    /*SB 1*/     {0, 0, 0, 0, 0, 0, SB_RN1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0,0},
    /*SC 2*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, SC_RD2, SC_RD3, 0, 0, 0, 0, 0, 0, 0, 0,0},
    /*SD 3*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, RD9_SD, RD10_SD, 0,0},
    /*SE 4*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, RD10_SE, 0,0},
    /*SF 5*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,RD12_SF},
    /*RN1 6*/    {SA_RN1, SB_RN1, 0, 0, 0, 0, 0, 0, 0, RD1_RN1, RD2_RN1, 0, 0, RN1_RD5, 0, 0, 0, 0, 0, 0,0},
    /*RN2 7*/    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, RD2_RN2, RD3_RN2, 0, RD5_RN2, 0, RN2_RD7, RN2_RD8, 0, 0, 0,0},
    /*RN3 8*/    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, RD4_RN3, RD5_RN3, RD6_RN3, RD7_RN3, 0, RN3_RD9, RN3_RD10, RN3_RD11,0},
    /*RD1 9*/    {SA_RD1, 0, 0, 0, 0, 0, RD1_RN1, 0, 0, 0, 0, 0, RD1_RD4, 0, RD1_RD6, 0, 0, 0, 0, 0,0},
    /*RD2 10*/   {0, SC_RD2, 0, 0, 0, 0, RD2_RN1, RD2_RN2, 0, 0, 0, RD2_RD3, 0, 0, 0, 0, 0, 0, 0, 0,0},
    /*RD3 11*/   {0, 0, SC_RD3, 0, 0, 0, 0, RD3_RN2, 0, 0, RD2_RD3, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
    /*RD4 12*/   {0, 0, 0, 0, 0, 0, 0, 0, RD4_RN3, RD1_RD4, 0, 0, 0, RD4_RD5, 0, 0, 0, 0, 0, 0,0},
    /*RD5 13*/   {0, 0, 0, 0, 0, 0, RN1_RD5, RD5_RN2, RD5_RN3, 0, 0, 0, RD4_RD5, 0, 0, 0, 0, 0, 0, 0,0},
    /*RD6 14*/   {0, 0, 0, 0, 0, 0, 0, 0, RD6_RN3, RD1_RD6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
    /*RD7 15*/   {0, 0, 0, 0, 0, 0, 0, RN2_RD7, RD7_RN3, 0, 0, 0, 0, 0, 0, 0, RD7_RD8, 0, 0, RD7_RD11,0},
    /*RD8 16*/   {0, 0, 0, 0, 0, 0, 0, RN2_RD8, 0, 0, 0, 0, 0, 0, 0, RD7_RD8, 0, 0, 0, RD8_RD11,0},
    /*RD9 17*/   {0, 0, 0, RD9_SD, 0, 0, 0, 0, RN3_RD9, 0, 0, 0, 0, 0, 0, 0, 0, 0, RD9_RD10, 0,0},
    /*RD10 18*/  {0, 0, 0, RD10_SD, RD10_SE, 0, 0, 0, RN3_RD10, 0, 0, 0, 0, 0, 0, 0, 0, RD9_RD10, 0, RD10_RD11,0},
    /*RD11 19*/  {0, 0, 0, 0, 0, 0, RN3_RD11, 0, 0, 0, 0, 0, 0, 0, 0, RD7_RD11, RD8_RD11, 0, RD10_RD11, 0,RD11_RD12},
    /*RD12 20*/  {0, 0, 0, 0, 0, RD12_SF, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, RD11_RD12,0},
};


    
   public void calcularDistancias(int origen, int destino){
       this.bellmanFord.setMatrizDeAdyacencias(matrizAdyacenciaRedLocal);
       this.bellmanFord.imprimirMatrizDeAdyacencia();
       System.out.println(this.bellmanFord.calcularRutaMasCorta(origen, destino));
   }
    
}
