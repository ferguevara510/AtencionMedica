package accesodatos.dao;

import accesodatos.ConnectionToBD;
import gui.controller.PrincipalController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cita;
import logica.Estudiante;

/**
 * Clase CitaDAO, está clase ayuda a tener contacto con la Base de Datos del sistema.
 *
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 24-11-2019
 */
public class CitaDAO {

  private ResultSet resultadoSQL;
  private PreparedStatement sentenciaSQL;

  /**
   * Método que ayuda a la interfaz gráfica ha agregar una Cita a la Base de Datos del sistema.
   *
   * @param cita el objeto Cita que se va agregar a la Base de Datos del sistema
   * @return validacion genera un retorno de valores
   * @throws SQLException excepción de la conexión con la Base de Datos de MySql
   */
  public boolean registrarCita(Cita cita) throws SQLException {
    PreparedStatement st = null;
    Connection conexion = null;
    boolean validacion = false;
    try {
      conexion = new ConnectionToBD().getConexion();
      st = conexion.prepareStatement("INSERT INTO CITA VALUES(?, ?, ?, ?)");
      st.setString(1, null);
      st.setString(2, cita.getFecha());
      st.setString(3, cita.getHora());
      st.setInt(4, cita.getEstudiante().getId());
      st.executeUpdate();
      st.close();
      validacion = true;
    } catch (SQLException ex) {
      System.out.println("Error al ingresar a la base de datos");
    } finally {
      if (conexion != null) {
        try {
          conexion.close();
        } catch (SQLException e) {
          Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, e);
        }
      }
    }
    return validacion;
  }

  /**
   * 
   * Método que verifica si la hora y fecha de la cita esta disponible.
   *
   * @param fecha fecha de la cita
   * @param hora hora de la cita
   * @return true si la fecha y la hora están disponibles y false sino genera un retorno de 
   * valores
   * @throws java.sql.SQLException excepción de la conexión con la Base de Datos de MySql
   */
  public boolean validalidarDisponibilidadDeCita(String fecha, String hora) throws SQLException {
    boolean validacion = true;
    Connection conexion = null;
    try {
      conexion = new ConnectionToBD().getConexion();
      PreparedStatement sentenciaSQL = conexion.prepareStatement("select * from cita where "
              + "fecha = ? and hora = ?");
      sentenciaSQL.setString(1, fecha);
      sentenciaSQL.setString(2, hora);
      ResultSet resultadoSQL = sentenciaSQL.executeQuery();
      if (resultadoSQL.next()) {
        validacion = false;
      }
      resultadoSQL.close();
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
        throw new SQLException("Error en labase de datos", ex);
      }
    }
    return validacion;
  }

  /**
   * Método que muestra las Citas que están registradas en la Base de Datos en la pantalla 
   * DetallesCitas.
   * 
   * @return genera un retorno de valores lista Citas
   * @throws SQLException excepción de la conexión con la Base de Datos de MySql
   * @throws IOException excepción de operaciones interrumpidas
   */
  public List<Cita> mostrarCitas() throws SQLException, IOException {
    List<Cita> listaCitas = new ArrayList<>();
    Cita cita;
    Connection conexion = null;
    try {
      conexion = new ConnectionToBD().getConexion();
      sentenciaSQL = conexion.prepareStatement("select * from cita");
      resultadoSQL = sentenciaSQL.executeQuery();
      while (resultadoSQL.next()) {
        cita = new Cita();
        cita.setFecha(resultadoSQL.getString("fecha"));
        cita.setHora(resultadoSQL.getString("hora"));
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        Estudiante estudiante = estudianteDAO.buscarEstudiante(resultadoSQL.getInt("estudiante"));
        cita.setEstudiante(estudiante);
        listaCitas.add(cita);
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
        throw new SQLException("Error en labase de datos", ex);
      }
    }
    return listaCitas;
  }

}