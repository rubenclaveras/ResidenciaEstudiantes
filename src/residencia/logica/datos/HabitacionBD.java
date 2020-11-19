package residencia.logica.datos;

/**
 * Clase para insertar los datos de las habitaciones en la base de datos de la residencia
 * @author Ruben Claveras
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import residencia.clases.Habitacion;



public class HabitacionBD {

	
		/**
		 * Metodo para crear las tablas de las habitaciones
		 * @param conn - conexion
		 */
		public static void crearTablaHabitacion(Connection conn){

			// SQL statement for creating a new table
			String sql = "CREATE TABLE IF NOT EXISTS habitacion (\n" 
					+ "    numero integer PRIMARY KEY,\n"
					+ "    tipo text NOT NULL,\n" 
					+ "    ocupada text NOT NULL,\n" 
					+ "    codigoAlumno text\n" 
					+ ");";

			try (Statement stmt = conn.createStatement()) {
				// create a new table

				stmt.execute(sql);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		/**
		 * Metodo para insertar los datos en la base de datos
		 * @param conn - conexion
		 * @param numero - numero de la habitacion
		 * @param tipo - si es individual o doble
		 * @param ocupada - booleano de si esta ocupada o no
		 * @param codigoAlumno - codigo del alumno que la ocupa, si no esta ocupada es null
		 */
		public static void insertarHabitacion(Connection conn, int numero, String tipo,
				boolean ocupada, String codigoAlumno) {
			String sql = "INSERT INTO habitacion(numero,tipo,ocupada,codigoAlumno) VALUES(?,?,?,?)";
			

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				
				pstmt.setInt(1, numero);
				pstmt.setString(2, tipo);
				pstmt.setBoolean(3, ocupada);
				pstmt.setString(4, codigoAlumno);

				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		/**
		 * Metodo para seleccionar las habitaciones de la base de datos
		 * @param conn - conexion
		 * @return lista con todos los datos de todas las habitaciones de la base de datos
		 */
		public static ArrayList<Habitacion> seleccionHabitaciones(Connection conn) {
			String sql = "SELECT numero,tipo,ocupada,alumno FROM empleado";
			ArrayList<Habitacion> lista = new ArrayList<Habitacion>();
			try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				
				
					while (rs.next()) {

						int num= rs.getInt("numero");
						String tip= rs.getString("tipo");
						boolean ocu= rs.getBoolean("ocupada");
						String alum = rs.getString("alumno");

						Habitacion seleccionado = new Habitacion(num, tip,ocu,alum);
						lista.add(seleccionado);


				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			return lista;
		}

		/**
		 * Metodo para eliminar una habitacion de la base de datos
		 * @param conn - conexion
		 * @param num - numero de la habitacion a eliminar
		 */
		public static void borrarHabitacion(Connection conn, int num) {
			String sql = "DELETE FROM habitacion WHERE numero = ?";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				
				pstmt.setInt(1, num);

				// execute the delete statement
				pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

}
