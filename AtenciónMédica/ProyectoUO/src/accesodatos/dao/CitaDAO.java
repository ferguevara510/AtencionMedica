package accesodatos.dao;

import accesodatos.ConnectionToBD;
import gui.controller.PrincipalController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cita;

/**
 * Clase CitaDAO, está clse ayuda a tener contacto con la base de datos del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 24-11-2019
 */
public class CitaDAO {
  
  String usuario = "root";
  String contrasena = "Karlita510";
  String bd = "atencionMedica";
  String host = "localhost";
  
  /**
   * Método que ayuda a la interfaz gráfica ha agregar una Cita a la base de datos del sistema.
   * 
   * @param cita el objeto Cita que se va agregar a la base de datos del sistema 
   * @throws SQLException excepción de la base de datos SQL
   */
  public void registrarCita (Cita cita) throws SQLException {
    Connection conexion = null;
    PreparedStatement st = null;
    try {
      conexion = ConnectionToBD.conectar(usuario, contrasena, bd, host);
      st = conexion.prepareStatement("INSERT INTO CITA VALUES(?, ?, ?)");
      st.setString(1, cita.getFecha());
      st.setString(2, cita.getHora());
      st.setString(3, cita.getEstudiante().toString());
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