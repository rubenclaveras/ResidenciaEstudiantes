package residencia.clases;


/**
 * esta clase crea y define al director de la residencia 
 * @author Gorka
 * @version 2.0
 */
public class Director<T, V> extends Personas {
	public T codigoDirector;
	public V salario;

	/**
	 * Crea un nuevo director con toda la documentaci�n necesaria
	 * @param codigoDirector - Es el codigo identificativo que tiene el director
	 * @param nombre - Es el nombre del direcctor
	 * @param DNI - Es el DNI del direcctor
	 * @param usuario - Es el usuario con el que iniciara sesi�n el direcctor
	 * @param contrasenia - Es la contrase�a vinculada con el usuario con la que iniciara sesi�n el direcctor
	 * @param salario - Es el salario que cobra el director
	 */
	public Director(String nombre, String DNI, V salario,
			String usuario, String contrasenia, T codigoDirector) {
		super(nombre,DNI, usuario, contrasenia);
		// TODO Auto-generated constructor stub
		this.codigoDirector = codigoDirector;
		this.salario=salario;
	}

	/**
	 * @return - Devuelve un valor String que contienen el codigo del director 
	 */
	public T getCodigoDirector() {
		return codigoDirector;
	}

	/**
	 * @param codigoDirector - Define un valor String que contiene el codigo del director
	 */
	public void setCodigoDirector(T codigoDirector) {
		this.codigoDirector = codigoDirector;
	}
	
	/**
	 * @return - Devuelve un valor int que contienen el salario del director 
	 */
	public V getSalario() {
		return salario;
	}
	/**
	 * @param salario - Define un valor int que contiene el salario del director
	 */
	public void setSalario(V salario) {
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
