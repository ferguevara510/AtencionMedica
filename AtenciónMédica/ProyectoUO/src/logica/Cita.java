package logica;

/**
 * Clase Cita.
 *
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 20-11-2019
 */
public class Cita {
  
  private String fecha;
  private String hora;
  private Estudiante estudiante;

  /**
   * Constructor de la clase Cita.
   * 
   * @param fecha atributo de la fecha de la Cita
   * @param hora atributo de la hora de la Cita
   * @param minutos atributo de los minutos de la Cita
   * @param estudiante atributo del Estudiante de la Cita
   */
  public Cita(String fecha, String hora, Estudiante estudiante) {
    this.fecha = fecha;
    this.hora = hora;
    this.estudiante = estudiante;
  }

  public Cita() {
  }
  
  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public Estudiante getEstudiante() {
    return estudiante;
  }

  public void setEstudiante(Estudiante estudiante) {
    this.estudiante = estudiante;
  }

  @Override
  public String toString() {
    return "Cita{" + "fecha=" + fecha + ", hora=" + hora + ", estudiante=" + estudiante + '}';
  }
  
}