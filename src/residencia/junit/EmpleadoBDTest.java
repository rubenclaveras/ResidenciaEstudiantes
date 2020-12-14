package residencia.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.clases.Trabajador;
import residencia.logica.datos.CrearBD;

public class EmpleadoBDTest {

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
		
	}

