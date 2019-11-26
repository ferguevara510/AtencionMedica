package accesodatos.dao;

import accesodatos.ConnectionToBD;
import gui.controller.PrincipalController;
import logica.Producto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase ProductoDAO, está clse ayuda a tener contacto con la base de datos del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 24-11-2019
 */
public class ProductoDAO {
  
  private ResultSet resultadoSQL;
  private PreparedStatement sentenciaSQL;
    
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
      st = conexion.prepareStatement("INSERT INTO productos VALUES(?, ?, ?, ?)");
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
      st = conexion.prepareStatement("UPDATE productos  set nombre =?, presentacion =?, "
              + "existencias =?");
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
  
  public List<Producto> mostrarProductos() throws SQLException, IOException {
    List<Producto> listaProductos = new ArrayList<>();
    Producto producto;
    Connection conexion = null;
    try {
      conexion = new ConnectionToBD().getConexion();
      sentenciaSQL = conexion.prepareStatement("select * from productos");
      resultadoSQL = sentenciaSQL.executeQuery();
      while (resultadoSQL.next()) {
        producto = new Producto();
        producto.setNombre(resultadoSQL.getString("nombre"));
        producto.setPresentacion(resultadoSQL.getString("presentacion"));
        producto.setExistencias(resultadoSQL.getInt("existencias"));
        listaProductos.add(producto);
      }               
    } catch (SQLException ex){
      Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
      throw new SQLException("Error en la base de datos", ex);
    }finally{
          try {
            if(conexion != null){
              conexion.close();
            }
          } catch (SQLException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Error en labase de datos", ex);
          }
        }
    return listaProductos;
  }
  
}