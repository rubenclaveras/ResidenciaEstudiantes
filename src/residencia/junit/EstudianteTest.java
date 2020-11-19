package residencia.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import residencia.clases.Estudiante;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase estudiante 
 * @author Gorka
 * @version 1.0
 */
public class EstudianteTest {
	Estudiante e1;
	Estudiante e2;
	
	/**
	 * metodo que se ejecutara lo primero en el cual se instancian dos objeto estudiante
	 */
	@Before
	public void setUp(){
		e1= new Estudiante("CX32","Pablo Fernandez Juarez", "19289384B", 53432, 102,"PabloFJ", "Pablo1234");
		e2= new Estudiante("CX33","Ruben Claveras", "17381728Z", 1233, 103,"RubenC", "Ruben1234");
	}
	
	/**
	 * test del getter del atributo habitacion
	 */
	@Test
	public void testGetHabitacion() {
		assertEquals(102,e1.getHabitacion());
		assertEquals(103,e2.getHabitacion());
	}

	/**
	 * test del metodo mostrarInformacion
	 */
	@Test
	public void testMostrarInformacion() {
		assertEquals("CX32;Pablo Fernandez Juarez;19289384B;53432", e1.mostrarInformacion());
		
	}

}

