package GUI.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author JENNY
 */
public class AtenciónMédica extends Application {
  
  public static void main(String[] args){
    launch(args);
  }
  
  /**
   * Método de carga de la pantalla principal del programa
   */
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Principal.fxml"));      
    Scene scene = new Scene(root);       
    stage.setScene(scene);
    stage.show();
  }
  
}
