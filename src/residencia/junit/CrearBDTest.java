package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.logica.datos.CrearBD;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase CrearBD
 * @author Ruben
 * @version 1.0
 */
public class CrearBDTest {
	
	private CrearBD prueba;

	/**
	 * metodo que se ejecutara antes de cada test en el cual se conecta con la base de datos Junit
	 */
	@Before
	public void setUp() throws Exception {
		
		prueba=new CrearBD("Prueba.bd");
		prueba.crearBaseDatos("Prueba.bd");
		prueba.createLink();
		
	}

	/**
	 * metodo que se ejecutara para compobar si el metodo CrearBD funciona correctamente
	 */
	@Test
	public void testCrearBD() {
		
		String esperado="residencia.logica.datos.CrearBD@512ddf17";
		
		assertEquals(esperado, prueba.toString());
	}
	
	/**
	 * metodo que se ejecutara al final de cada test en el cual se cierra la conexion con la base de datos Junit
	 */
	@After
	public void tearDown() throws Exception {
		prueba.closeLink();
	}

}
