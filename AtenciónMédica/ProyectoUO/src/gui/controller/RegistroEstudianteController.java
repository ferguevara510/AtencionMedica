package gui.controller;

import accesodatos.dao.EstudianteDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import logica.Estudiante;

/**
 * Clase que controla la pantalla RegistroEstudiante, donde se crea un nuevo registro de un 
 * Estudiante en el sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class RegistroEstudianteController implements Initializable {
  
  private ComboBox<String> programaEducativoCB;
  @FXML
  private Button aceptarBtn;
  @FXML
  private Button cancelarBtn;
  @FXML
  private TextField nombreTF;
  @FXML
  private TextField apellidoPaternoTF;
  @FXML
  private TextField apellidoMaternoTF;
  @FXML
  private TextField matriculaTF;
  
  
  
  @FXML
  void detallesEstudiante (ActionEvent event) throws IOException{
    PrincipalController principal = new PrincipalController();
    principal.detallesEstudiantes(event);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    programaEducativoCB.getItems().clear();
    programaEducativoCB.setItems(FXCollections.observableArrayList("Ingeniería de software",
            "Tecnologías Computacionales", "Redes y Servicios de Cómputo", "Estadística",
            "Informatica", "Ciencias y Tecnicas Estadísticas"));
  }
  
  @FXML
  void registroEstudiante (ActionEvent event) throws IOException {
    if (validarDatos() == true) {
      try {
        String nombre = nombreTF.getText();
        String apellidoPaterno = apellidoPaternoTF.getText();
        String apellidoMaterno = apellidoMaternoTF.getText();
        String matricula = matriculaTF.getText();
        String programaEducativo = programaEducativoCB.toString();
        Estudiante estudiante = new Estudiante(nombre, apellidoPaterno, apellidoMaterno, 
                matricula, programaEducativo);
        EstudianteDAO estudiantedao = new EstudianteDAO();
        try {
          estudiantedao.registrarEstudiante(estudiante);
        } catch (SQLException e) {
          AlertaController.mensajeAdvertencia("Error base de datos");
        }
        DetallesEstudiantesController detalles = new DetallesEstudiantesController();
        detalles.principal(event);
      } catch (RuntimeException e) {
        AlertaController.mensajeInformacion("Error de llenado");
      }
    } else {
      AlertaController.mensajeAdvertencia("Error de llenado en los campos");
    }
  }
  
  private boolean validarDatos() {
    if (nombreTF.getText().isEmpty()) {
      return false;
    }
    if (apellidoPaternoTF.getText().isEmpty()) {
      return false;
    }
    if (apellidoMaternoTF.getText().isEmpty()) {
      return false;
    }
    if (matriculaTF.getText().isEmpty()) {
      return false;
    }
    String programaEducativo = "" + programaEducativoCB.getValue();
    if (programaEducativo.equals("")) {
      return false;
    }
    return true;
  }

}
