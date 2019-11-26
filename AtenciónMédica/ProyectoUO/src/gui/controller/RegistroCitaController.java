package gui.controller;

import accesodatos.dao.CitaDAO;
import accesodatos.dao.EstudianteDAO;
import javafx.scene.control.DatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import logica.Cita;
import logica.Estudiante;

/**
 * Clase que controla la pantalla RegistroCita, donde se crea un nuevo registro de una Cita en el 
 * sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class RegistroCitaController implements Initializable{
  @FXML
  private Button aceptarBtn;
  @FXML
  private Button cancelarBtn;
  @FXML
  private ComboBox<String> horasCB;
  @FXML
  private DatePicker fechaDP;
  @FXML
  private ComboBox<Estudiante> estudiantesCB;
 
  @FXML
  void detallesCita (ActionEvent event) throws IOException {
    DetallesEstudiantesController detalles = new DetallesEstudiantesController();
    detalles.detallesCitas(event);
  }
  
  @Override
  public void initialize(URL location,ResourceBundle resources){
    horasCB.getItems().clear();
    horasCB.setItems(FXCollections.observableArrayList(" 7:00 horas ", " 7:30 horas ", 
            " 8:00 horas ", " 8:30 horas ", " 9:00 horas ", " 9:30 horas ", " 10:00 horas ", 
            " 10:30 horas ", " 11:00 horas ", " 11:30 horas ", " 12:00 horas ", " 12:30 horas ", 
            " 13:00 horas ", " 13:00 horas ", " 13:30 horas ", " 14:00 horas ", " 14:30 horas ", 
            " 15:00 horas ", " 15:30 horas ", " 16:00 horas ", " 16:30 horas ", " 17:00 horas ", 
            " 17:30 horas ", " 18:00 horas", " 18:30 horas ", " 19:00 horas ", " 19:30 horas "));
    this.llenarComboBox();
  }
  
  @FXML
  void registroCita (ActionEvent event) throws IOException {
    if (validarDatos() == true) {
      try {
        String hora = horasCB.getValue();
        String fecha = fechaDP.getValue().format(DateTimeFormatter.ISO_DATE);
        Estudiante estudiante = estudiantesCB.getValue();
        Cita cita = new Cita(fecha,hora, estudiante);
        CitaDAO citadao = new CitaDAO();
        try {
          citadao.registrarCita(cita);
        } catch (SQLException e) {
          AlertaController.mensajeAdvertencia("Error base de datos");
        }
        DetallesCitasController detalles = new DetallesCitasController();
        detalles.detallesEstudiante(event);
      } catch (RuntimeException e) {
        AlertaController.mensajeInformacion("Error de llenado");
      }
    } else {
      AlertaController.mensajeAdvertencia("Error de llenado en los campos");
    }
  }
  
  private boolean validarDatos() {
    String hora = "" + horasCB.getValue();
    if (hora.equals("")) {
      return false;
    }
    String date = "" + fechaDP.getValue();
    if (date.equals("")) {
      return false;
    }
    String estudiantes = "" + estudiantesCB.getValue();
    if (estudiantes.equals("")) {
      return false;
    }
    return true;
  }
  
  private void llenarComboBox(){
    EstudianteDAO estudianteDAO = new EstudianteDAO();
    List<Estudiante> estudiantes = new ArrayList<>();
    try {
      estudiantes = estudianteDAO.obtenerEstudiantes();
    } catch (SQLException ex) {
      AlertaController.mensajeAdvertencia("Error con la base de datos");
      Logger.getLogger(RegistroCitaController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    if(!estudiantes.isEmpty()){
      estudiantesCB.getItems().clear();
      estudiantesCB.setItems(FXCollections.observableArrayList(estudiantes));
    }else{
      AlertaController.mensajeAdvertencia("No se encontraron registro");
    }
  }
  
}
