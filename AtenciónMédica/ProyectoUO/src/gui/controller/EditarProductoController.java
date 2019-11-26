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
  private Producto producto;
  
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
        producto.setId(this.producto.getId());
        ProductoDAO productodao = new ProductoDAO();
        try {
          productodao.editarProducto(producto);
        } catch (SQLException e) {
          AlertaController.mensajeAdvertencia("Error base de datos");
        }
        PrincipalController principal = new PrincipalController();
        principal.detallesProductos(event);
      } catch (RuntimeException e) {
        AlertaController.mensajeInformacion("Error de llenado");
      }
    } else {
      AlertaController.mensajeAdvertencia("Error de llenado en los campos");
    }
  }
  
  @FXML
  void buscarProducto (ActionEvent event) throws SQLException {
    ProductoDAO productoDAO = new ProductoDAO();
    Producto producto = productoDAO.buscarProducto(buscadorTF.getText().trim());
    if(producto != null){
        nombreTF.setText(producto.getNombre());
        presentacionTF.setText(producto.getPresentacion());
        existenciasTF.setText(""+producto.getExistencias());
        this.producto = producto;
    }else{
        AlertaController.mensajeInformacion("No se encontro un producto con este nombre");
    }
  }
  
  private boolean validarDatos() {
    if (nombreTF.getText().trim().isEmpty()) {
      return false;
    }
    if (presentacionTF.getText().trim().isEmpty()) {
      return false;
    }
    if (existenciasTF.getText().trim().isEmpty()) {
      return false;
    }
    return true;
  }
  
}