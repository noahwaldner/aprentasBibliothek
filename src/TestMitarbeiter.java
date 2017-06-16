import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data.LibraryDAO;
import dto.Kunde;
import dto.Medium;
import logic.LibraryLogic;

public class TestMitarbeiter {
	LibraryLogic logic = null;
	LibraryDAO dataAccess = null;

	@Before
	public void init() throws Exception {
		logic = new LibraryLogic();
		dataAccess = new LibraryDAO();
	}

	@Test
	public void testAddKunde() throws Exception {
		boolean ans = logic.addKunde(1992, 136, "Karsatsang", "Basel", "4057", "Muellheimerstrasse", "Namgyal");
		assertTrue(ans == true);
	}

	@Test
	public void testAddMedium() throws Exception {
		boolean ans = logic.addMedien((short) 10, "James", "Action", "45126544", "4512", "RawFist");
		assertTrue(ans == true);
	}

	@Test
	public void testChangeAdresse() throws Exception {
		boolean ans = logic.changeAdress("Hammerstrasse", 45, "4056", "Benningen", (long) 1);
		assertTrue(ans == true);
	}

	@Test
	public void testSearchKunde() throws Exception {
		long l = 1;
		String ans = logic.searchKunde(l);
		Kunde k = dataAccess.getKundeById(l);
		String ans2 = k.getString();
		assertEquals(ans, ans2);
		
	}
	
	@Test
	public void testSearchMedien() throws Exception {
		long l = 1;
		String ans = logic.searchMedien(l);
		Medium m = dataAccess.getMediumById(l);
		String ans2 = m.getString();
		assertEquals(ans, ans2);
	}
	
	@Test
	public void testAusleihenRuckgabeById() throws Exception {
		boolean ans = logic.ausleihenRuckgabe((long)1, (long)1);
		assertTrue(ans == false);
	}
	
	

}
