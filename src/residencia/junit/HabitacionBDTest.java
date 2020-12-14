package residencia.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.clases.Habitacion;
import residencia.logica.datos.CrearBD;

public class HabitacionBDTest {

	private CrearBD base = null;
	
	@Before
	public void setUp() throws Exception {

		base = new CrearBD("ResidenciaJunit.db");
		base.createLink();
	}

	@After
	public void tearDown() throws Exception {
		base.closeLink();

	}


	@Test
	public void testInsertar() throws SQLException {

		residencia.logica.datos.HabitacionBD.crearTablaHabitacion(base.getConn());
		residencia.logica.datos.HabitacionBD.insertarHabitacion(base.getConn(), 999,"Prueba", false, null);
		ArrayList<Habitacion> listaHabitacion = residencia.logica.datos.HabitacionBD.seleccionHabitaciones(base.getConn());

		for (Habitacion a : listaHabitacion) {

			
				assertEquals(a.getNumero(), 999);
				assertEquals(a.getTipo(), "Prueba");
				assertEquals(a.isEstaOcupada(), false);
				assertEquals(a.getCodigoAlumnoHab(), null);
			
			}
		}
	}
		
