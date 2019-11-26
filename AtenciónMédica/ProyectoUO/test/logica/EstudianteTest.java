package logica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias de la clase Estudiante del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class EstudianteTest {
  
  /**
   * Prueba del método getNombre, de la clase Estudiante.
   */
  @Test
  public void testGetNombre() {
    System.out.println("getNombre");
    Estudiante instance = new Estudiante();
    String expResult = "";
    String result = instance.getNombre();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método setNombre, de la clase Estudiante.
   */
  @Test
  public void testSetNombre() {
    System.out.println("setNombre");
    String nombre = "";
    Estudiante instance = new Estudiante();
    instance.setNombre(nombre);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método getApellidoPaterno, de la clase Estudiante.
   */
  @Test
  public void testGetApellidoPaterno() {
    System.out.println("getApellidoPaterno");
    Estudiante instance = new Estudiante();
    String expResult = "";
    String result = instance.getApellidoPaterno();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método setApellidoPaterno, de la clase Estudiante.
   */
  @Test
  public void testSetApellidoPaterno() {
    System.out.println("setApellidoPaterno");
    String apellidoPaterno = "";
    Estudiante instance = new Estudiante();
    instance.setApellidoPaterno(apellidoPaterno);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método getApellidoMaterno, de la clase Estudiante.
   */
  @Test
  public void testGetApellidoMaterno() {
    System.out.println("getApellidoMaterno");
    Estudiante instance = new Estudiante();
    String expResult = "";
    String result = instance.getApellidoMaterno();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método setApellidoMaterno, de la clase Estudiante.
   */
  @Test
  public void testSetApellidoMaterno() {
    System.out.println("setApellidoMaterno");
    String apellidoMaterno = "";
    Estudiante instance = new Estudiante();
    instance.setApellidoMaterno(apellidoMaterno);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método getMatricula, de la clase Estudiante.
   */
  @Test
  public void testGetMatricula() {
    System.out.println("getMatricula");
    Estudiante instance = new Estudiante();
    String expResult = "";
    String result = instance.getMatricula();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método setMatricula, de la clase Estudiante.
   */
  @Test
  public void testSetMatricula() {
    System.out.println("setMatricula");
    String matricula = "";
    Estudiante instance = new Estudiante();
    instance.setMatricula(matricula);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método getProgramaeducativo, de la clase Estudiante.
   */
  @Test
  public void testGetProgramaeducativo() {
    System.out.println("getProgramaeducativo");
    Estudiante instance = new Estudiante();
    String expResult = "";
    String result = instance.getProgramaeducativo();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método setProgramaeducativo, de la clase Estudiante.
   */
  @Test
  public void testSetProgramaeducativo() {
    System.out.println("setProgramaeducativo");
    String programaeducativo = "";
    Estudiante instance = new Estudiante();
    instance.setProgramaeducativo(programaeducativo);
    fail("The test case is a prototype.");
  }

  /**
   * Prueba del método toString, de la clase Estudiante.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Estudiante instance = new Estudiante();
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }
  
}