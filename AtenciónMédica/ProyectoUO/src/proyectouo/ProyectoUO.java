package proyectouo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase que carga el sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 10-11-2019
 */
public class ProyectoUO extends Application {
  
  /**
   * Método que inicializa el programa.
   * 
   * @param args 
   */
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) {
    try {
      Parent scst = FXMLLoader.load(getClass().getResource("/gui/Principal.fxml"));
      Scene scene = new Scene(scst);
      Stage stage = new Stage ();
      stage.setTitle("Principal Atención Médica");
      stage.initStyle(StageStyle.UTILITY);
      stage.setScene(scene);
      stage.setResizable(false);
      stage.show();
    } catch (IOException e){
      e.getMessage();
    }
  }
  
}