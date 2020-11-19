package residencia.clases;

/**
 * @author Gorka y Ruben
 * @version 2.0
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
		
	}
	/**
	 * @return - Devuelve un valor String que contienen la funion del trabajador 
	 */
	public String getFuncion() {
		return funcion;
	}
	/**
	 * @param funcion - Define un valor String que contiene la funcion del trabajador
	 */
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
	
	/**
	 * metodo void que imprime por pantalla datos del trabajador 
	 */
	@Override
	public String mostrarInformacion(){
		return codigoTrabajador + ";" + super.getNombre() + ";" + super.getDNI() + ";" + funcion + ";" + salario;
	}
	
	/**
	 * metodo que comprueba si la funcion del trabajador es correcta 
	 */
	public boolean comprobarFuncion(){
		if(funcion == "Mantenimiento" || funcion == "mantenimiento"){
			return true;
		}else if (funcion == "Limpieza" || funcion == "limpieza"){
			return true;
		}else if (funcion == "Director" || funcion == "director"){
			return true;
		}else{
			System.out.println("Error al introducir la funcion");
			return false;
		}
}
		


}
