package gui.controller;

import accesodatos.ConnectionToBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
  void detallesProducto (ActionEvent event) throws IOException {
    PrincipalController principal = new PrincipalController();
    principal.detallesProductos(event);
  }
  
  void editarProducto (ActionEvent event) throws IOException {
    DetallesProductosController registro = new DetallesProductosController();
    registro.registrarProductos(event);
  }
  
  void buscarProducto (ActionEvent event) throws SQLException {
    try {
      Connection conexion = ConnectionToBD.conectar("root", "Karlita510", "atencionMedica", 
              "localhost");
      PreparedStatement ps =
            (PreparedStatement) conexion.prepareStatement("select * from software");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        String producto = rs.getString("nombre");
        String nombre = nombreTF.getText();
        if (producto.equals(nombre)){
          presentacionTF.setText(rs.getString("presentacion"));
          existenciasTF.setText(rs.getString("existencias"));
        } 
      }
    } catch (Exception e) {
          AlertaController.mensajeInformacion("No se encontró en la base de datos");
    }
  }
  
}