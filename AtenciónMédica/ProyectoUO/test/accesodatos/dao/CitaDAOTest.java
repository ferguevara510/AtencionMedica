package accesodatos.dao;

import java.util.List;
import junit.framework.TestCase;
import logica.Cita;
import logica.Estudiante;
import org.junit.Test;

/**
 * Clase de pruebas unitarias de la clase CitaDAO del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class CitaDAOTest extends TestCase{
  
  @Test
  public void testRegistrarCita() throws Exception {
    System.out.println("registrarCita");
    Cita cita = new Cita();
    cita.setFecha("2019-11-27");
    cita.setHora(" 9:00 horas ");
    cita.setEstudiante(new Estudiante("Karla Fernanda", "Guevara", "Flores", "S15011604", 
            "Ingeniería de Software"));
    boolean expResult = true;
    boolean result = new CitaDAO().registrarCita(cita);
  }
   
  @Test
  public void testRegistrarCitaNoFecha() throws Exception {
    System.out.println("registrarCita");
    Cita cita = new Cita();
    cita.setFecha(null);
    cita.setHora(" 9:00 horas ");
    cita.setEstudiante(new Estudiante("Karla Fernanda", "Guevara", "Flores", "S15011604", 
            "Ingeniería de Software"));
    CitaDAO instance = new CitaDAO();
    boolean expResult = false;
    boolean result = new CitaDAO().registrarCita(cita);
    assertEquals(expResult, result);
  }
  
  @Test
  public void testRegistrarCitaNoHora() throws Exception {
    System.out.println("registrarCita");
    Cita cita = new Cita();
    cita.setFecha("2019-11-27");
    cita.setHora(null);
    cita.setEstudiante(new Estudiante("Karla Fernanda", "Guevara", "Flores", "S15011604", 
            "Ingeniería de Software"));
    CitaDAO instance = new CitaDAO();
    boolean expResult = false;
    boolean result = new CitaDAO().registrarCita(cita);
    assertEquals(expResult, result);
  }

  @Test
  public void testValidalidarDisponibilidadDeCitaOcupada() throws Exception {
    System.out.println("validalidarDisponibilidadDeCita");
    String fecha = "2019-11-28";
    String hora = " 9:30 horas ";
    CitaDAO instance = new CitaDAO();
    boolean expResult = false;
    boolean result = instance.validalidarDisponibilidadDeCita(fecha, hora);
    assertEquals(expResult, result);
  }
  
  @Test
  public void testValidalidarDisponibilidadDeCitaDisponible() throws Exception {
    System.out.println("validalidarDisponibilidadDeCita");
    String fecha = "2019-11-29";
    String hora = " 9:00 horas ";
    CitaDAO instance = new CitaDAO();
    boolean expResult = true;
    boolean result = instance.validalidarDisponibilidadDeCita(fecha, hora);
    assertEquals(expResult, result);
  }

  @Test
  public void testMostrarCitas() throws Exception {
    System.out.println("mostrarCitas");
    CitaDAO instance = new CitaDAO();
    List<Cita> result = instance.mostrarCitas();
    assertEquals(true, !result.isEmpty());
  }
  
  @Test
  public void testNoMostrarCitas() throws Exception {
    System.out.println("mostrarCitas");
    CitaDAO instance = new CitaDAO();
    List<Cita> result = instance.mostrarCitas();
    assertEquals(false, result.isEmpty());
  }
  
}