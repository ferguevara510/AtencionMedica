package accesodatos.dao;

import accesodatos.ConnectionToBD;
import gui.controller.PrincipalController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Estudiante;

/**
 * Clase EstudianteDAO, está clse ayuda a tener contacto con la base de datos del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 24-11-2019
 */
public class EstudianteDAO {
  
  /**
   * Método que ayuda a la interfaz gráfica ha agregar un Estudiante a la base de datos del sistema.
   * 
   * @param estudiante el objeto Estduiante que se va agregar a la base de datos del sistema 
   * @throws SQLException excepción de la base de datos SQL
   */
  public void registrarEstudiante (Estudiante estudiante) throws SQLException {
    PreparedStatement st = null;
    try {
      Connection conexion = new ConnectionToBD().getConexion();
      st = conexion.prepareStatement("insert into estudiante values (?, ?, ?, ?, ?)");
      st.setString(1, estudiante.getNombre());
      st.setString(2, estudiante.getApellidoPaterno());
      st.setString(3, estudiante.getApellidoMaterno());
      st.setString(4, estudiante.getMatricula());
      st.setString(5, estudiante.getProgramaeducativo());
      st.executeUpdate();
      st.close();
    } catch (SQLException ex) {
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
  }
  
}