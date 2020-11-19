package residencia.clases;

	/**
	 * Esta clase sala define las diferentes
	 * salas de nuestra residencia de estudiantes
	 * @author Rubén Claveras
	 * @version 1.0
	 */
public class Sala {
	public int numero; //es una variable entera que nos indica el numero de la sala
	
	/**
	 * Clase constructor vacio
	 */
	public Sala() {
		super();
	}
	
	/**
	 * Clase constructor con parametros
	 * @param numero
	 */
	public Sala(int numero) {
		super();
		this.numero = numero;
	}


	/**
	 * Metodo get de numero
	 * @return numero
	 */
	public int getNumero() {
		return numero;
	}


	/**
	 * Metodo set de numero
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
