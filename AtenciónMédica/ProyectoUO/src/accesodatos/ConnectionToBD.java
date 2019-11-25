package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para crear la conexión con la base de datos del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 20-11-2019
 */
public class ConnectionToBD {
  
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://";
  private Connection conexion;

  /**
   * Inicia la conexion.
   * 
   * @param usuario el nombre del usuario que quiere acceder al sistema
   * @param pass contraseña del usuario.
   * @param bd nombre de la base de datos
   * @param host el host al que se quiere accesar
   * @return genera un retorno de valores
   * @throws SQLException conexión con la base de datos de MySql
   */
  public static Connection conectar(String usuario, String pass, String bd, String host) 
          throws SQLException {
    Connection res = null;
        try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
      System.out.println("Error en driver: " + ex.getMessage());
    }
    try {
      res = DriverManager.getConnection("jdbc:mysql://" + host + "/" + bd+ "?" + "user=" + usuario 
              + "&password=" + pass);
    } catch (SQLException sqlEx) {
      throw new SQLException("Error al conectase a la base de datos");
    }
    return res;
  }
  
  /**
   * Metodo que abre la conexión con la base de datos de MySql.
   * 
   * @throws SQLException conexión con la base de datosde MySql
   */
  public ConnectionToBD() throws SQLException {
    String iP = "localhost";
    String usuario = "root";
    String contraseña = "Karlita510";
    String baseDeDatos = "atencionMedica";

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
   * Genera la conexion a la BDD.
   * 
   * @return genera un retorno de valores
   * @throws java.sql.SQLException conexión con la base de datos de MySql
   */
  public Connection getConexion() throws SQLException {
    return this.conexion;
  }

  /**
   * Cierra la conexion a la BDD.
   * 
   * @return genera un retorno de valores
   * @throws java.sql.SQLException conexión con la base de datos de MySql
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