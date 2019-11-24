/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hace la conexion del sistema con la BDD utilizando el driver de SQL, de tal 
 * manera que solo se logre instanciar el objeto para lograr la conexion y 
 * esta capa tener acceso a el manejo de datos.
 * 
 */
public class Conexion {

  private Connection conexion;

  public Conexion() throws SQLException {
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
   * @param datosBDD Arreglo de String con los datos necesarios para la conexion a la bdd, como lo
   * es la IP, el usuario y la contraseña.
   * @return instancia de la clase que hace la conexion a la BDD
   */
  public Connection getConexion() throws SQLException {
    return this.conexion;
  }

  /**
   * Cierra la conexion a la BDD.
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
