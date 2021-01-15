package residencia.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.visual.OpcionesAvanzadasDirector;

/**
 * Clase junit test case que va a comprobar que funcionen correctamente los metodos de la clase OpcionesAvanzadas
 * @author Gorka
 * @version 1.0
 */
public class OpcionesAvanzadasDirectorTest {
	
	
	ArrayList <Integer> lista = new ArrayList <Integer>();
	
	/**
	 * metodo que se ejecutara antes de cada test en el cual se añaden datos al arrayList de tipo Integer
	 */
	@Before
	public void setUp (){
		System.out.println("Comienzo del test");
		lista.add(4);
		lista.add(6);
		lista.add(2);
		lista.add(5);
	}
	/**
	 * metodo que se ejecutara despues de cada test
	 */
	@After
	public void tearDown (){
		System.out.println("Fin del test");
	}
	/**
	 * test que hace una prueba del metodo quicksort
	 */
	@Test
	public void testQuicksort (){
		int esperado = 2;
		ArrayList <Integer> lista2 = OpcionesAvanzadasDirector.quicksortOrden(lista);
		int real = lista2.get(0);
		assertEquals (esperado, real);
	}
	/**
	 * test que hace una prueba del metodo mergesort
	 */
	@Test
	public void testMergesort (){
		int esperado = 2;
		ArrayList <Integer> lista2 = OpcionesAvanzadasDirector.mergesort(lista);
		int real = lista2.get(0);
		assertEquals (esperado, real);
	}

}
