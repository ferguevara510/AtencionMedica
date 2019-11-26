package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para crear la conexión con la Base de Datos del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 20-11-2019
 */
public class ConnectionToBD {

  private Connection conexion;
   
  /** 
   * Metodo que crea la conexión con la base de datos "atencionmedica" de MySql.
   * 
   * @throws SQLException excepción de la conexión con la Base de Datos de MySql
   */
  public ConnectionToBD() throws SQLException {
    String iP = "localhost";
    String usuario = "usuarioBD";
    String contraseña = "m3d1c@m3nt0s";
    String baseDeDatos = "atencionmedica";
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
      System.out.println("Error en driver: " + ex.getMessage());
    }
    try {
      conexion = DriverManager.getConnection("jdbc:mysql://" + iP + "/" + baseDeDatos + "?"
              + "user=" + usuario + "&password=" + contraseña);
    } catch (SQLException sqlEx) {
      throw new SQLException("Error al conectase a la base de datos");
    }
  }
  
  /**
   * Genera la conexion a la Base de Datos.
   * 
   * @return conexion genera un retorno de valores
   * @throws java.sql.SQLException excepción de la conexión con la Base de Datos de MySql
   */
  public Connection getConexion() throws SQLException {
    return this.conexion;
  }

  /**
   * Cierra la conexion a la Base de Datos.
   * 
   * @return cierre de la conexión de la Base de Datos genera un retorno de valores
   * @throws java.sql.SQLException excepción de la conexión con la Base de Datos de MySql
   */
  public boolean cerrarConexion() throws SQLException {
    try {
      if(this.conexion != null && !this.conexion.isClosed()){
        this.conexion.close();
      }
    } catch (SQLException sqlEx) {
      throw new SQLException("Error al cerrar la conexion a la base de datos");
    }
    return this.conexion == null || this.conexion.isClosed();
  }
   
}