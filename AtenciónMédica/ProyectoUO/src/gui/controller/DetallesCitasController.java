package gui.controller;

import accesodatos.dao.CitaDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import logica.Cita;

/**
 * Clase que controla la pantalla DetallesCitas, donde se visualiza la información de las Citas.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class DetallesCitasController implements Initializable{
  
  @FXML
  private ListView<Cita> listaCitas;
  @FXML
  private Button cancelarBtn;
  @FXML
  private Button registrarBtn;
  @FXML
  private Button editarBtn;
  
  /**
   * Método que mandaa llamar el metodo detallesEstudiantes que manda a llamar a la pantalla 
   * Principal del sistema.
   * 
   * @param event evento que da inicio al método
   * @throws IOException excepción producida en operaciones interrumpidas
   */
  @FXML
  void detallesEstudiante (ActionEvent event) throws IOException{
    PrincipalController principal = new PrincipalController();
    principal.detallesEstudiantes(event);
  }
  
  @FXML
  void registrarCitas(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/RegistroCita.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
  @FXML
  void editarCitas(ActionEvent event) throws IOException {
    ((Node) (event.getSource())).getScene().getWindow().hide();
    Parent parent = FXMLLoader.load(getClass().getResource(("/gui/EditarCita.fxml")));
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
  }
  
  private void mostrarCitas(){
    CitaDAO citaDAO = new CitaDAO();
    List<Cita> citas = new ArrayList<>();
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
      AlertaController.mensajeInformacion("No hay citas registrdas");
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.mostrarCitas();
  }
  
}