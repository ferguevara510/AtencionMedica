package gui.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

/**
 * Clase que controla la pantalla de las alertas.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class AlertaController {

  /**
   * Método para enviar un mensaje de advertiancia.
   *
   * @param mensaje mensaje de advertencia
   */
  public static void mensajeAdvertencia(String mensaje) {
    Alert ventana = new Alert(Alert.AlertType.WARNING);
    ventana.setTitle("Alerta");
    ventana.setHeaderText(null);
    ventana.setContentText(mensaje);
    ButtonType boton = new ButtonType("Aceptar", ButtonData.OK_DONE);
    ventana.getButtonTypes().setAll(boton);
    ventana.showAndWait();
  }

  /**
   * Método para enviar un mensaje de información.
   *
   * @param mensaje mensaje de información
   */
  public static void mensajeInformacion(String mensaje) {
    Alert ventana = new Alert(Alert.AlertType.INFORMATION);
    ventana.setTitle("Alerta");
    ventana.setHeaderText(null);
    ventana.setContentText(mensaje);
    ButtonType boton = new ButtonType("Aceptar", ButtonData.OK_DONE);
    ventana.getButtonTypes().setAll(boton);
    ventana.showAndWait();
  }

}