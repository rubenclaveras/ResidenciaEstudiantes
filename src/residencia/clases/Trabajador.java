package residencia.clases;

/**
 * @author Gorka y Ruben
 *
 */
public class Trabajador extends Personas {
	public String codigoTrabajador;
	public int salario;
	public String funcion;
	
	/**
	 * Crea un nuevo trabajador con toda la documentación necesaria
	 * @param codigoTrabajador - Es el codigo identificativo que tiene cada trabajador
	 * @param nombre - Es el nombre completo del trabajador
	 * @param DNI - Es el DNI del trabajador
	 * @param salario - Es lo que cobra el trabajador
	 * @param funcion - Es la funcion que desempeña el trabajador
	 * @param usuario - Es el usuario con el que iniciara sesión el trabajador
	 * @param contrasenia - Es la contraseña vinculada con el usuario con la que iniciara sesión el trabajador
	 */
	public Trabajador(String codigoTrabajador, String nombre,String DNI,
			int salario, String funcion, String usuario, String contrasenia) {
		super(nombre, DNI, usuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.codigoTrabajador = codigoTrabajador;
		this.funcion = funcion;
		this.salario=salario;
		this.funcion=funcion;
		
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	/**
	 * @return - Devuelve un valor String que contienen el codigo del trabajador 
	 */
	public String getCodigoTrabajador() {
		return codigoTrabajador;
	}

	/**
	 * @param codTrabajador - Define un valor String que contiene el codigo del trabajador
	 */
	public void setCodigoTrabajador(String codigoTrabajador) {
		this.codigoTrabajador = codigoTrabajador;
	}

	/**
	 * @return - Devuelve un valor int que contienen el salario del trabajador 
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * @param salario - Define un valor int que contiene el salario del trabajador
	 */
	public void setSalario(int salario) {
		this.salario = salario;
	}
	

}
