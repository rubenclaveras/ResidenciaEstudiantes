package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.RegistroEmpleado;

public class RegistroEmpleadoTest {
	private String usuario;
	private String password;
	private String funcion;
	
	@Before
	public void setUp() throws Exception{
		
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	
	@Test
	public void testCalcularSalarioAssert() throws Excepciones {
		funcion = "Mantenimiento";
		int salario = RegistroEmpleado.calcularSalario(funcion);
		assertEquals(25000, salario);
		
	}
	
	@Test
	public void testCalcularSalarioExcepciones(){
		try{
			funcion="msd";
			int salario =  RegistroEmpleado.calcularSalario(funcion);
			fail();
		}catch(Excepciones e){
			
		}
	}

}
