package residencia.clases;


/**
 * @author Gorka
 *
 */
public class Director extends Personas {
	public String codigoDirector;
	public int salario;

	/**
	 * Crea un nuevo director con toda la documentación necesaria
	 * @param codigoDirector - Es el codigo identificativo que tiene el director
	 * @param nombre - Es el nombre del direcctor
	 * @param DNI - Es el DNI del direcctor
	 * @param usuario - Es el usuario con el que iniciara sesión el direcctor
	 * @param contrasenia - Es la contraseña vinculada con el usuario con la que iniciara sesión el direcctor
	 */
	public Director(String nombre, String DNI, int salario,
			String usuario, String contrasenia, String codigoDirector) {
		super(nombre,DNI, usuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.codigoDirector = codigoDirector;
		this.salario=salario;
	}

	/**
	 * @return - Devuelve un valor String que contienen el codigo del director 
	 */
	public String getCodigoDirector() {
		return codigoDirector;
	}

	/**
	 * @param codigoDirector - Define un valor String que contiene el codigo del director
	 */
	public void setCodigoDirector(String codigoDirector) {
		this.codigoDirector = codigoDirector;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	

}
