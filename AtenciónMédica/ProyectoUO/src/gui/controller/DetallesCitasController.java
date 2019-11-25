package gui.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase que controla la pantalla DetallesCitas, donde se visualiza la información de las Citas.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class DetallesCitasController {
  
  @FXML
  private ListView<?> listaCitas;
  @FXML
  private Button cancelarBtn;
  @FXML
  private Button registrarBtn;
  @FXML
  private Button editarBtn;
  
  /**
   * 
   * @param event
   * @throws IOException 
   */
  @FXML
  void detallesEstudiante (ActionEvent event) throws IOException{
    PrincipalController principal = new PrincipalController();
    principal.detallesEstudiantes(event);
  }
  
  @FXML
  void registrarCitas(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/RegistroCita.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
  @FXML
  void editarCitas(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/EditarCita.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
}