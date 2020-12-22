package residencia.logica.datos;

/**
 * Clase para insertar salones comunitarios en la base de datos
 * @author Ruben Claveras
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import residencia.clases.SalonComunitario;



public class SalonBD {

	
		/**
		 * Metodo para crar la tabla salon en la base de datos
		 * @param conn - conexion
		 */
		public static void crearTablaSalon(Connection conn){

			// SQL statement for creating a new table
			String sql = "CREATE TABLE IF NOT EXISTS salon (\n" 
					+ "    numero integer PRIMARY KEY,\n"
					+ "    tipo text NOT NULL,\n" 
					+ "    reservado text NOT NULL,\n" 
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
		 * Metodo para insertar los datos de los salones en la base de datos
		 * @param conn - conexion
		 * @param numero - numero del salon
		 * @param tipo - cual es el tipo del salon; si es el salon de tv, de musica...
		 * @param reservado - si esta o no reservado por algun estudiante
		 * @param codigoAlumno - codigo del alumno que lo ha reservado
		 */
		public static void insertarSalon(Connection conn, int numero, String tipo,
				boolean reservado, String codigoAlumno) {
			String sql = "INSERT INTO salon(numero,tipo,reservado,codigoAlumno) VALUES(?,?,?,?)";
			

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				
				pstmt.setInt(1, numero);
				pstmt.setString(2, tipo);
				pstmt.setBoolean(3, reservado);
				pstmt.setString(4, codigoAlumno);

				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		/**
		 * Metodo para seleccionar los datos de los salones en la base de datos
		 * @param conn - conexion
		 * @return lista con todos los datos de todos los salones de la base de datos
		 */
		public static ArrayList<SalonComunitario> seleccionSalones(Connection conn) {
			String sql = "SELECT numero,tipo,reservado,codigoAlumno FROM salon";
			ArrayList<SalonComunitario> lista = new ArrayList<SalonComunitario>();
			try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				
				
					while (rs.next()) {

						int num= rs.getInt("numero");
						String tip= rs.getString("tipo");
						boolean res = rs.getBoolean("reservado");
						String cod= rs.getString("codigoAlumno");

						SalonComunitario seleccionado = new SalonComunitario(num,tip,res,cod);
						lista.add(seleccionado);


				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			return lista;
		}

		/**
		 * Metodo para eliminar un salon de la lista
		 * @param conn - conexion
		 * @param num - numero del salon a eliminar
		 */
		public static void borrarSalon(Connection conn, int num) {
			String sql = "DELETE FROM salon WHERE numero = ?";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				
				pstmt.setInt(1, num);

				// execute the delete statement
				pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

}
