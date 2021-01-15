package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.LoginEstudiante;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase LoginEstudiante
 * @author Gorka
 * @version 1.0
 */
public class LoginEstudianteTest {
	
	private String usuario;
	private String password;
	
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
	 * test que hace una prueba del metodo comprobarEstudiantes
	 */
	@Test
	public void testComprobarEstudianteAssert() throws Excepciones {
		usuario = "alejandro";
		password = "diaz19";
		boolean encontrado= LoginEstudiante.comprobarEstudiante(usuario, password);
		assertTrue(encontrado);
		
	}
	/**
	 * test que hace una prueba las excepciones del metodo comprobarEstudiantes
	 */
	@Test
	public void testComprobarEstudianteExcepcion(){
		try{
			usuario = "alsk";
			password = "sd";
			boolean encontrado= LoginEstudiante.comprobarEstudiante(usuario, password);
			fail();
		}catch(Excepciones e){
			
		}
		
		
	}

}
