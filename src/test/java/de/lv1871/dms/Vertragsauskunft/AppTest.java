package de.lv1871.dms.Vertragsauskunft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.lv1871.dms.Vertragsauskunft.modeltest.Vertrag;
import de.lv1871.dms.Vertragsauskunft.modeltest.Zahlweise;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = App.class)
public class AppTest {

	private static String BASE_URL = "http://localhost:11315";

	@Test
	public void testGetVertrage() throws UnsupportedEncodingException, Exception {

		VertragClient vertragClient = createClient(VertragClient.class);
		List<Vertrag> vertraege = vertragClient.getVertraege(511718L);
		assertNotNull(vertraege);
		assertEquals(2, vertraege.size());
	}

	@Test
	public void testGetVertraegeAndAssertZahlbeitrag() throws UnsupportedEncodingException, Exception {

		VertragClient vertragClient = createClient(VertragClient.class);
		List<Vertrag> vertraege = vertragClient.getVertraege(511718L);
		vertraege.forEach(vertrag -> {
			assertEquals(new Double(102.45), vertrag.getBeitrag().getZahlbeitrag());
		});
	}

	@Test
	public void testGetVertraegeAndAssertZahlweise() throws UnsupportedEncodingException, Exception {

		VertragClient vertragClient = createClient(VertragClient.class);
		List<Vertrag> vertraege = vertragClient.getVertraege(511718L);
		long vertrageAnzahlZahlweiseMonatlich = vertraege.stream().map(Vertrag::getBeitrag)
				.filter(beitrag -> beitrag.getZahlweise() == Zahlweise.MONATLICH).count();
		long vertrageAnzahlZahlweiseJaehrlich = vertraege.stream().map(Vertrag::getBeitrag)
				.filter(beitrag -> beitrag.getZahlweise() == Zahlweise.JAEHRLICH).count();

		assertEquals(vertrageAnzahlZahlweiseJaehrlich, 1);
		assertEquals(vertrageAnzahlZahlweiseMonatlich, 1);
	}

	private <T> T createClient(Class<T> clazz) {
		ResteasyClient client = new ResteasyClientBuilder().connectionPoolSize(20).build();
		ResteasyWebTarget target = client.target(BASE_URL);
		return target.proxy(clazz);
	}

}
