package logica;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias de la clase Cita del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class CitaTest extends TestCase{

  @Test
  public void testGetFecha() {
    System.out.println("getFecha");
    Cita instance = new Cita();
    instance.getFecha();
  }

  @Test
  public void testSetFecha() {
    System.out.println("setFecha");
    String fecha = "2019-11-28";
    Cita instance = new Cita();
    instance.setFecha(fecha);
  }

  @Test
  public void testGetHora() {
    System.out.println("getHora");
    Cita instance = new Cita();
    instance.getHora();
  }

  @Test
  public void testSetHora() {
    System.out.println("setHora");
    String hora = " 9:00 horas ";
    Cita instance = new Cita();
    instance.setHora(hora);
  }

  @Test
  public void testGetEstudiante() {
    System.out.println("getEstudiante");
    Cita instance = new Cita();
    instance.getEstudiante();
  }

  @Test
  public void testSetEstudiante() {
    System.out.println("setEstudiante");
    Estudiante estudiante = null;
    Cita instance = new Cita();
    instance.setEstudiante(estudiante);
  }
 
}