package gui.controller;

import accesodatos.dao.ProductoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logica.Producto;

/**
 * Clase que controla la pantalla RegistroProducto, donde se crea un nuevo registro de un
 * Producto en el sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class RegistroProductoController {

  @FXML
  private Button aceptarBtn;
  
  @FXML
  private Button cancelarBtn;
  @FXML
  private TextField nombreTF;
  @FXML
  private TextField existenciasTF;
  @FXML
  private TextField presentacionTF;

  @FXML
  void detallesProducto (ActionEvent event) throws IOException {
    PrincipalController principal = new PrincipalController();
    principal.detallesProductos(event);
  }
  
  @FXML
  void registroProducto (ActionEvent event) throws IOException {
    if (validarDatos() == true) {
      try {
        String nombre = nombreTF.getText();
        String presentacion = presentacionTF.getText();
        int existencias = Integer.parseInt(existenciasTF.getText());
        Producto producto = new Producto(existencias, nombre, presentacion);
        ProductoDAO productodao = new ProductoDAO();
        try {
          productodao.registrarProducto(producto);
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
    if (presentacionTF.getText().isEmpty()) {
      return false;
    }
    if (existenciasTF.getText().isEmpty()) {
      return false;
    }
    return true;
  }
}