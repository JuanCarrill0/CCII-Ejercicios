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
    
    //Creación de servidores
    Servidor servidorA = new Servidor(100.0f, 90.0f, 0.5f, 8080, "192.168.1.1");
    Servidor servidorB = new Servidor(120.0f, 100.0f, 0.6f, 8181, "192.168.1.2");
    Servidor servidorC = new Servidor(80.0f, 70.0f, 0.4f, 8282, "192.168.1.3");
    Servidor servidorD = new Servidor(150.0f, 130.0f, 0.7f, 8383, "192.168.1.4");
    Servidor servidorE = new Servidor(110.0f, 95.0f, 0.55f, 8484, "192.168.1.5");
    Servidor servidorF = new Servidor(90.0f, 80.0f, 0.45f, 8585, "192.168.1.6");
    //Creación de Router Nucleo
    RouterNucleo routerNucleo1 = new RouterNucleo(1000.0f, 900.0f, 0.8f, "RouterNucleo1", 24);
    RouterNucleo routerNucleo2 = new RouterNucleo(1200.0f, 1000.0f, 0.9f, "RouterNucleo2", 48);
    RouterNucleo routerNucleo3 = new RouterNucleo(800.0f, 700.0f, 0.7f, "RouterNucleo3", 16);
    //Creación de Router de Distribución
    RouterDistribucion routerDistribucion1 = new RouterDistribucion(1000.0f, 900.0f, 0.8f, "00:11:22:33:44:55", "192.168.1.1");
    RouterDistribucion routerDistribucion2 = new RouterDistribucion(1200.0f, 1000.0f, 0.9f, "11:22:33:44:55:66", "192.168.1.2");
    RouterDistribucion routerDistribucion3 = new RouterDistribucion(800.0f, 700.0f, 0.7f, "22:33:44:55:66:77", "192.168.1.3");
    RouterDistribucion routerDistribucion4 = new RouterDistribucion(1100.0f, 950.0f, 0.75f, "33:44:55:66:77:88", "192.168.1.4");
    RouterDistribucion routerDistribucion5 = new RouterDistribucion(900.0f, 800.0f, 0.65f, "44:55:66:77:88:99", "192.168.1.5");
    RouterDistribucion routerDistribucion6 = new RouterDistribucion(1000.0f, 900.0f, 0.8f, "55:66:77:88:99:00", "192.168.1.6");
    RouterDistribucion routerDistribucion7 = new RouterDistribucion(1200.0f, 1000.0f, 0.9f, "66:77:88:99:00:11", "192.168.1.7");
    RouterDistribucion routerDistribucion8 = new RouterDistribucion(800.0f, 700.0f, 0.7f, "77:88:99:00:11:22", "192.168.1.8");
    RouterDistribucion routerDistribucion9 = new RouterDistribucion(1100.0f, 950.0f, 0.75f, "88:99:00:11:22:33", "192.168.1.9");
    RouterDistribucion routerDistribucion10 = new RouterDistribucion(900.0f, 800.0f, 0.65f, "99:00:11:22:33:44", "192.168.1.10");
    RouterDistribucion routerDistribucion11 = new RouterDistribucion(1000.0f, 900.0f, 0.8f, "AA:BB:CC:DD:EE:FF", "192.168.1.11");
    RouterDistribucion routerDistribucion12 = new RouterDistribucion(1200.0f, 1000.0f, 0.9f, "BB:CC:DD:EE:FF:00", "192.168.1.12");
    
    //Listado de conexiones de sección a sección
    
    //Conexiones de frontera izquierda a primera sección nucleo y distribución
    double SA_RD1 = calcularConexion(this.servidorA.getRelacionSR(),this.routerDistribucion1.getRelacionSR());
    double SA_RN1 = calcularConexion(this.servidorA.getRelacionSR(),this.routerNucleo1.getRelacionSR());
    double SB_RN1 = calcularConexion(this.servidorB.getRelacionSR(),this.routerNucleo1.getRelacionSR());
    double SC_RD2 = calcularConexion(this.servidorC.getRelacionSR(),this.routerDistribucion2.getRelacionSR());
    double SC_RD3 = calcularConexion(this.servidorC.getRelacionSR(),this.routerDistribucion3.getRelacionSR());
    //Conexiones de primera sección nucleo y distribucion a 2
    double RD1_RD4 = calcularConexion(this.routerDistribucion1.getRelacionSR(),this.routerDistribucion4.getRelacionSR());
    double RN1_RD5 = calcularConexion(this.routerNucleo1.getRelacionSR(), this.routerDistribucion5.getRelacionSR());
    double RD2_RN2 = calcularConexion(this.routerDistribucion2.getRelacionSR(),this.routerNucleo2.getRelacionSR());
    double RD3_RN2 = calcularConexion(this.routerDistribucion3.getRelacionSR(),this.routerNucleo2.getRelacionSR());
    //Conexion de segunda sección nucleo y distribución a 3
    double RD1_RD6 = calcularConexion(this.routerDistribucion1.getRelacionSR(),this.routerDistribucion6.getRelacionSR());
    double RD4_RN3 = calcularConexion(this.routerDistribucion4.getRelacionSR(),this.routerNucleo3.getRelacionSR());
    double RD5_RN3 = calcularConexion(this.routerDistribucion5.getRelacionSR(),this.routerNucleo3.getRelacionSR());
    double RN2_RD7 = calcularConexion(this.routerNucleo2.getRelacionSR(), this.routerDistribucion7.getRelacionSR());
    double RN2_RD8 = calcularConexion(this.routerNucleo2.getRelacionSR(), this.routerDistribucion8.getRelacionSR());  
    //Conexiones de tercera sección nucleo y distribución a 4
    double RN3_RD9 = calcularConexion(this.routerNucleo3.getRelacionSR(), this.routerDistribucion9.getRelacionSR());
    double RN3_RD10 = calcularConexion(this.routerNucleo3.getRelacionSR(), this.routerDistribucion10.getRelacionSR());
    double RN3_RD11 = calcularConexion(this.routerNucleo3.getRelacionSR(), this.routerDistribucion11.getRelacionSR());
    double RD7_RD11 = calcularConexion(this.routerDistribucion7.getRelacionSR(),this.routerDistribucion11.getRelacionSR());
    double RD8_RD11 = calcularConexion(this.routerDistribucion8.getRelacionSR(),this.routerDistribucion11.getRelacionSR());
    //Conexiones de cuarta seccion nucle y distribucion a Frontera Derecha
    double RD9_SD = calcularConexion(this.routerDistribucion9.getRelacionSR(),this.servidorD.getRelacionSR());
    double RD10_SD = calcularConexion(this.routerDistribucion10.getRelacionSR(),this.servidorD.getRelacionSR());
    double RD10_SE = calcularConexion(this.routerDistribucion10.getRelacionSR(),this.servidorE.getRelacionSR());
    double RD12_SF = calcularConexion(this.routerDistribucion12.getRelacionSR(),this.servidorF.getRelacionSR());
    
    //Listado de conexiones entre secciones
    
    //Sección de nucleo y distribución 1
    
    double RD1_RN1 = calcularConexion(this.routerDistribucion1.getRelacionSR(),this.routerNucleo1.getRelacionSR());
    double RD2_RN1 = calcularConexion(this.routerDistribucion2.getRelacionSR(),this.routerNucleo1.getRelacionSR());
    double RD2_RD3 = calcularConexion(this.routerDistribucion2.getRelacionSR(),this.routerDistribucion3.getRelacionSR());
    
    //Sección de nucleo y distribución 2
    double RD4_RD5 = calcularConexion(this.routerDistribucion4.getRelacionSR(),this.routerDistribucion5.getRelacionSR());
    double RD5_RN2 = calcularConexion(this.routerDistribucion5.getRelacionSR(),this.routerNucleo2.getRelacionSR());
    
    //Sección de nucleo y distribución 3
    double RD6_RN3 = calcularConexion(this.routerDistribucion6.getRelacionSR(),this.routerNucleo3.getRelacionSR());
    double RD7_RN3 = calcularConexion(this.routerDistribucion7.getRelacionSR(),this.routerNucleo3.getRelacionSR());
    double RD7_RD8 = calcularConexion(this.routerDistribucion7.getRelacionSR(),this.routerDistribucion8.getRelacionSR());
    
    //Sección de nucleo y distribución 4
    double RD9_RD10 = calcularConexion(this.routerDistribucion9.getRelacionSR(),this.routerDistribucion10.getRelacionSR());
    double RD10_RD11 = calcularConexion(this.routerDistribucion10.getRelacionSR(),this.routerDistribucion11.getRelacionSR());
    double RD11_RD12 = calcularConexion(this.routerDistribucion11.getRelacionSR(),this.routerDistribucion12.getRelacionSR());
    //Método para calcular las conexiones entre 2 nodos
    
    public double calcularConexion(double relacionSR1, double relaciónSR2){
        return Math.sqrt(relacionSR1 + relaciónSR2);
    }
    private int [][] matridAdyancenciaRedLocal = {
                //A-B-C-D-E-F-RN1-RN2-RN3-RD1-RD2-RD3-RD4-RD5-RD6-RD7-RD8-RD9-RD10-RD11-RD12
       /*A*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*B*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0},
       /*C*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*D*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*E*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0, 0},
       /*F*/     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RN1*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RN2*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RN3*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD1*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD2*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD3*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD4*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD5*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD6*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD7*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD8*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD9*/   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD10*/  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD11*/  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
       /*RD12*/  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
  };
    
}
