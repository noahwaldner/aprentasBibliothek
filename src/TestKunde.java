
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

import data.LibraryDAO;
import logic.LibraryLogic;

public class TestKunde {

	LibraryLogic ll = null;
	LibraryDAO ld = null;
	boolean check;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void init() {
		try {
			ll = new LibraryLogic();
			ld = new LibraryDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRueckgabe() throws Exception {
		if(ld.getAusgeliehen((long)1) == true) {
			
			ll.ausleihenRuckgabe((long)1, (long)1);
			assertTrue(ld.getAusgeliehen((long)1) == false);
	
		} else {
			assertTrue(ld.getAusgeliehen((long)1) == false);
		}
	}
	
	@Test
	public void testAusleihen() throws Exception {
		if(ld.getAusgeliehen((long)1) == false) {
				
			ll.ausleihenRuckgabe((long)1, (long)1);
			assertTrue(ld.getAusgeliehen((long)1) == true);

		} else {
			
			assertTrue(ld.getAusgeliehen((long)1) == true);
		}
	}
}
