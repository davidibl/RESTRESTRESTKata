package de.lv1871.dms.Vertragsauskunft.data;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.lv1871.dms.Vertragsauskunft.model.Kunde;

@Service
public class Kundenrepository {

	private ObjectMapper mapper = new ObjectMapper();

	public Optional<Kunde> getKunde(Long kundennummer) {
		try {
			return Optional.ofNullable(mapper.readValue(new File(String.format("%s.json", kundennummer)), Kunde.class));
		} catch (IOException e) {
			return Optional.empty();
		}
	}
}
