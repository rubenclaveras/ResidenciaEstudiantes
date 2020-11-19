package residencia.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import residencia.clases.Trabajador;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase trabajador 
 * @author Gorka 
 * @version 1.0
 */
public class TrabajadorTest {
	Trabajador j1;
	Trabajador j2;
	
	/**
	 * metodo que se ejecutara lo primero en el cual se instancian dos objeto trabajador
	 */
	@Before
	public void setUp(){
		j1= new Trabajador("CX32","Pablo Fernandez Juarez", "19289384B", 53432, "mantenimiento","PabloFJ", "Pablo1234");
		j2= new Trabajador("CX33","Ruben Claveras", "17381728Z", 1233, "Limpieza","RubenC", "Ruben1234");
	}

	/**
	 * test del setter de salario
	 */
	@Test
	public void testSetSalario() {
		j1.setSalario(29001);
		j2.setSalario(19128);
		
		assertEquals(29001, j1.getSalario());
		assertEquals(19128, j2.getSalario());
	}
	/**
	 * test del metodo comprobarFuncion
	 */
	@Test
	public void testComprobarFuncion(){
		j1.setFuncion("Mantenimiento");
		j2.setFuncion("profesor");
		
		assertTrue(j1.comprobarFuncion());
		assertFalse(j2.comprobarFuncion());
		
	}
	/**
	 * test del metodo mostrarInformacion
	 */
	@Test
	public void testMostrarInformacion() {
		assertEquals("CX32;Pablo Fernandez Juarez;19289384B;mantenimiento;53432", j1.mostrarInformacion());
		
	}
}

