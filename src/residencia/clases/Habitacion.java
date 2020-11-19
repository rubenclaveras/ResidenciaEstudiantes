package residencia.clases;

	
	/**
	* Esta clase define las habitaciones de 
	* los estudiantes de nuestra residencia
	* y hereda de la clase sala 
 	* @author Rubén Claveras
 	* @version 1.0
 	*/
public class Habitacion extends Sala {
	
	public String tipo; //es una variable string que nos indica el tipo de habitación que es (individual, doble...)
	public boolean estaOcupada; //este booleano nos indica si la habitación está ocupada (ya hay un estudiante viviendo en ella) o libre
	public String codigoAlumnoHab;
	

	/**
	 * Constructor completo
	 * @param numero
	 * @param tipo
	 * @param estaOcupada
	 * @param codigoAlumnoHab
	 */
	public Habitacion(int numero, String tipo, boolean estaOcupada, 
			String codigoAlumnoHab) {
		super(numero);
		this.tipo = tipo;
		this.estaOcupada = estaOcupada;
		this.codigoAlumnoHab=codigoAlumnoHab;
	}

	/**
	 * Metodo get de tipo
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Metodo set de tipo
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo get de estaOcupada
	 * @return estaOcupada
	 */
	public boolean isEstaOcupada() {
		return estaOcupada;
	}

	/**
	 * Metodo set de estaOcupada
	 * @param estaOcupada
	 */
	public void setEstaOcupada(boolean estaOcupada) {
		this.estaOcupada = estaOcupada;
	}

	public String getCodigoAlumnoHab() {
		return codigoAlumnoHab;
	}

	public void setCodigoAlumnoHab(String codigoAlumnoHab) {
		this.codigoAlumnoHab = codigoAlumnoHab;
	}
	

}
