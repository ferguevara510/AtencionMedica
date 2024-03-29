package logica;

/**
 * Clase Producto.
 *
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 20-11-2019
 */
public class Producto {
  
  private int id;
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

  /**
   * Constructor vacio de la clase Producto.
   */
  public Producto() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
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
    return " Nombre: " + nombre + "  Presentacion: " + presentacion + "  Existencias: " 
            + existencias;
  }
  
}