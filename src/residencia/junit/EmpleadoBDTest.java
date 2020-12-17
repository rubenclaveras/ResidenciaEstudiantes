package residencia.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.clases.Trabajador;
import residencia.logica.datos.CrearBD;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase SalonEmpleado
 * @author Ruben
 * @version 1.0
 */
public class EmpleadoBDTest {

	private CrearBD base = null;
	
	/**
	 * metodo que se ejecutara antes de cada test en el cual se conecta con la base de datos Junit
	 */
	@Before
	public void setUp() throws Exception {

		base = new CrearBD("ResidenciaJunit.db");
		base.createLink();
	}

	/**
	 * metodo que se ejecutara al final de cada test en el cual se cierra la conexion con la base de datos Junit
	 */
	@After
	public void tearDown() throws Exception {
		base.closeLink();

	}


	/**
	 * metodo que se ejecutara para compobar si el metodo InsertarEmpleado funciona correctamente
	 */
	@Test
	public void testInsertarEmpleado() throws SQLException {

		residencia.logica.datos.EmpleadoBD.crearTablaEmpleado(base.getConn());
		residencia.logica.datos.EmpleadoBD.insertarEmpleado(base.getConn(), "EM0400","Nombre Prueba", "12345678A", 9999, "limpieza", "nombre", "prueba");
		ArrayList<Trabajador> listaTrabajador = residencia.logica.datos.EmpleadoBD.seleccionEmpleados(base.getConn());

		for (Trabajador a : listaTrabajador) {

			if (a.getCodigoTrabajador().equals("ES0400")) {
			
				assertEquals(a.getNombre(), "Nombre Prueba");
				assertEquals(a.getDNI(), "12345678A");
				assertEquals(a.getSalario(), 9999);
				assertEquals(a.getFuncion(), "limpieza");
				assertEquals(a.getUsuario(), "nombre");
				assertEquals(a.getContrasenia(), "prueba");
				
			
			}
		}
	}
	/**
	 * metodo que se ejecutara para compobar si el metodo SeleccionarEmpleado funciona correctamente
	 */
	@Test
	public void testSeleccionarEmpleado() throws SQLException {

		residencia.logica.datos.EmpleadoBD.crearTablaEmpleado(base.getConn());
		residencia.logica.datos.EmpleadoBD.insertarEmpleado(base.getConn(), "EM0500","Nombre Prueba", "12345678A", 9999, "mantenimiento", "nombre", "prueba");
		ArrayList<Trabajador> listaTrabajador = residencia.logica.datos.EmpleadoBD.seleccionEmpleados(base.getConn());

		for (Trabajador a : listaTrabajador) {

			if (a.getCodigoTrabajador().equals("ES0500")) {
			
				assertEquals(a.getNombre(), "Nombre Prueba");
				assertEquals(a.getDNI(), "12345678A");
				assertEquals(a.getSalario(), 9999);
				assertEquals(a.getFuncion(), "mantenimiento");
				assertEquals(a.getUsuario(), "nombre");
				assertEquals(a.getContrasenia(), "prueba");
				
			
			}
		}
	}
	/**
	 * metodo que se ejecutara para compobar si el metodo EliminarEmpleado funciona correctamente
	 */
	@Test
	public void testEliminarEmpleado() throws SQLException {

		residencia.logica.datos.EmpleadoBD.crearTablaEmpleado(base.getConn());
		residencia.logica.datos.EmpleadoBD.borrarEmpleado(base.getConn(), "EM0600");
		ArrayList<Trabajador> listaEmpleado = residencia.logica.datos.EmpleadoBD.seleccionEmpleados(base.getConn());
		
		for (Trabajador a : listaEmpleado) {

			if (a.getCodigoTrabajador().equals("EM0600")) {
				assertEquals(1, 0);
			}
			
		}
	}
		
}

