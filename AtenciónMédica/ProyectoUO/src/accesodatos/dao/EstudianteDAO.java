package accesodatos.dao;

import accesodatos.ConnectionToBD;
import gui.controller.PrincipalController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Estudiante;

/**
 * Clase EstudianteDAO, está clse ayuda a tener contacto con la Base de Datos del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 24-11-2019
 */
public class EstudianteDAO {
  
  /**
   * Método que ayuda a la interfaz gráfica ha agregar un Estudiante a la base de datos del 
   * sistema.
   * 
   * @param estudiante el objeto Estduiante que se va agregar a la Base de Datos del sistema  
   * @throws SQLException excepción de la conexión con la Base de Datos de MySql
   * @return validacion genera un retorno de valores
   */
  public boolean guardarEstudiante(Estudiante estudiante) throws SQLException {
    PreparedStatement st = null;
    boolean validacion = false;
    try {
      Connection conexion = new ConnectionToBD().getConexion();
      st = conexion.prepareStatement("insert into estudiante values (?, ?, ?, ?, ?, ?)");
      st.setString(1, null);
      st.setString(2, estudiante.getNombre());
      st.setString(3, estudiante.getApellidoPaterno());
      st.setString(4, estudiante.getApellidoMaterno());
      st.setString(5, estudiante.getMatricula());
      st.setString(6, estudiante.getProgramaeducativo());
      st.executeUpdate();
      st.close();
      validacion = true;
    } catch (SQLException ex) {
        Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println("Error al ingresar a la base de datos");
    } finally {
      if (st != null) {
        try {
          st.close();
        } catch (SQLException e) {
          Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return validacion;
  }

  /**
   * Método que muestra la lista de los Estudiantes registrados en la Base de Datos.
   *
   * @return genera un retorno de valores lista Estudiantes
   * @throws SQLException excepción de la conexión con la Base de Datos de MySql
   */
  public List<Estudiante> mostrarEstudiantes() throws SQLException {
    List<Estudiante> estudiantes = new ArrayList<>();
    Estudiante estudiante;
    Connection conexion = null;
    try {
      conexion = new ConnectionToBD().getConexion();
      PreparedStatement sentenciaSQL = conexion.prepareStatement("select * from estudiante");
      ResultSet resultadoSQL = sentenciaSQL.executeQuery();
      while (resultadoSQL.next()) {
        estudiante = new Estudiante();
        estudiante.setNombre(resultadoSQL.getString("nombre"));
        estudiante.setApellidoPaterno(resultadoSQL.getString("apellidoPaterno"));
        estudiante.setApellidoMaterno(resultadoSQL.getString("apellidoMaterno"));
        estudiante.setMatricula(resultadoSQL.getString("matricula"));
        estudiante.setId(resultadoSQL.getInt("id_estudiante"));
        estudiante.setProgramaeducativo(resultadoSQL.getString(("programaEducativo")));
        estudiantes.add(estudiante);
      }
    } catch (SQLException ex) {
      Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
      throw new SQLException("Error en la base de datos", ex);
    } finally {
      try {
        if (conexion != null) {
          conexion.close();
        }
      } catch (SQLException ex) {
        Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        throw new SQLException("Error en la base de datos", ex);
      }
    }
    return estudiantes;
  }
  
  /**
   * Método que ayuda a buscar un Estudiante en la Base de Datos, según el id ingresado para su 
   * busqueda.
   *
   * @param id id del estudiante a buscar
   * @return genera un retorno de valores estudiante
   * @throws SQLException excepción de la conexión con la Base de Datos de MySql
   */
  public Estudiante buscarEstudiante (int id) throws SQLException{
    Connection conexion = null;
    Estudiante estudiante = null;
    try {
      conexion = new ConnectionToBD().getConexion();
      PreparedStatement sentenciaSQL = conexion.prepareStatement("select * from estudiante where id_estudiante = ?");
      sentenciaSQL.setInt(1, id);
      ResultSet resultadoSQL = sentenciaSQL.executeQuery();
      if(resultadoSQL.next()) {
        estudiante = new Estudiante();
        estudiante.setId(resultadoSQL.getInt("id_estudiante"));
        estudiante.setNombre(resultadoSQL.getString("nombre"));
        estudiante.setApellidoPaterno(resultadoSQL.getString("apellidoPaterno"));
        estudiante.setApellidoMaterno(resultadoSQL.getString("apellidoMaterno"));
        estudiante.setMatricula(resultadoSQL.getString("matricula"));
        estudiante.setProgramaeducativo(resultadoSQL.getString("programaEducativo"));
      }
      sentenciaSQL.close();
    }catch(SQLException ex){
      Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
      throw new SQLException("No se encontro el usuario con el id: "+ id, ex);
    }finally{
      if(conexion != null){
        conexion.close();
      }
    }
    return estudiante;
  } 
}