package logica;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Clase de pruebas unitarias de la clase Producto del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class ProductoTest extends TestCase{
  
  @Test
  public void testGetExistencias() {
    System.out.println("getExistencias");
    Producto instance = new Producto();
    instance.getExistencias();
  }

  @Test
  public void testSetExistencias() {
    System.out.println("setExistencias");
    int existencias = 6;
    Producto instance = new Producto();
    instance.setExistencias(existencias);
  }

  @Test
  public void testGetNombre() {
    System.out.println("getNombre");
    Producto instance = new Producto();
    instance.getNombre();
  }

  @Test
  public void testSetNombre() {
    System.out.println("setNombre");
    String nombre = "Tempra";
    Producto instance = new Producto();
    instance.setNombre(nombre);
    }

  @Test
  public void testGetPresentacion() {
    System.out.println("getPresentacion");
    Producto instance = new Producto();
    instance.getPresentacion();
  }

  @Test
  public void testSetPresentacion() {
    System.out.println("setPresentacion");
    String presentacion = "Tabletas";
    Producto instance = new Producto();
    instance.setPresentacion(presentacion);
  }
  
}