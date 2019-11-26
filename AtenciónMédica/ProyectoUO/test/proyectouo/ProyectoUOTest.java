package proyectouo;

import javafx.stage.Stage;

import org.junit.Test;

/**
 * Clase de pruebas unitarias de la clase ProyectoUO del sistema.
 * 
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 25-11-2019
 */
public class ProyectoUOTest {
  
  /**
   * Prueba del método Main, de la clase ProyectoUO.
   */
  @Test
  public void testMain() {
    System.out.println("main");
    String[] args = null;
    ProyectoUO.main(args);
  }

  /**
   * Prueba del método Start, de la clase ProyectoUO.
   */
  @Test
  public void testStart() {
    System.out.println("start");
    Stage primaryStage = null;
    ProyectoUO instance = new ProyectoUO();
    instance.start(primaryStage);
  }
  
}