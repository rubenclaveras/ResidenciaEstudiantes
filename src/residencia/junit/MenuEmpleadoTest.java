package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.MenuEmpleado;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase MenuEmpleado
 * @author Gorka
 * @version 1.0
 */
public class MenuEmpleadoTest {
	private String usuario;
	private String password;
	
	/**
	 * metodo que se ejecutara antes de cada test en el cual se dan valores a las variables previamente definidas y de esta manera antes de cada test se resetean
	 */
	@Before
	public void setUp() throws Exception{
		usuario= null;
		password = null;
		
	}
	/**
	 * metodo que se ejecutara despues de cada test
	 */
	@After
	public void tearDown() throws Exception{
		
	}
	
	/**
	 * test que hace una prueba del metodo obtenerOcupacion
	 */
	@Test
	public void testObtenerOcupacionAssert() throws Excepciones {
		usuario= "blanca";
		password= "gon12";
		String ocupacion = MenuEmpleado.obtenerOcupacion(usuario, password);
		assertEquals("Mantenimiento", ocupacion);
		
	}
	/**
	 * test que hace una prueba de las excepciones del metodo obtenerOcupacion
	 */
	@Test 
	public void testObtenerOcupacionExcepciones(){
		try{
			usuario= "sd";
			password= "fs";
			String ocupacion = MenuEmpleado.obtenerOcupacion(usuario, password);
			fail();
		}catch(Excepciones e){
			
		}
	}

}
