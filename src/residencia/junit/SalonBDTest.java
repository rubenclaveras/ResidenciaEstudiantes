package residencia.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.clases.SalonComunitario;
import residencia.logica.datos.CrearBD;

public class SalonBDTest {

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
	public void testInsertarSalon() throws SQLException {

		residencia.logica.datos.SalonBD.crearTablaSalon(base.getConn());
		residencia.logica.datos.SalonBD.insertarSalon(base.getConn(), 4,"Prueba", true, "Prueba");
		ArrayList<SalonComunitario> listaSalon = residencia.logica.datos.SalonBD.seleccionSalones(base.getConn());

		for (SalonComunitario a : listaSalon) {

			if (a.getNumero()==4){
				
				assertEquals(a.getTipo(), "Prueba");
				assertEquals(a.isEstaReservada(), true);
				assertEquals(a.getCodigoAlumnoSalon(), "Prueba");
				
			}
			}
		}
	@Test
	public void testSeleccionarSalon() throws SQLException {

		residencia.logica.datos.SalonBD.crearTablaSalon(base.getConn());
		residencia.logica.datos.SalonBD.insertarSalon(base.getConn(), 990,"Prueba", false, "Prueba");
		ArrayList<SalonComunitario> listaSalon = residencia.logica.datos.SalonBD.seleccionSalones(base.getConn());

		for (SalonComunitario a : listaSalon) {

			if (a.getNumero()==990){
				
				assertEquals(a.getTipo(), "Prueba");
				assertEquals(a.isEstaReservada(), false);
				assertEquals(a.getCodigoAlumnoSalon(), "Prueba");
				
			
			}
		}
	}
	@Test
	public void testEliminarSalon() throws SQLException {

		residencia.logica.datos.SalonBD.crearTablaSalon(base.getConn());
		residencia.logica.datos.SalonBD.borrarSalon(base.getConn(), 999);
		ArrayList<SalonComunitario> listaSalon = residencia.logica.datos.SalonBD.seleccionSalones(base.getConn());
		
		for (SalonComunitario a : listaSalon) {

			if (a.getNumero()==999) {
				assertEquals(1, 0);
			}
			
		}
	}
}
		

