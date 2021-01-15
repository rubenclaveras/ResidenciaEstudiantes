package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.visual.PaginaPrincipal;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase PaginaPrincipal
 * @author Gorka
 * @version 1.0
 */
public class PaginaPrincipalTest {

	
	/**
	 * metodo que se ejecutara antes de cada test
	 */
	@Before
	public void setUp() throws Exception{

		
	}
	/**
	 * metodo que se ejecutara despues de cada test
	 */
	@After
	public void tearDown() throws Exception{
		
	}
	/**
	 * test que hace una prueba del metodo comprobarSalones
	 */
	@Test
	public void testComprobarSalones() {
		boolean resetearSalones = PaginaPrincipal.comprobarSalones();
		assertFalse(resetearSalones);
	}

}
