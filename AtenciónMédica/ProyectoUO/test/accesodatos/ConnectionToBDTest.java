/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.Connection;
import junit.framework.TestCase;

/**
 *
 * @author JENNY
 */
public class ConnectionToBDTest extends TestCase {
  
  public ConnectionToBDTest(String testName) {
    super(testName);
  }
  

  /**
   * Test of getConexion method, of class Conexion.
   * @throws java.lang.Exception
   */
  public void testConexion() throws Exception {
    System.out.println("getConexion");
    ConnectionToBD instance = new ConnectionToBD();
    boolean expResult = true;
    Connection result = null;
    result = instance.getConexion();
    assertEquals(expResult, !result.isClosed());
    // TODO review the generated test code and remove the default call to fail.
    
  }
  public void testCerrarConexion() throws Exception {
    System.out.println("cerrarConexion");
    ConnectionToBD instance = new ConnectionToBD();
    boolean expResult = true;
    boolean result = false;
    result = instance.cerrarConexion();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    
  }
  
}
