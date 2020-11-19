package residencia.clases;

/**
 * @author Gorka
 *
 */
public class Estudiante extends Personas {
	public String codigoEstudiante;
	public int cuotaAnual;
	public int habitacion;
	
	/**
	 * Crea un nuevo estudiante con toda la documentación necesaria
	 * @param codigoEstudiante - Es el codigo identificativo que tiene cada estudiante
	 * @param nombre- Es el nombre completo del estudiante
	 * @param DNI - Es el DNI del estudiante
	 * @param cuotaAnual - El importe anual que paga
	 * @param habitacion - Es la habitacion en la que esta
	 * @param usuario - Es el usuario con el que iniciara sesión el estudiante
	 * @param contrasenia - Es la contraseña vinculada con el usuario con la que iniciara sesión el estudiante
	 */
	public Estudiante(String codigoEstudiante, String nombre,
			String DNI, int cuotaAnual,
			int habitacion,String usuario, String contrasenia){
		super(nombre, DNI, usuario, contrasenia);
		this.codigoEstudiante = codigoEstudiante;
		this.cuotaAnual=cuotaAnual;
		this.habitacion=habitacion;
	}


	/**
	 * @return - Devuelve un valor String que contienen el codigo del estudiante
	 */
	public String getCodigoEstudiante() {
		return codigoEstudiante;
	}

	/**
	 * @param codigoEstudiante - - Define un valor String que contiene el codigo del estudiante
	 */
	public void setCodigoEstudiante(String codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}


	public int getCuotaAnual() {
		return cuotaAnual;
	}


	public void setCuotaAnual(int cuotaAnual) {
		this.cuotaAnual = cuotaAnual;
	}


	public int getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(int habitacion) {
		this.habitacion = habitacion;
	}
	

}

