package gui.controller;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class AlertaController {

  public static void mensajeAdvertencia(String mensaje) {
    Alert ventana = new Alert(Alert.AlertType.WARNING);
    ventana.setTitle(null);
    ventana.setHeaderText(null);
    ventana.setContentText(mensaje);
    ButtonType boton = new ButtonType("Aceptar", ButtonData.OK_DONE);
    ventana.getButtonTypes().setAll(boton);
    ventana.showAndWait();
  }

  public static void mensajeInformacion(String mensaje) {
    Alert ventana = new Alert(Alert.AlertType.INFORMATION);
    ventana.setTitle(null);
    ventana.setHeaderText(null);
    ventana.setContentText(mensaje);
    ButtonType boton = new ButtonType("Aceptar", ButtonData.OK_DONE);
    ventana.getButtonTypes().setAll(boton);
    ventana.showAndWait();
  }

}