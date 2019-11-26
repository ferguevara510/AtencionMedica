package logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias de la clase Producto del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class ProductoTest {
  
  /**
   * Prueba del método getExistencias, de la clase Producto.
   */
  @Test
  public void testGetExistencias() {
    System.out.println("getExistencias");
    Producto instance = new Producto();
    int expResult = 0;
    int result = instance.getExistencias();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * Test of setExistencias method, of class Producto.
   */
  @Test
  public void testSetExistencias() {
    System.out.println("setExistencias");
    int existencias = 0;
    Producto instance = new Producto();
    instance.setExistencias(existencias);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getNombre method, of class Producto.
   */
  @Test
  public void testGetNombre() {
    System.out.println("getNombre");
    Producto instance = new Producto();
    String expResult = "";
    String result = instance.getNombre();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setNombre method, of class Producto.
   */
  @Test
  public void testSetNombre() {
    System.out.println("setNombre");
    String nombre = "";
    Producto instance = new Producto();
    instance.setNombre(nombre);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getPresentacion method, of class Producto.
   */
  @Test
  public void testGetPresentacion() {
    System.out.println("getPresentacion");
    Producto instance = new Producto();
    String expResult = "";
    String result = instance.getPresentacion();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setPresentacion method, of class Producto.
   */
  @Test
  public void testSetPresentacion() {
    System.out.println("setPresentacion");
    String presentacion = "";
    Producto instance = new Producto();
    instance.setPresentacion(presentacion);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toString method, of class Producto.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Producto instance = new Producto();
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}