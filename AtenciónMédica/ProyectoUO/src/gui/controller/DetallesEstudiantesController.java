package gui.controller;

import accesodatos.ConnectionToBD;
import accesodatos.dao.EstudianteDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logica.Estudiante;

/**
 * Clase que controla la pantalla DetallesEstudiantes
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class DetallesEstudiantesController {
  
  @FXML
  private ListView<String> listaEstudiantes;
  @FXML
  private Button cancelarBtn;
  @FXML
  private Button registrarBtn;
  @FXML
  private Button citasBtn;
  
  /**
   * Método que abre la pantalla Principal, donde se visualiza las dos opciones para administrar en
   * el sistema.
   * 
   * @param event
   * @throws IOException 
   */
  @FXML  
  public void principal(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/Principal.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.setTitle("Principal");
    stage.initStyle(StageStyle.UTILITY);
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
  }
  
  @FXML
  void registrarEstudiantes(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/RegistroEstudiante.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
  /**
   * Método que abre la pantalla DetallesCitas, donde se visualiza los datos de las Citas de los
   * Estudiantres registrados en el sistema.
   * 
   * @param event
   * @throws IOException 
   */
  @FXML
  public void detallesCitas(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/DetallesCitas.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
  private void mostrarEstudiantes(){
    EstudianteDAO estudiantedao= new EstudianteDAO();
    List<Estudiante> citas = new ArrayList<>();
    try {
      citas = citaDAO.mostrarCitas();
    } catch (SQLException ex) {
      Logger.getLogger(DetallesCitasController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(DetallesCitasController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    if(!citas.isEmpty()){
      listaCitas.getItems().clear();
      listaCitas.setItems(FXCollections.observableArrayList(citas));
    }else{
      //mensaje de que no hay citas
    }
  }
  
  
}