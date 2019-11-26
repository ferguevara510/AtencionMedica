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
import javafx.scene.input.KeyEvent;
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
  
  @FXML
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
    programaEducativoCB.setItems(FXCollections.observableArrayList("Ingenieria de software",
            "Tecnologias Computacionales", "Redes y Servicios de Computo", "Estadistica",
            "Informatica", "Ciencias y Tecnicas Estadisticas"));
  }
  
  @FXML
  void registroEstudiante (ActionEvent event) throws IOException {
    if (validarDatos() == true) {
      try {
        String nombre = nombreTF.getText();
        String apellidoPaterno = apellidoPaternoTF.getText();
        String apellidoMaterno = apellidoMaternoTF.getText();
        String matricula = matriculaTF.getText();
        String programaEducativo = (String) programaEducativoCB.getValue();
        Estudiante estudiante = new Estudiante(nombre, apellidoPaterno, apellidoMaterno, 
                matricula, programaEducativo);
        EstudianteDAO estudiantedao = new EstudianteDAO();
        try {
          estudiantedao.guardarEstudiante(estudiante);
        } catch (SQLException e) {
          AlertaController.mensajeAdvertencia("Error base de datos");
        }
        PrincipalController detalles = new PrincipalController();
        detalles.detallesEstudiantes(event);
      } catch (RuntimeException e) {
        AlertaController.mensajeInformacion("Error de llenado");
      }
    } else {
      AlertaController.mensajeAdvertencia("Error de llenado en los campos");
    }
  }
  
  private boolean validarDatos() {
    if (nombreTF.getText().trim().isEmpty()) {
      return false;
    }
    if (apellidoPaternoTF.getText().trim().isEmpty()) {
      return false;
    }
    if (apellidoMaternoTF.getText().trim().isEmpty()) {
      return false;
    }
    if (matriculaTF.getText().trim().isEmpty()) {
      return false;
    }
    String programaEducativo = programaEducativoCB.getValue();
    if (programaEducativo == null) {
      return false;
    }
    return true;
  }
  
  @FXML
  void restringirCampoNombre(KeyEvent evento) {
    restringirCaracteres(evento, nombreTF.getText());
  }
  
  @FXML
  void restringirCampoApellidoPaterno(KeyEvent evento) {
    restringirCaracteres(evento, apellidoPaternoTF.getText());
  }
  
  @FXML
  void restringirCampoApellidoMaterno(KeyEvent evento) {
    restringirCaracteres(evento, apellidoMaternoTF.getText());
  }
  
  @FXML
  void restringirCampoMatricula(KeyEvent evento) {
    restringirCaracteresMatricula(evento, matriculaTF.getText());
  }
  
  private void restringirCaracteres(KeyEvent evento, String cadena) {
    if (cadena.length() > 99) {
    evento.consume();
    }
  }
  
  private void restringirCaracteresMatricula(KeyEvent evento, String cadena) {
    if (cadena.length() > 9) {
    evento.consume();
    }
  }
  
  @FXML
  private void restringirLetras(KeyEvent evento) {
    char caracter = evento.getCharacter().charAt(0);
    if (nombreTF.getText().length() > 6 || !Character.isDigit(caracter)) {
      evento.consume();
    }
  }
  
  @FXML
  private void restringirLetrasApellidoPaterno(KeyEvent evento) {
    char caracter = evento.getCharacter().charAt(0);
    if (apellidoPaternoTF.getText().length() > 6 || !Character.isDigit(caracter)) {
      evento.consume();
    }
  }
  
  @FXML
  private void restringirLetrasApellidoMaterno(KeyEvent evento) {
    char caracter = evento.getCharacter().charAt(0);
    if (apellidoMaternoTF.getText().length() > 6 || !Character.isDigit(caracter)) {
      evento.consume();
    }
  }
}
