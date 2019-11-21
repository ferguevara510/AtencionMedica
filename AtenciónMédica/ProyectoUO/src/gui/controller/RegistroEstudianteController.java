package gui.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Clase que controla la pantalla RegistroEstudiante, donde se crea un nuevo registro de un 
 * Estudiante en el sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class RegistroEstudianteController extends PrincipalController {
  
  @FXML
  private Button aceptar;
  
  @FXML
  private Button cancelar;
  
  @FXML
  void detallesEstudiante (ActionEvent event) throws IOException{
    PrincipalController principal = new PrincipalController();
    principal.detallesEstudiantes(event);
  }

}
