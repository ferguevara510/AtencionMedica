package logica;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Clase de pruebas unitarias de la clase Estudiante del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class EstudianteTest extends TestCase{

  @Test
  public void testGetNombre() {
    System.out.println("getNombre");
    Estudiante instance = new Estudiante();
    instance.getNombre();
  }

  @Test
  public void testGetApellidoPaterno() {
    System.out.println("getApellidoPaterno");
    Estudiante instance = new Estudiante();
    instance.getApellidoPaterno();
  }

  @Test
  public void testSetApellidoMaterno() {
    System.out.println("setApellidoMaterno");
    String apellidoMaterno = "Flores";
    Estudiante instance = new Estudiante();
    instance.setApellidoMaterno(apellidoMaterno);
  }

  @Test
  public void testGetMatricula() {
    System.out.println("getMatricula");
    Estudiante instance = new Estudiante();
    instance.getMatricula();
  }

  @Test
  public void testSetProgramaeducativo() {
    System.out.println("setProgramaeducativo");
    String programaeducativo = "Ingenieria de Software";
    Estudiante instance = new Estudiante();
    instance.setProgramaeducativo(programaeducativo);
  }

  @Test
  public void testGetId() {
    System.out.println("getId");
    Estudiante instance = new Estudiante();
    instance.getId();
  }

  @Test
  public void testSetId() {
    System.out.println("setId");
    int id = 5;
    Estudiante instance = new Estudiante();
    instance.setId(id);
  }

  @Test
  public void testSetNombre() {
    System.out.println("setNombre");
    String nombre = "Fer";
    Estudiante instance = new Estudiante();
    instance.setNombre(nombre);
  }

  @Test
  public void testSetApellidoPaterno() {
    System.out.println("setApellidoPaterno");
    String apellidoPaterno = "Guev";
    Estudiante instance = new Estudiante();
    instance.setApellidoPaterno(apellidoPaterno);
  }

  @Test
  public void testGetApellidoMaterno() {
    System.out.println("getApellidoMaterno");
    Estudiante instance = new Estudiante();
    instance.getApellidoMaterno();
  }

  @Test
  public void testSetMatricula() {
    System.out.println("setMatricula");
    String matricula = "S15011604";
    Estudiante instance = new Estudiante();
    instance.setMatricula(matricula);
  }

  @Test
  public void testGetProgramaeducativo() {
    System.out.println("getProgramaeducativo");
    Estudiante instance = new Estudiante();
    instance.getProgramaeducativo();
  }

}