package gui.controller;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase que controla la pantalla Principal, donde el usuario puede seleccionar que desea 
 * administrar dentro del sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 09-11-2019
 */
public class PrincipalController {

  @FXML
  private Button estudiantesBtn;
  @FXML
  private Button productosBtn;
  
  /**
   * Método que abre la pantalla DetallesEstudiantes, donde se visualiza los datos de los 
   * Estudiantres registrados en el sistema. 
   *
   * @param event
   * @throws IOException 
   */
  @FXML
  public void detallesEstudiantes(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/DetallesEstudiantes.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
  /**
   * Abre la pantalla DetallesProductos, donde se visualiza los datos de los Productos 
   * registrados en el sistema. 
   *
   * @param event
   * @throws IOException 
   */
  @FXML
  public void detallesProductos(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/DetallesProductos.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
}