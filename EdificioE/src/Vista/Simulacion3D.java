package Vista;

//Libreria JavaFX
import Modelo.ElementosEdificio.Edificio;
import Modelo.ElementosEdificio.Piso;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.AmbientLight;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import static javafx.scene.input.KeyCode.E;
import static javafx.scene.input.KeyCode.Q;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.W;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Simulacion3D extends Application{
    
  private static final float WIDTH = 1400;
  private static final float HEIGHT = 1000;
  private static Edificio edificio;

  private double anchorX, anchorY;
  private double anchorAngleX = 0;
  private double anchorAngleY = 0;
  private final DoubleProperty angleX = new SimpleDoubleProperty(0);
  private final DoubleProperty angleY = new SimpleDoubleProperty(0);
  private final PointLight pointLight = new PointLight();
  
  private ArrayList<Sphere> nodosEdificio = new ArrayList<Sphere>();

  @Override
  public void start(Stage primaryStage) {
      
    Box box = prepareBox(edificio);
    Button btn = new Button("Hola");
    SmartGroup group = new SmartGroup();
    group.getChildren().add(box);
    //group.getChildren().add(btn);
    //group.getChildren().add(prepareSecondBox());
    //group.getChildren().add(new Sphere(20));
    group.getChildren().add(new AmbientLight());
      System.out.println("Nodos durante el start: "+ nodosEdificio.size());
    
      crearEdificioGrafico(edificio);
      
      System.out.println("Nodos si que si en lista: " +nodosEdificio.size());
      for(int i=0; i<nodosEdificio.size(); i++){
          group.getChildren().add(nodosEdificio.get(i));
      }
      System.out.println("Salí del bucle");
      
    Camera camera = new PerspectiveCamera(true);
    camera.setNearClip(1);
    camera.setFarClip(4000);
    camera.translateZProperty().set(-200);

    Scene scene = new Scene(group, WIDTH, HEIGHT, true);
    scene.setFill(Color.SILVER);
    scene.setCamera(camera);

    group.translateXProperty().set(0);
    group.translateYProperty().set(0);
    group.translateZProperty().set(0);

    initMouseControl(group, scene, primaryStage);

    primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
      switch (event.getCode()) {
        case W:
          group.translateZProperty().set(group.getTranslateZ() - 100);
          break;
        case S:
          group.translateZProperty().set(group.getTranslateZ() + 100);
          break;
        case Q:
          group.rotateByX(10);
          break;
        case E:
          group.rotateByX(-10);
          break;
      }
    });

    primaryStage.setTitle("Genuine Coder");
    primaryStage.setScene(scene);
    primaryStage.show();

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        pointLight.setRotate(pointLight.getRotate() + 1);
      }
    };
    timer.start();
  }

  private Node prepareSecondBox() {
    PhongMaterial material = new PhongMaterial();
    material.setDiffuseColor(Color.CORAL);
    Box box = new Box(20, 100, 100);
    box.setMaterial(material);
    return box;
  }

  private Box prepareBox(Edificio edificio) {
    PhongMaterial material = new PhongMaterial();
    material.setDiffuseColor(Color.GREEN);
    Box box = new Box(10000, 20, 10000);
    box.setMaterial(material);
    box.setTranslateY((edificio.getPisos().size()*100)-50);
    
    
    return box;
  }

  private void initMouseControl(SmartGroup group, Scene scene, Stage stage) {
    Rotate xRotate;
    Rotate yRotate;
    group.getTransforms().addAll(
        xRotate = new Rotate(0, Rotate.X_AXIS),
        yRotate = new Rotate(0, Rotate.Y_AXIS)
    );
    xRotate.angleProperty().bind(angleX);
    yRotate.angleProperty().bind(angleY);

    scene.setOnMousePressed(event -> {
      anchorX = event.getSceneX();
      anchorY = event.getSceneY();
      anchorAngleX = angleX.get();
      anchorAngleY = angleY.get();
    });

    scene.setOnMouseDragged(event -> {
      angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
      angleY.set(anchorAngleY + anchorX - event.getSceneX());
    });

    stage.addEventHandler(ScrollEvent.SCROLL, event -> {
      double delta = event.getDeltaY();
      group.translateZProperty().set(group.getTranslateZ() + delta);
    });
  }

  public static void main(String[] args) {
    launch(args);
  }
  
  public void iniciarSimulacion3D(String[] args){
      launch(args);
  }
  
  public void crearNodo(int rojo, int verde, int azul, double posicionX, double posicionY, double posicionZ){
      
      System.out.println("Agregué la habitación" + nodosEdificio.size());
      
      Sphere nodoHabitacion = new Sphere(20);
      nodoHabitacion.setTranslateX(posicionX*100);
      nodoHabitacion.setTranslateY(posicionY*100);
      nodoHabitacion.setTranslateZ(posicionZ*100);
      PhongMaterial material = new PhongMaterial();
      material.setDiffuseColor(Color.rgb(rojo, verde, azul));
      nodoHabitacion.setMaterial(material);
      this.nodosEdificio.add(nodoHabitacion);
  }
  
  
  
// Métodos para crear y posicionar nodos
public void crearEdificioGrafico(Edificio miEdificioGrafico) {
    int totalPisos = miEdificioGrafico.getPisos().size();
    for (int i = 0; i < totalPisos; i++) {
        crearPisoGrafico(miEdificioGrafico.getPisos().get(i), totalPisos - i - 1);
    }
}

public void crearPisoGrafico(Piso piso, int numeroDePisoInvertido) {
    int columnas = 4;
    int filas = 3;

    for (int i = 0; i < piso.getNodos().size(); i++) {
        int x = i % columnas; // Posición X dentro del plano
        int y = numeroDePisoInvertido; // Posición Y, cada piso se apila en la dirección Y de arriba hacia abajo
        int z = i / columnas; // Posición Z dentro del plano (filas)
        crearHabitacionGrafico(piso.getNodos().get(i).getColor(), x, y, z);
    }
}

public void crearHabitacionGrafico(java.awt.Color color, int posicionX, int posicionY, int posicionZ) {
    crearNodo(color.getRed(), color.getGreen(), color.getBlue(), (double) posicionX, (double) posicionY, (double) posicionZ);
}

  
  public int getCantidadNodos(){
      return this.nodosEdificio.size();
  }
  
  public void setEdficio(Edificio edificio){
      this.edificio = edificio;
  }
  
}
