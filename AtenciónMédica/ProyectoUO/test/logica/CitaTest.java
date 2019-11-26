package logica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias de la clase Cita del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class CitaTest {
  
  /**
   * Prueba del método getFecha, de la clase Cita.
   */
  @Test
  public void testGetFecha() {
    System.out.println("getFecha");
    Cita instance = new Cita();
    String expResult = "";
    String result = instance.getFecha();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método setFecha, de la clase Cita.
   */
  @Test
  public void testSetFecha() {
    System.out.println("setFecha");
    String fecha = "";
    Cita instance = new Cita();
    instance.setFecha(fecha);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método getHora, de la clase Cita.
   */
  @Test
  public void testGetHora() {
    System.out.println("getHora");
    Cita instance = new Cita();
    String expResult = "";
    String result = instance.getHora();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * TPrueba del método setHora, de la clase Cita.
   */
  @Test
  public void testSetHora() {
    System.out.println("setHora");
    String hora = "";
    Cita instance = new Cita();
    instance.setHora(hora);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método getEstudiante, de la clase Cita.
   */
  @Test
  public void testGetEstudiante() {
    System.out.println("getEstudiante");
    Cita instance = new Cita();
    Estudiante expResult = null;
    Estudiante result = instance.getEstudiante();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método setEstudiante, de la clase Cita.
   */
  @Test
  public void testSetEstudiante() {
    System.out.println("setEstudiante");
    Estudiante estudiante = null;
    Cita instance = new Cita();
    instance.setEstudiante(estudiante);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método toString, de la clase Cita.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Cita instance = new Cita();
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }
  
}