package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.RegistroEmpleado;

public class RegistroEmpleadoTest {
	private String usuario;
	private String funcion;
	private String DNI;
	private int indice;
	
	@Before
	public void setUp() throws Exception{
		usuario = null;
		funcion = null;
		DNI = null;
		indice = 0;
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void testComprobarEmpleadoAssert() throws Excepciones{
		usuario= "jsnkdn";
		boolean usuarioCorrecto= RegistroEmpleado.comprobarEmpleado(usuario);
		assertTrue(usuarioCorrecto);
	}
	
	@Test
	public void testComprobarEmpleadoExcepciones(){
		try{
			usuario= "jorge";
			boolean usuarioCorrecto= RegistroEmpleado.comprobarEmpleado(usuario);
			fail();
		}catch(Excepciones e){
			
		}
	}
	
	@Test
	public void testComprobarDNI(){
		DNI="79176752B";
		indice=0;
		boolean dniCorrecto= RegistroEmpleado.comprobarDNI(DNI, indice);
		assertTrue(dniCorrecto);
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
