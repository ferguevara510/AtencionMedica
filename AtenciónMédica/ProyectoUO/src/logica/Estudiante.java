package logica;

/**
 * Clase Estudiante.
 *
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 20-11-2019
 */
public class Estudiante {
  
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String matricula;
  private String programaeducativo;

  /**
   * Constructor de la clase Estudiante.
   * 
   * @param nombre atributo del nombre(s) del Estudiante
   * @param apellidoPaterno atributo del apellido paterno del Estudiante
   * @param apellidoMaterno atributo del apellido materno del Estudiante
   * @param matricula atributo de la matricula del Estudiante
   * @param programaeducativo atributo del programa educativo del Estudiante
   */
  public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno, 
          String matricula, String programaeducativo) {
    this.nombre = nombre;
    this.apellidoPaterno = apellidoPaterno;
    this.apellidoMaterno = apellidoMaterno;
    this.matricula = matricula;
    this.programaeducativo = programaeducativo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidoPaterno() {
    return apellidoPaterno;
  }

  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }

  public String getApellidoMaterno() {
    return apellidoMaterno;
  }

  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getProgramaeducativo() {
    return programaeducativo;
  }

  public void setProgramaeducativo(String programaeducativo) {
    this.programaeducativo = programaeducativo;
  }
  
  @Override
  public String toString(){
    return "";
  }
  
}