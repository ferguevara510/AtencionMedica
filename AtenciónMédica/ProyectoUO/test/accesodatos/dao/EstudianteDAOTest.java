package accesodatos.dao;

import java.util.List;
import junit.framework.TestCase;
import logica.Estudiante;
import org.junit.Test;

/**
 * Clase de pruebas unitarias de la clase EstudianteDAO del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class EstudianteDAOTest extends TestCase{
   
  @Test
  public void testGuardarEstudiante() throws Exception {
    System.out.println("guardarEstudiante");
    Estudiante estudiante = new Estudiante();
    estudiante.setNombre("Fernanda");
    estudiante.setApellidoPaterno("Guevara");
    estudiante.setApellidoMaterno("Flores");
    estudiante.setMatricula("S15011604");
    estudiante.setProgramaeducativo("Ingenieria de software");
    boolean expResult = true;
    boolean result = new EstudianteDAO().guardarEstudiante(estudiante);
    assertEquals(expResult, result);
  }

  @Test
  public void testMostrarEstudiantes() throws Exception {
    System.out.println("mostrarEstudiantes");
    EstudianteDAO instance = new EstudianteDAO();
    List<Estudiante> result = instance.mostrarEstudiantes();
    assertEquals(true, !result.isEmpty());
  }
  
  @Test
  public void testNoMostarEstudiantes() throws Exception {
    System.out.println("mostrarEstudiantes");
    EstudianteDAO instance = new EstudianteDAO();
    List<Estudiante> result = instance.mostrarEstudiantes();
    assertEquals(false, result.isEmpty());
  }

}