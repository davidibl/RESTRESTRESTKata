package de.lv1871.dms.Vertragsauskunft;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = App.class)
public class AppTest {

	@Test
	public void testGetVertrag() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testgetVertraegeKundennummerNull() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testGetJahresbeitrag() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testGetJahresbeitragWhenMonatlicheZahlweise() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testGetJahresbeitragWhenVertragGesperrt() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testGetJahresbeitragWhenVertragOhneZahlbeitrag() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testGetZahlbeitrag() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testGetZahlbeitragWhenVertragGesperrt() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testGetBeitrag() throws UnsupportedEncodingException, Exception {
	}

	@Test
	public void testGetBeitragWhenVertragGesperrt() throws UnsupportedEncodingException, Exception {
	}

}
