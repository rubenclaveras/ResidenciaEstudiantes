package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.MenuEmpleado;

public class MenuEmpleadoTest {
	private String usuario;
	private String password;
	
	
	@Before
	public void setUp() throws Exception{
		usuario= null;
		password = null;
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	
	@Test
	public void testObtenerOcupacionAssert() throws Excepciones {
		usuario= "blanca";
		password= "gon12";
		String ocupacion = MenuEmpleado.obtenerOcupacion(usuario, password);
		assertEquals("Mantenimiento", ocupacion);
		
	}
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
