package gui.controller;

import accesodatos.dao.EstudianteDAO;
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
import logica.Estudiante;

/**
 * Clase que controla la pantalla DetallesEstudiantes, donde se muestra la información que 
 * está registrada en la Base de Datos.
 * 
 * @author Karla Fernanda Guevara Flores 
 * @version 1.0
 * @since 13-11-2019
 */
public class DetallesEstudiantesController implements Initializable{
  
  @FXML
  private ListView<Estudiante> listaEstudiantes;
  @FXML
  private Button cancelarBtn;
  @FXML
  private Button registrarBtn;
  @FXML
  private Button citasBtn;
  
  /**
   * Método que abre la pantalla Principal, donde se visualiza las dos opciones para administrar
   * en el sistema.
   * 
   * @param event evento que da inicio al método
   * @throws IOException excepción producida en operaciones interrumpidas
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
   * @param event evento que da inicio al método
   * @throws IOException excepción producida en operaciones interrumpidas
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
  
  /**
   * Carga los usuarios guardados en la Base de Datos en la lista.
   */
  private void mostrarEstudiantes(){
    EstudianteDAO estudianteDAO = new EstudianteDAO();
    List<Estudiante> estudiantes = new ArrayList<>();
    try {
      estudiantes = estudianteDAO.mostrarEstudiantes();
    } catch (SQLException ex) {
      Logger.getLogger(DetallesCitasController.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(!estudiantes.isEmpty()){
      listaEstudiantes.getItems().clear();
      listaEstudiantes.setItems(FXCollections.observableArrayList(estudiantes));
    }else{
      AlertaController.mensajeInformacion("No hay usuarios guardados");
    }
  }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.mostrarEstudiantes();
    }
    
}