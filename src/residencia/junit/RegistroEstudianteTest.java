package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.excepciones.Excepciones;
import residencia.visual.RegistroEstudiante;


public class RegistroEstudianteTest {
	private String usuario;
	private String DNI;
	private int indice;
	private int numHabitacion;
	
	@Before
	public void setUp() throws Exception{
		usuario = null;
		DNI = null;
		indice = 0;
		numHabitacion=0;
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void testComprobarEstudianteAssert() throws Excepciones{
		usuario= "jsnkdn";
		boolean usuarioCorrecto= RegistroEstudiante.comprobarEstudiante(usuario);
		assertTrue(usuarioCorrecto);
	}
	
	@Test
	public void testComprobarEstudianteExcepciones(){
		try{
			usuario= "sergio";
			boolean usuarioCorrecto= RegistroEstudiante.comprobarEstudiante(usuario);
			fail();
		}catch(Excepciones e){
			
		}
	}
	
	@Test
	public void testComprobarDNI(){
		DNI="79176752B";
		indice=0;
		boolean dniCorrecto= RegistroEstudiante.comprobarDNI(DNI, indice);
		assertTrue(dniCorrecto);
	}
	
	@Test
	public void testAsignarHabitacion() throws Excepciones{
		numHabitacion= RegistroEstudiante.asignarHabitacion();
		assertEquals(002, numHabitacion);
	}
	
	@Test
	public void testCalcularSalarioAssert() throws Excepciones{
		numHabitacion = 002;
		int salario = RegistroEstudiante.calcularCuota(numHabitacion);
		assertEquals(4200,salario);
		
	}
	
	@Test
	public void testCalcularSalarioExcepcion(){
		try{
			numHabitacion= 026;
			int salario = RegistroEstudiante.calcularCuota(numHabitacion);
			fail();
		}catch(Excepciones e){
			
		}
	
		
	}
	
}	
	

