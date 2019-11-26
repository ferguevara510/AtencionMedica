package logica;

/**
 * Clase Producto.
 *
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 20-11-2019
 */
public class Producto {
  
  private String nombre;
  private String presentacion;
  private int existencias;

  /**
   * Constructor de la clase Producto.
   *
   * @param nombre atributo del nombre del Producto
   * @param presentacion atributo del tipo presentación del Producto
   * @param existencias atributo de las existencias del Producto
   */
  public Producto(int existencias, String nombre, String presentacion) {
    this.nombre       = nombre;
    this.presentacion = presentacion;
    this.existencias  = existencias;
  }

  public Producto() {
  }

  /**
   * Método 
   * @return 
   */
  public int getExistencias() {
    return existencias;
  }

  public void setExistencias(int existencias) {
    this.existencias = existencias;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPresentacion() {
    return presentacion;
  }

  public void setPresentacion(String presentacion) {
    this.presentacion = presentacion;
  }

  @Override
  public String toString() {
    return "Producto{" + "nombre=" + nombre + ", presentacion=" + presentacion + ", existencias=" 
            + existencias + '}';
  }
  
}