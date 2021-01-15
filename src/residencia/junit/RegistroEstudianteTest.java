package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.RegistroEstudiante;


/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase RegistroEstudiante
 * @author Gorka
 * @version 1.0
 */
public class RegistroEstudianteTest {
	private String usuario;
	private String DNI;
	private int indice;
	private int numHabitacion;
	
	/**
	 * metodo que se ejecutara antes de cada test en el cual se dan valores a las variables previamente definidas y de esta manera antes de cada test se resetean
	 */
	@Before
	public void setUp() throws Exception{
		usuario = null;
		DNI = null;
		indice = 0;
		numHabitacion=0;
		
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
	public void testComprobarEstudianteAssert() throws Excepciones{
		usuario= "jsnkdn";
		boolean usuarioCorrecto= RegistroEstudiante.comprobarEstudiante(usuario);
		assertTrue(usuarioCorrecto);
	}
	/**
	 * test que hace una prueba a las excepciones del metodo comprobarSalones
	 */
	@Test
	public void testComprobarEstudianteExcepciones(){
		try{
			usuario= "sergio";
			boolean usuarioCorrecto= RegistroEstudiante.comprobarEstudiante(usuario);
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
		boolean dniCorrecto= RegistroEstudiante.comprobarDNI(DNI, indice);
		assertTrue(dniCorrecto);
	}
	/**
	 * test que hace una prueba del metodo asignarHabitaciones
	 */
	@Test
	public void testAsignarHabitacion() throws Excepciones{
		numHabitacion= RegistroEstudiante.asignarHabitacion();
		assertEquals(2, numHabitacion);
	}
	/**
	 * test que hace una prueba del metodo calcularCuotaa
	 */
	@Test
	public void testCalcularCuota() throws Excepciones{
		numHabitacion = 002;
		int cuota = RegistroEstudiante.calcularCuota(numHabitacion);
		assertEquals(4200,cuota);
		
	}
	
}	
	

