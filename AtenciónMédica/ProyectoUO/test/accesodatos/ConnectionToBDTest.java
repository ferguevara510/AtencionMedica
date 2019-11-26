package accesodatos;

import java.sql.Connection;
import junit.framework.TestCase;

/**
 * Clase de pruebas unitarias de la clase ConnectionToBD del sistema, donde se crea la conexion 
 * con la base de datos.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class ConnectionToBDTest extends TestCase {
  
  public ConnectionToBDTest(String testName) {
    super(testName);
  }

  /**
   * Método de prueba de la conexión con la Base de Datos.
   */
  public void testConexion() throws Exception {
    System.out.println("getConexion");
    ConnectionToBD instance = new ConnectionToBD();
    boolean expResult = true;
    Connection result = null;
    result = instance.getConexion();
    assertEquals(expResult, !result.isClosed());   
  }

  /**
   * Método de prueba de cerra la conexión con la Base de Datos.
   */
  public void testCerrarConexion() throws Exception {
    System.out.println("cerrarConexion");
    ConnectionToBD instance = new ConnectionToBD();
    boolean expResult = true;
    boolean result = false;
    result = instance.cerrarConexion();
    assertEquals(expResult, result);   
  }
  
}