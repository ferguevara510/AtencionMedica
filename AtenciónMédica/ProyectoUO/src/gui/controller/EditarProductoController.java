package gui.controller;

import accesodatos.ConnectionToBD;
import accesodatos.dao.ProductoDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logica.Producto;

/**
 * Clase que controla la pantalla EditarProducto, donde se edita los datos de un Producto en el 
 * sistema.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class EditarProductoController {
  
  @FXML
  private Button aceptarBtn;
  @FXML
  private Button cancelarBtn;
  @FXML
  private TextField nombreTF;
  @FXML
  private TextField presentacionTF;
  @FXML
  private TextField existenciasTF;
  @FXML
  private TextField buscadorTF;
  @FXML
  private Button BuscarBtn;
  
  @FXML
  void detallesProducto (ActionEvent event) throws IOException {
    PrincipalController principal = new PrincipalController();
    principal.detallesProductos(event);
  }
  
  @FXML
  void editarProducto (ActionEvent event) throws IOException {
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
  
  @FXML
  void buscarProducto (ActionEvent event) throws SQLException {
    try {
      Connection conexion = new ConnectionToBD().getConexion();
      PreparedStatement ps =
            (PreparedStatement) conexion.prepareStatement("select * from software");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        String producto = rs.getString("nombre");
        String nombre = buscadorTF.getText();
        if (producto.equals(nombre)){
          presentacionTF.setText(rs.getString("presentacion"));
          existenciasTF.setText(rs.getString("existencias"));
        } 
      }
    } catch (Exception e) {
          AlertaController.mensajeInformacion("No se encontró en la base de datos");
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