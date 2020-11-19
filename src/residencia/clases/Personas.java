package residencia.clases;

/**	
 * Esta clase define a las diferentes personas con las que vamos a trabajar en nuestra residencia
 * 
 * @author Gorka
 * @version 2.0
 */
public abstract class Personas {
	public String nombre;
	public String DNI;
	public String usuario;
	public String contrasenia;
	
	/** 
	 * Crea una nueva Persona con toda la documentación necesaria
	 * @param nombre - Es el nombre de la persona
	 * @param DNI - Es el DNI de la persona
	 * @param usuario - Es el usuario con el que iniciara sesión la persona
	 * @param - Es la contraseña con la que iniciara sesion la persona
	 */
	public Personas(String nombre,String DNI, String usuario, String contrasenia) {
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		
	}

	
	/**
	 * @return - Devuelve un valor String que contiene el nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre - Define un valor String que contiene el nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return - Devuelve un valor String que contiene el DNI de la persona
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * @param DNI - Define un valor String que contiene el DNI de la persona
	 */
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	/**
	 * @return - Devuelve un valor String que contiene el usuario de la persona
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario - Define un valor String que contiene el usuario de la persona
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return - Devuelve un valor String que contiene la contraseña de la persona
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia - Define un valor String que contiene la contraseña de la persona
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	/**
	 * metodo abstracto que mostrara alguna informacion de la persona implementada en las clases hijas
	 */
	public abstract String mostrarInformacion();
	
	
	
	

}
