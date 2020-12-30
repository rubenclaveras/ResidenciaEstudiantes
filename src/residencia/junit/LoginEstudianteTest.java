package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.LoginEstudiante;

public class LoginEstudianteTest {
	
	private String usuario;
	private String password;
	
	@Before
	public void setUp() throws Exception{

		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	

	@Test
	public void testComprobarEstudianteAssert() throws Excepciones {
		usuario = "alejandro";
		password = "diaz19";
		boolean encontrado= LoginEstudiante.comprobarEstudiante(usuario, password);
		assertTrue(encontrado);
		
	}
	
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
