package gui.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * Clase que controla la pantalla EditarCita, donde se edita los datos de una Cita en el sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class EditarCitaController {  
  
  @FXML
  private Button aceptarBtn;
  @FXML
  private Button cancelarBtn;
  @FXML
  private ComboBox<?> horas;
  @FXML
  private DatePicker fecha;
  @FXML
  private ComboBox<?> estudiantes;
  
  @FXML
  void detallesCita (ActionEvent event) throws IOException {
    DetallesEstudiantesController detalles = new DetallesEstudiantesController();
    detalles.detallesCitas(event);
  }
  
}
