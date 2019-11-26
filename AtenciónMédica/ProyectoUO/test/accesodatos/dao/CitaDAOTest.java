/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos.dao;

import junit.framework.TestCase;
import logica.Cita;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JENNY
 */
public class CitaDAOTest extends TestCase{
  
  /**
   * Test of registrarCita method, of class CitaDAO.
   */
  /**@Test
  public void testRegistrarCita() throws Exception {
    System.out.println("registrarCita");
    Cita cita = null;
    CitaDAO instance = new CitaDAO();
    boolean expResult = false;
    boolean result = instance.registrarCita(cita);
    assertEquals(expResult, result);
  }*/

  /**
   * Test of validalidarDisponibilidadDeCita method, of class CitaDAO.
   */
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
  /**
   * Test of validalidarDisponibilidadDeCita method, of class CitaDAO.
   */
  @Test
  public void testValidalidarDisponibilidadDeCitaDisponible() throws Exception {
    System.out.println("validalidarDisponibilidadDeCita");
    String fecha = "2019-11-28";
    String hora = " 9:00 horas ";
    CitaDAO instance = new CitaDAO();
    boolean expResult = true;
    boolean result = instance.validalidarDisponibilidadDeCita(fecha, hora);
    assertEquals(expResult, result);
  }
  
}
