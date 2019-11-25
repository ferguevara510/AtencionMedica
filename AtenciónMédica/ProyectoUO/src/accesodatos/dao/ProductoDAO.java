package accesodatos.dao;

import accesodatos.ConnectionToBD;
import gui.controller.PrincipalController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Producto;

/**
 * Clase ProductoDAO, está clse ayuda a tener contacto con la base de datos del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 24-11-2019
 */
public class ProductoDAO {
  
  /**
   * Método que ayuda a la interfaz gráfica ha agregar un Producto a la base de datos del sistema.
   * 
   * @param producto el objeto Producto que se va agregar a la base de datos del sistema 
   * @throws SQLException excepción de la base de datos SQL
   */
  public void registrarProducto (Producto producto) throws SQLException {
    PreparedStatement st = null;
    try {
      Connection conexion = new ConnectionToBD().getConexion();
      st = conexion.prepareStatement("INSERT INTO PRODUCTO VALUES(?, ?, ?, ?)");
      st.setString(1, null);
      st.setString(2, producto.getNombre());
      st.setString(3, producto.getPresentacion());
      st.setInt(4, producto.getExistencias());
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
  
  /**
   * Método que ayuda a la interfaz gráfica ha editar un Producto que ya se había registrado 
   * previamente en la base de datos del sistema.
   * 
   * @param producto el objeto Producto que se va editar en la base de datos del sistema
   * @throws SQLException exceptión de la base de datos SQL
   */
  public void editarProducto (Producto producto) throws SQLException {
    PreparedStatement st = null;
    try {
      Connection conexion = new ConnectionToBD().getConexion();
      st = conexion.prepareStatement("UPDATE producto  set nombre =?, presentacion =?, "
              + "existencias =?");
      st.setString(1, producto.getNombre());
      st.setString(2, producto.getPresentacion());
      st.setInt(3, producto.getExistencias());
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