 package residencia.logica.datos;

 /**
  * Clase para la creacion de la base de datos
  * @author Ruben Claveras
  */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CrearBD {

	private Connection conn;
	private String nombreBD;
	private String URL = "jdbc:sqlite:";

	
	
	/**
	 * Metodo para crear la base de datos
	 * @param nombreBD - nombre que tendrá la base de datos
	 */
	public CrearBD (String nombreBD) {
		this.nombreBD = this.URL + nombreBD;

	}

	/**
	 * Metodo get de la conexion
	 * @return conexion
	 */
	public Connection getConn() {
		return conn;
	}
	/**
	 * Metodo set de la conexion
	 * @param conn - conexion
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Metodo para inicializar la base de datos
	 * Crea las tablas de cada clase e inserta los datos
	 */
	public  void inicializarBD() {

		try{

		EstudianteBD.crearTablaEstudiante(this.conn);
		EmpleadoBD.crearTablaEmpleado(this.conn);
		HabitacionBD.crearTablaHabitacion(this.conn);
		SalonBD.crearTablaSalon(this.conn);

		
		
		EstudianteBD.insertarEstudiante(this.conn, "ES0001","Alejandro Diaz", "92849375S", 8000, 001, "alejandro", "diaz19");
		EstudianteBD.insertarEstudiante(this.conn, "ES0002", "Fernando Gonzalez","83029857T", 7000, 004, "fernando", "gonzalez1");
		EstudianteBD.insertarEstudiante(this.conn, "ES0003", "Maria Alonso","47190394D", 8000, 004,"maria","contra21");
		EstudianteBD.insertarEstudiante(this.conn, "ES0004","Irene Gutierrez", "52837549F", 8000, 005, "irene","guti20");
		EstudianteBD.insertarEstudiante(this.conn, "ES0005","Silvia Garmendia", "92953494K", 7000, 007,"silvia","ordenador");
		EstudianteBD.insertarEstudiante(this.conn, "ES0006","Sergio Gonzalez", "19342932L", 8000,007,"sergio","srgiogon");
		EstudianteBD.insertarEstudiante(this.conn, "ES0007", "Angel Etxaide","71937492M", 7000, 010,"angel","etxi100");
		
		
		EmpleadoBD.insertarEmpleado(this.conn, "D0001","Faustino Fernandez", "82473847P", 3000, "Director","faustino","director01");
		EmpleadoBD.insertarEmpleado(this.conn, "EM0002","Blanca Gonzalez", "73829574N", 2000, "Mantenimiento","blanca","gon12");
		EmpleadoBD.insertarEmpleado(this.conn, "EM0003","Anton Perez", "54637465Y", 2000, "Mantenimiento","anton","pucho54");
		EmpleadoBD.insertarEmpleado(this.conn, "EM0004","Francisco Soares", "83927548M", 1800, "Limpieza","francisco","fran00");
		EmpleadoBD.insertarEmpleado(this.conn, "EM0005","Pilar Suarez", "19403985T", 1800, "Limpieza","pilar","pilimm");
		EmpleadoBD.insertarEmpleado(this.conn, "EM0006","Jorge Camacho", "65748576B", 1800, "Limpieza","jorge","alegria");

		
		HabitacionBD.insertarHabitacion(this.conn, 001, "Individual", true, "ES0001");
		HabitacionBD.insertarHabitacion(this.conn, 002, "Doble", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 003, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 004, "Doble", true, "ES0002,ES0003");
		HabitacionBD.insertarHabitacion(this.conn, 005, "Individual", true, "ES0004");
		HabitacionBD.insertarHabitacion(this.conn, 006, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 007, "Doble", true, "ES0005,ES0006");
		HabitacionBD.insertarHabitacion(this.conn, 010, "Individual", true, "ES0007");
		HabitacionBD.insertarHabitacion(this.conn, 011, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 012, "Doble", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 013, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 014, "Doble", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 015, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 016, "Doble", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 017, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 020, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 021, "Doble", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 022, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 023, "Individual", false, null);
		HabitacionBD.insertarHabitacion(this.conn, 024, "Individual", false, null);
		
		SalonBD.insertarSalon(this.conn, 101, "Television", true, "ES0001");
		SalonBD.insertarSalon(this.conn, 102, "Billar", true, "ES0003");
		SalonBD.insertarSalon(this.conn, 103, "Videojuegos", true, "ES0004");
		SalonBD.insertarSalon(this.conn, 104, "Futbolin", true, "ES0006");
		SalonBD.insertarSalon(this.conn, 105, "Musica", true, "ES0007");
		
		} catch (Exception e) {
			
			System.out.println("Process terminated with errors");
		} 

		this.closeLink(); 

	}

	/**
	 * Metodo para crear el link con la base de datos
	 */
	public void createLink(){
		try {
			this.conn = DriverManager.getConnection(this.nombreBD);
	
		} catch (SQLException e) {
			System.out.println("BadAss error creating connection. " + e.getMessage());
		}
	}

	/**
	 * Metodo para crear la base de datos
	 * @param fileName - nombre de la base de datos
	 */
	 public static void crearBaseDatos(String fileName)
	    {

	        String url = "jdbc:sqlite:" + fileName;

	        try (Connection conn = DriverManager.getConnection(url))
	        {
	            if (conn != null)
	            {
	                DatabaseMetaData meta = conn.getMetaData();
	                System.out.println("The driver name is " + meta.getDriverName());
	                System.out.println("A new database has been created.");
	            }
	        } catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }



	
	 /**
	  * Metodo para cerrar el link con la base de datos
	  */
	public void closeLink(){

		try {

			if (this.conn != null) {

				this.conn.close();
			}
		} catch (SQLException ex) {

			System.out.println("BadAss error closing connection" + ex.getMessage());

		}

	}
	
}
