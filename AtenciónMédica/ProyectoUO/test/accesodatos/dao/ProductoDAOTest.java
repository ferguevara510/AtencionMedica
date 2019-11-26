package accesodatos.dao;

import java.util.List;
import junit.framework.TestCase;
import logica.Producto;
import org.junit.Test;

/**
 * Clase de pruebas unitarias de la clase ProductoDAO del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class ProductoDAOTest extends TestCase{

  @Test
  public void testRegistrarProducto() throws Exception {
    System.out.println("registrarProducto");
    Producto producto = new Producto();
    producto.setNombre("Paracetamol");
    producto.setPresentacion("Tabletas");
    producto.setExistencias(6);
    ProductoDAO instance = new ProductoDAO();
    instance.registrarProducto(producto);
  }

  @Test
  public void testEditarProducto() throws Exception {
    System.out.println("editarProducto");
    Producto producto = new Producto(4,"Suspención", "Tempra");
    producto.setExistencias(2);
    ProductoDAO instance = new ProductoDAO();
    instance.editarProducto(producto);
  }

  @Test
  public void testMostrarProductos() throws Exception {
    System.out.println("mostrarProductos");
    ProductoDAO instance = new ProductoDAO();
    List<Producto> result = instance.mostrarProductos();
    assertEquals(true, !result.isEmpty());
  }
  
  @Test
  public void testNoMostrarProductos() throws Exception {
    System.out.println("mostrarProductos");
    ProductoDAO instance = new ProductoDAO();
    List<Producto> result = instance.mostrarProductos();
    assertEquals(false, result.isEmpty());
  }
  
}
