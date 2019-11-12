/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectouo;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase controlador de pantalla Principal
 * 
 * @author KARLA FERNANDA GUEVARA FLORES
 * @version 1.0
 * @since 09-11-2019
 */
public class PrincipalController {

  @FXML
  private Button estudiantes;
  
  @FXML
  private Button productos;
  
  /**
   * 
   */
  @FXML
  void detallesEstudiantes(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/fxml/DetallesEstudiantes.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.setScene(scene);
    stage.show();
  }
  
  @FXML
  void detallesProductos(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/fxml/DetallesProductos.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.setScene(scene);
    stage.show();
  }
}