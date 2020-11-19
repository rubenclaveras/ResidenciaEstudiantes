package residencia.logica.datos;

/**
 * Clase para insertar los estudiantes en la base de datos
 * @author Ruben Claveras
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import residencia.clases.Estudiante;



public class EstudianteBD {

	
		/**
		 * Metodo para crear la tabla estudiante en sql
		 * @param conn - conexion
		 */
		public static void crearTablaEstudiante(Connection conn){

			// SQL statement for creating a new table
			String sql = "CREATE TABLE IF NOT EXISTS estudiante (\n" 
					+ "    codigoEstudiante text PRIMARY KEY,\n"
					+ "    nombre text NOT NULL,\n" 
					+ "    DNI text NOT NULL,\n" 
					+ "    cuotaAnual integer NOT NULL,\n"  
					+ "    habitacion integer NOT NULL\n"
					+ "    usuario text NOT NULL,\n" 
					+ "    contrasenia text NOT NULL\n" 
					+ ");";

			try (Statement stmt = conn.createStatement()) {
				// create a new table

				stmt.execute(sql);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		/**
		 * Metodo para insertar los datos de los estudiantes en la base de datos
		 * @param conn - conexion
		 * @param codigoEstudiante - codigo identificativo del estudiante
		 * @param nombre - Nombre y primer apellido del estudiante
		 * @param DNI - dni del estudiante
		 * @param cuotaAnual - precio que paga el estudiante al año por su estancia
		 * @param habitacion - habitacion que ocupa
		 * @param usuario - nombre de usuario
		 * @param contrasenia - contraseña del usuario
		 */
		public static void insertarEstudiante(Connection conn, String codigoEstudiante, String nombre,
				String DNI, int cuotaAnual,
				int habitacion, String usuario, String contrasenia) {
			String sql = "INSERT INTO estudiante(codigoEstudiante,nombre, DNI,cuotaAnual,habitacion, usuario, contrasenia) VALUES(?,?,?,?,?,?,?)";
			

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				
				pstmt.setString(1, codigoEstudiante);
				pstmt.setString(2, nombre);
				pstmt.setString(3, DNI);
				pstmt.setInt(4, cuotaAnual);
				pstmt.setInt(5, habitacion);
				pstmt.setString (6, usuario);
				pstmt.setString (7, contrasenia);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		/**
		 * Metodo para seleccionar todos los estudiantes de la base de datos
		 * @param conn - conexion
		 * @return lista con todos los datos de todos los estudiantes de la residencia
		 */
		public static ArrayList<Estudiante> seleccionEstudiantes(Connection conn) {
			String sql = "SELECT codigoEstudiante,nombre,DNI,cuotaAnual,habitacion,usuario,contrasenia FROM estudiante";
			ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
			try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				
				
					while (rs.next()) {

						String codigo= rs.getString("codigoEstudiante");
						String nom = rs.getString("nombre");
						String dni = rs.getString("DNI");
						int cuot = rs.getInt("cuotaAnual");
						int habita = rs.getInt("cuotaAnual");
						String user = rs.getString("nombre");
						String contra = rs.getString("DNI");
						

						Estudiante seleccionado = new Estudiante(codigo,nom,dni,cuot,habita,user,contra);
						lista.add(seleccionado);


				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			return lista;
		}

		/**
		 * Metodo para eliminar estudiantes de la base de datos
		 * @param conn - conexion
		 * @param codigoEst - codigo del estudiante a eliminar
		 */
		public static void borrarEstudiante(Connection conn, String codigoEst) {
			String sql = "DELETE FROM estudiante WHERE codigoEst = ?";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				
				pstmt.setString(1, codigoEst);

				// execute the delete statement
				pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

}
