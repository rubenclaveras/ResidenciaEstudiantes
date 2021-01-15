package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.RegistroEmpleado;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase RegistroEmpleado
 * @author Gorka
 * @version 1.0
 */
public class RegistroEmpleadoTest {
	private String usuario;
	private String funcion;
	private String DNI;
	private int indice;
	
	/**
	 * metodo que se ejecutara antes de cada test en el cual se dan valores a las variables previamente definidas y de esta manera antes de cada test se resetean
	 */
	@Before
	public void setUp() throws Exception{
		usuario = null;
		funcion = null;
		DNI = null;
		indice = 0;
		
	}
	/**
	 * metodo que se ejecutara despues de cada test
	 */
	@After
	public void tearDown() throws Exception{
		
	}
	/**
	 * test que hace una prueba del metodo comprobarEmpleado
	 */
	@Test
	public void testComprobarEmpleadoAssert() throws Excepciones{
		usuario= "jsnkdn";
		boolean usuarioCorrecto= RegistroEmpleado.comprobarEmpleado(usuario);
		assertTrue(usuarioCorrecto);
	}
	/**
	 * test que hace una prueba de las excepciones del metodo comprobarEmpleado
	 */	
	@Test
	public void testComprobarEmpleadoExcepciones(){
		try{
			usuario= "anton";
			boolean usuarioCorrecto= RegistroEmpleado.comprobarEmpleado(usuario);
			fail();
		}catch(Excepciones e){
			
		}
	}
	/**
	 * test que hace una prueba del metodo comprobarDNI
	 */
	@Test
	public void testComprobarDNI(){
		DNI="79176752B";
		indice=0;
		boolean dniCorrecto= RegistroEmpleado.comprobarDNI(DNI, indice);
		assertTrue(dniCorrecto);
	}
	
	/**
	 * test que hace una prueba del metodo calcularSalario
	 */	
	@Test
	public void testCalcularSalarioAssert() throws Excepciones {
		funcion = "Mantenimiento";
		int salario = RegistroEmpleado.calcularSalario(funcion);
		assertEquals(25000, salario);
		
	}
	
	

}
