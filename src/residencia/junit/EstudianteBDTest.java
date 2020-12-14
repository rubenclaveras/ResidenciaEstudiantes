package residencia.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.clases.Estudiante;
import residencia.logica.datos.CrearBD;


public class EstudianteBDTest {

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
	public void testInsertarEstudiante() throws SQLException {

		residencia.logica.datos.EstudianteBD.crearTablaEstudiante(base.getConn());
		residencia.logica.datos.EstudianteBD.insertarEstudiante(base.getConn(), "ES0400","Nombre Prueba", "12345678A", 9999, 999, "nombre", "prueba");
		ArrayList<Estudiante> listaEstudiante = residencia.logica.datos.EstudianteBD.seleccionEstudiantes(base.getConn());

		for (Estudiante a : listaEstudiante) {

			if (a.getCodigoEstudiante().equals("ES0400")) {
			
				assertEquals(a.getNombre(), "Nombre Prueba");
				assertEquals(a.getDNI(), "12345678A");
				assertEquals(a.getCuotaAnual(), 9999);
				assertEquals(a.getHabitacion(), 999);
				assertEquals(a.getUsuario(), "nombre");
				assertEquals(a.getContrasenia(), "prueba");
				
			
			}
		}
	}
	@Test
	public void testSeleccionarEstudiante() throws SQLException {

		residencia.logica.datos.EstudianteBD.crearTablaEstudiante(base.getConn());
		residencia.logica.datos.EstudianteBD.insertarEstudiante(base.getConn(), "ES0500","Nombre Prueba", "12345678A", 9999, 999, "nombre", "prueba");
		ArrayList<Estudiante> listaEstudiante = residencia.logica.datos.EstudianteBD.seleccionEstudiantes(base.getConn());

		for (Estudiante a : listaEstudiante) {

			if (a.getCodigoEstudiante().equals("ES0500")) {
			
				assertEquals(a.getNombre(), "Nombre Prueba");
				assertEquals(a.getDNI(), "12345678A");
				assertEquals(a.getCuotaAnual(), 9999);
				assertEquals(a.getHabitacion(), 999);
				assertEquals(a.getUsuario(), "nombre");
				assertEquals(a.getContrasenia(), "prueba");
				
			
			}
		}

	}
	@Test
	public void testEliminarEstudiante() throws SQLException {

		residencia.logica.datos.EstudianteBD.borrarEstudiante(base.getConn(), "ES0600");
		ArrayList<Estudiante> listaEstudiante = residencia.logica.datos.EstudianteBD.seleccionEstudiantes(base.getConn());
		
		for (Estudiante a : listaEstudiante) {

			if (a.getCodigoEstudiante().equals("ES0600")) {
				assertEquals(1, 0);
			}
			
		}
	}
}