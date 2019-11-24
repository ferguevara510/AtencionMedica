package gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Clase que controla la pantalla RegistroEstudiante, donde se crea un nuevo registro de un 
 * Estudiante en el sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class RegistroEstudianteController extends PrincipalController implements Initializable {
  
  
  @FXML
  private ComboBox<String> programaEducativo;
  @FXML
  private Button aceptarBtn;
  @FXML
  private Button cancelarBtn;
  @FXML
  private TextField nombre;
  @FXML
  private TextField apellidoPaterno;
  @FXML
  private TextField apellidoMaterno;
  @FXML
  private TextField matricula;
  
  @FXML
  void detallesEstudiante (ActionEvent event) throws IOException{
    PrincipalController principal = new PrincipalController();
    principal.detallesEstudiantes(event);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    programaEducativo.getItems().clear();
    programaEducativo.setItems(FXCollections.observableArrayList("Hola","Mundo"));
  }

}
