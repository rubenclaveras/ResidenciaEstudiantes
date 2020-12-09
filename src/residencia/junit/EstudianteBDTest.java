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

		base = new CrearBD("ResidenciaEstudiantes.db");
		base.createLink();
	}

	@After
	public void tearDown() throws Exception {
		base.closeLink();

	}


	@Test
	public void testInsertar() throws SQLException {

		residencia.logica.datos.EstudianteBD.crearTablaEstudiante(base.getConn());
		residencia.logica.datos.EstudianteBD.insertarEstudiante(base.getConn(), "ES0001","Nombre Prueba", "12345678A", 1000, 010, "nombre", "prueba");
		ArrayList<Estudiante> listaEstudiante = residencia.logica.datos.EstudianteBD.seleccionEstudiantes(base.getConn());

		for (Estudiante a : listaEstudiante) {

			if (a.getCodigoEstudiante().equals("ES0001")) {
			
			
				assertEquals(a.getNombre(), "Nombre Prueba");
				assertEquals(a.getDNI(), "12345678A");
				assertEquals(a.getCuotaAnual(), 1000);
				assertEquals(a.getHabitacion(), 010);
				assertEquals(a.getUsuario(), "nombre");
				assertEquals(a.getContrasenia(), "prueba");
			
			}
		}
	}
		
	}
