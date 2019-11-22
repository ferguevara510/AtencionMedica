package logica;

import logica.enums.EHora;
import logica.enums.EMinutos;

/**
 * Clase Cita.
 *
 * @author Karla Fernanda Guevara Flores
 * @version 1.0
 * @since 20-11-2019
 */
public class Cita {
  
  private String fecha;
  private EHora hora;
  private EMinutos minutos;

  /**
   * Constructor de la clase Cita.
   * 
   * @param fecha atributo de la fecha de la Cita
   * @param hora atributo de la hora de la Cita
   * @param minutos atributo de los minutos de la Cita
   */
  public Cita(String fecha, EHora hora, EMinutos minutos) {
    this.fecha = fecha;
    this.hora = hora;
    this.minutos = minutos;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public EHora getHora() {
    return hora;
  }

  public void setHora(EHora hora) {
    this.hora = hora;
  }

  public EMinutos getMinutos() {
    return minutos;
  }

  public void setMinutos(EMinutos minutos) {
    this.minutos = minutos;
  }
  
}