package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.logica.datos.CrearBD;

public class CrearBDTest {
	
	private CrearBD prueba;

	@Before
	public void setUp() throws Exception {
		
		prueba=new CrearBD("Prueba.bd");
		prueba.crearBaseDatos("Prueba.bd");
		prueba.createLink();
		
	}

	@Test
	public void testCrearBD() {
		
		String esperado="residencia.logica.datos.CrearBD@512ddf17";
		
		assertEquals(esperado, prueba.toString());
	}
	
	@After
	public void tearDown() throws Exception {
		prueba.closeLink();
	}

}
