package residencia.clases;

	/**
	* Esta clase define los salones comunitarios de
	* la residencia que pueden ser usados por todos
	* los estudiantes y hereda de la clase sala 
 	* @author Rubén Claveras
 	*/
public class SalonComunitario extends Sala {
	
	public String tipo; //es una variable string que nos indica el tipo de salon que es (salon, gimnasio...)
	public boolean estaReservada; //este booleano nos indica si el salón está reservado (los estudiantes pueden reservar los salones por horas) o libre
	public String codigoAlumnoSalon;
	

	/**
	 * Constructor completo
	 * @param nombre
	 * @param numero
	 * @param tipo
	 * @param estaReservada
	 */
	public SalonComunitario(int numero, String tipo, boolean estaReservada, 
			String codigoAlumnoSalon ) {
		super(numero);
		this.tipo = tipo;
		this.estaReservada = estaReservada;
		this.codigoAlumnoSalon=codigoAlumnoSalon;
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
	 * Metodo get de estaReservada
	 * @return estaReservada
	 */
	public boolean isEstaReservada() {
		return estaReservada;
	}

	/**
	 * Metodo set de estaReservada
	 * @param estaReservada
	 */
	public void setEstaReservada(boolean estaReservada) {
		this.estaReservada = estaReservada;
	}

	/**
	 * Metodo get del almno que ha reservado el salon
	 * @return codigo del alumno que ha reservado
	 */
	public String getCodigoAlumnoSalon() {
		return codigoAlumnoSalon;
	}

	/**
	 * Metodo set del codigo de alumno que ha reservado el salon
	 * @param codigoAlumnoSalon
	 */
	public void setCodigoAlumnoSalon(String codigoAlumnoSalon) {
		this.codigoAlumnoSalon = codigoAlumnoSalon;
	}
	@Override
	public int getNumero() {
		// TODO Auto-generated method stub
		return super.getNumero();
	}

@Override
	public void setNumero(int numero) {
		// TODO Auto-generated method stub
		super.setNumero(numero);
	}
	

	
}
