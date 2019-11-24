package gui.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Clase que controla la pantalla RegistroCita, donde se crea un nuevo registro de una Cita en el 
 * sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class RegistroCitaController {

  @FXML
  private Button aceptarBtn;
  
  @FXML
  private Button cancelarBtn;
  
  @FXML
  void detallesCita (ActionEvent event) throws IOException {
    DetallesEstudiantesController detalles = new DetallesEstudiantesController();
    detalles.detallesCitas(event);
  }
  
}
