package residencia.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import residencia.visual.PaginaPrincipal;

public class PaginaPrincipalTest {

	
	
	@Before
	public void setUp() throws Exception{

		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void testComprobarSalones() {
		boolean resetearSalones = PaginaPrincipal.comprobarSalones();
		assertFalse(resetearSalones);
	}

}
