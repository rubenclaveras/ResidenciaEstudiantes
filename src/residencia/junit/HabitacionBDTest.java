package residencia.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.clases.Habitacion;
import residencia.logica.datos.CrearBD;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase HabitacionBD
 * @author Ruben
 * @version 1.0
 */
public class HabitacionBDTest {

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
	 * metodo que se ejecutara para compobar si el metodo InsertarHabitacion funciona correctamente
	 */
	@Test
	public void testInsertarHabitacion() throws SQLException {

		residencia.logica.datos.HabitacionBD.crearTablaHabitacion(base.getConn());
		residencia.logica.datos.HabitacionBD.insertarHabitacion(base.getConn(), 900,"Prueba", false, null);
		ArrayList<Habitacion> listaHabitacion = residencia.logica.datos.HabitacionBD.seleccionHabitaciones(base.getConn());

		for (Habitacion a : listaHabitacion) {

			if (a.getNumero()==900){
				
				assertEquals(a.getTipo(), "Prueba");
				assertEquals(a.isEstaOcupada(), false);
				assertEquals(a.getCodigoAlumnoHab(), null);
			}
			}
		}
	/**
	 * metodo que se ejecutara para compobar si el metodo SeleccionarHabitacion funciona correctamente
	 */
	@Test
	public void testSeleccionarHabitacion() throws SQLException {

		residencia.logica.datos.HabitacionBD.crearTablaHabitacion(base.getConn());
		residencia.logica.datos.HabitacionBD.insertarHabitacion(base.getConn(), 901,"Prueba", true, null);
		ArrayList<Habitacion> listaHabitacion = residencia.logica.datos.HabitacionBD.seleccionHabitaciones(base.getConn());

		for (Habitacion a : listaHabitacion) {

			if (a.getNumero()==901){
				
				assertEquals(a.getTipo(), "Prueba");
				assertEquals(a.isEstaOcupada(), true);
				assertEquals(a.getCodigoAlumnoHab(), null);
			}
			}
		}
	/**
	 * metodo que se ejecutara para compobar si el metodo EliminarHabitacion funciona correctamente
	 */
	@Test
	public void testEliminarHabitacion() throws SQLException {

		residencia.logica.datos.HabitacionBD.crearTablaHabitacion(base.getConn());
		residencia.logica.datos.HabitacionBD.borrarHabitacion(base.getConn(), 999);
		ArrayList<Habitacion> listaHabitacion = residencia.logica.datos.HabitacionBD.seleccionHabitaciones(base.getConn());
		
		for (Habitacion a : listaHabitacion) {

			if (a.getNumero()==999) {
				assertEquals(1, 0);
			}
			
		}
	}
}
		
