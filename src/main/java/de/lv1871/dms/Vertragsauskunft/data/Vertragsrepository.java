package de.lv1871.dms.Vertragsauskunft.data;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.lv1871.dms.Vertragsauskunft.model.Vertrag;

@Service
public class Vertragsrepository {

	private ObjectMapper mapper = new ObjectMapper();

	public Optional<Vertrag> getVertrag(Long versicherungsnummer) {
		try {
			return Optional.ofNullable(
					mapper.readValue(new File(String.format("%s.json", versicherungsnummer)), Vertrag.class));
		} catch (IOException e) {
			return Optional.empty();
		}
	}
}
