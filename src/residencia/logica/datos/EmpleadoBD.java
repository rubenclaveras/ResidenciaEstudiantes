package residencia.logica.datos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import residencia.clases.Trabajador;
/**
 * Esta clase se utiliza para la creacion de los empleados en la base de datos
 * @author Ruben Claveras
 */


public class EmpleadoBD {

		/**
		 * Metodo para crear en la base de datos la tabla empleado
		 * @param conn - conexion
		 */
		
		public static void crearTablaEmpleado(Connection conn){

			// SQL statement for creating a new table
			String sql = "CREATE TABLE IF NOT EXISTS empleado (\n" 
					+ "    codigoEmpleado text PRIMARY KEY,\n"
					+ "    nombre text NOT NULL,\n" 
					+ "    DNI text NOT NULL,\n" 
					+ "    salario integer NOT NULL,\n" 
					+ "    funcion text  NOT NULL,\n" 
					+ "    usuario text  NOT NULL,\n" 
					+ "    contrasenia text  NOT NULL\n" 
					+ ");";

			try (Statement stmt = conn.createStatement()) {
				// create a new table

				stmt.execute(sql);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		/**
		 * Metodo para insertar en la tabla empleado los datos
		 * @param conn - conexion
		 * @param codigoEmpleado - el codigo identificativo del empleado
		 * @param nombre - El nombre y primer apellido
		 * @param DNI - dni del empleado
		 * @param salario - salario mensual que cobra
		 * @param funcion - la funcion que desempeña en la residencia: limpieza, mantenimiento o director
		 * @param usuario - su nombre de usuario para acceder
		 * @param contrasenia - su contraseña
		 */
		public static void insertarEmpleado(Connection conn, String codigoEmpleado,String nombre, String DNI, int salario,
				String funcion, String usuario, String contrasenia) {
			String sql = "INSERT INTO empleado(codigoEmpleado,nombre, DNI,salario,funcion,usuario,contrasenia) VALUES(?,?,?,?,?,?,?)";
			

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				
				pstmt.setString(1, codigoEmpleado);
				pstmt.setString(2, nombre);
				pstmt.setString(3, DNI);
				pstmt.setInt(4, salario);
				pstmt.setString(5, funcion);
				pstmt.setString(6, usuario);
				pstmt.setString(7, contrasenia);

				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		/**
		 * Metodo para hacer select de todos los empleados
		 * @param conn - conexion
		 * @return lista - lista con todos los empleados; selecciona todos los datos de cada uno
		 */
		public static ArrayList<Trabajador> seleccionEmpleados(Connection conn) {
			String sql = "SELECT codigoEmpleado,nombre, DNI,salario,funcion FROM empleado";
			ArrayList<Trabajador> lista = new ArrayList<Trabajador>();
			try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				
				
					while (rs.next()) {

						String codigoEmp= rs.getString("codigoEmpleado");
						String nom = rs.getString("nombre");
						String dni = rs.getString("DNI");
						int sal = rs.getInt("salario");
						String func= rs.getString("funcion");
						String user = rs.getString("usuario");
						String contra = rs.getString("contrasenia");

						Trabajador seleccionado = new Trabajador(codigoEmp,nom,dni,sal,func,user,contra);
						lista.add(seleccionado);


				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			return lista;
		}

		/**
		 * Metodo para eliminar un empleado de la base de datos
		 * @param conn - conexion
		 * @param codigoEmp - codigo del empleado a borrar
		 */
		public static void borrarEmpleado(Connection conn, String codigoEmp) {
			String sql = "DELETE FROM empleado WHERE codigoEmp = ?";

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				
				pstmt.setString(1, codigoEmp);

				// execute the delete statement
				pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

}

