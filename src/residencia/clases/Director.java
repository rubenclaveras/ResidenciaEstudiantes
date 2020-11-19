package residencia.clases;


/**
 * esta clase crea y define al director de la residencia 
 * @author Gorka
 * @version 2.0
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
	 * @param salario - Es el salario que cobra el director
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
	
	/**
	 * @return - Devuelve un valor int que contienen el salario del director 
	 */
	public int getSalario() {
		return salario;
	}
	/**
	 * @param salario - Define un valor int que contiene el salario del director
	 */
	public void setSalario(int salario) {
		this.salario = salario;
		
	}
	
	/**
	 * Metodo que imprime por pantalla la informacion del director 
	 */
	@Override
	public String mostrarInformacion(){
		return codigoDirector + ";" + super.getNombre() + ";" + super.getDNI()+ ";" + salario;
	}

}
