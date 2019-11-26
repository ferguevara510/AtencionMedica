package gui.controller;

import accesodatos.dao.ProductoDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.Producto;

/**
 * Clase que controla la pantalla DetallesProductos
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class DetallesProductosController implements Initializable{
  
  @FXML
  private ListView<Producto> listaProductos;
  @FXML
  private Button cancelarBtn;
  @FXML
  private Button registrarBtn;
  @FXML
  private Button editarBtn;
  
  @FXML
  void principal(ActionEvent event) throws IOException {
    DetallesEstudiantesController detalles = new DetallesEstudiantesController();
    detalles.principal(event);
  }
  
  @FXML
  void registrarProductos(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/RegistroProducto.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
  @FXML
  void editarProductos(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/EditarProducto.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
  public void mostrarProductos() throws SQLException, IOException {
    ProductoDAO productodao = new ProductoDAO();
    List<Producto> productos = null;
    try {
      productos = productodao.mostrarProductos();
    } catch (SQLException ex) {
      AlertaController.mensajeAdvertencia("Ocurrio un error en la base de datos");
    }
    
    if(productos != null){
      listaProductos.getItems().clear(); 
      listaProductos.setItems(FXCollections.observableArrayList(productos));
    }
        
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      this.mostrarProductos();
    } catch (SQLException ex) {
      Logger.getLogger(DetallesProductosController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(DetallesProductosController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}