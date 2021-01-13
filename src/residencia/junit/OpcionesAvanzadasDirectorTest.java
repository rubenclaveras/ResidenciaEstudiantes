package residencia.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.visual.OpcionesAvanzadasDirector;

public class OpcionesAvanzadasDirectorTest {
	
	
	ArrayList <Integer> lista = new ArrayList <Integer>();
	
	
	@Before
	public void setUp (){
		System.out.println("Comienzo del test");
		lista.add(4);
		lista.add(6);
		lista.add(2);
		lista.add(5);
	}
	@After
	public void tearDown (){
		System.out.println("Fin del test");
	}
	
	@Test
	public void testQuicksort (){
		int esperado = 2;
		ArrayList <Integer> lista2 = OpcionesAvanzadasDirector.quicksortOrden(lista);
		int real = lista2.get(0);
		assertEquals (esperado, real);
	}
	@Test
	public void testMergesort (){
		int esperado = 2;
		ArrayList <Integer> lista2 = OpcionesAvanzadasDirector.mergesort(lista);
		int real = lista2.get(0);
		assertEquals (esperado, real);
	}

}
