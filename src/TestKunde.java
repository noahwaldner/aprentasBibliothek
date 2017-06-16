
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
	public void testAusleihe() throws Exception {
		if(ld.getAusgeliehen((long)1) == true) {
			
			try {
				assertTrue(ld.getAusgeliehen((long)1) == false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				ll.ausleihenRuckgabe((long)1, (long)1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertEquals("Medium wurde ausgeliehen", outContent.toString());
		} else {
			assertEquals("", outContent.toString());
		}
	}
	
	@Test
	public void testRueckgabe() throws Exception {
		if(ld.getAusgeliehen((long)1) == false) {
				
			try {
				assertTrue(ld.getAusgeliehen((long)1) == true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				ll.ausleihenRuckgabe((long)1, (long)1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertEquals("Medium wurde zurueckgegeben", outContent.toString());
		} else {
			assertEquals("", outContent.toString());
		}
	}
}
