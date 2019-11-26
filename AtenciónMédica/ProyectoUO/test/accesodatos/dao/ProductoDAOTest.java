/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.dao;

import java.util.List;
import logica.Producto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JENNY
 */
public class ProductoDAOTest {
  
  public ProductoDAOTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of registrarProducto method, of class ProductoDAO.
   */
  @Test
  public void testRegistrarProducto() throws Exception {
    System.out.println("registrarProducto");
    Producto producto = null;
    ProductoDAO instance = new ProductoDAO();
    instance.registrarProducto(producto);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of editarProducto method, of class ProductoDAO.
   */
  @Test
  public void testEditarProducto() throws Exception {
    System.out.println("editarProducto");
    Producto producto = null;
    ProductoDAO instance = new ProductoDAO();
    instance.editarProducto(producto);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of mostrarProductos method, of class ProductoDAO.
   */
  @Test
  public void testMostrarProductos() throws Exception {
    System.out.println("mostrarProductos");
    ProductoDAO instance = new ProductoDAO();
    List<Producto> expResult = null;
    List<Producto> result = instance.mostrarProductos();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
