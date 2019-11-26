package accesodatos.dao;

import java.util.List;
import logica.Estudiante;
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
public class EstudianteDAOTest {
  
  public EstudianteDAOTest() {
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
   * Test of registrarEstudiante method, of class EstudianteDAO.
   */
  @Test
  public void testRegistrarEstudiante() throws Exception {
    System.out.println("registrarEstudiante");
    Estudiante estudiante = null;
    EstudianteDAO instance = new EstudianteDAO();
    instance.guardarEstudiante(estudiante);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of obtenerEstudiantes method, of class EstudianteDAO.
   */
  @Test
  public void testMostarEstudiantes() throws Exception {
    System.out.println("obtenerEstudiantes");
    EstudianteDAO instance = new EstudianteDAO();
    List<Estudiante> expResult = null;
    List<Estudiante> result = instance.mostrarEstudiantes();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
