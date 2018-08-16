package de.lv1871.dms.Vertragsauskunft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.lv1871.dms.Vertragsauskunft.model.Beitrag;
import de.lv1871.dms.Vertragsauskunft.model.Vertrag;
import de.lv1871.dms.Vertragsauskunft.service.InternalServerErrorException;
import de.lv1871.dms.Vertragsauskunft.service.ResourceNotFoundException;
import de.lv1871.dms.Vertragsauskunft.service.VertragService;

@Controller
@CrossOrigin
public class VertragResource {

	@Autowired
	private VertragService service;

	@RequestMapping(path = "/api/vertrag", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Vertrag>> getVertraege(
			@RequestParam(name = "kundennummer") Long kundennummer) {
		try {
			return ResponseEntity.ok(service.getVertraegeZuKundennummer(kundennummer));
		} catch (ResourceNotFoundException exception) {
			return ResponseEntity.notFound().build();
		} catch (InternalServerErrorException exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(path = "/api/vertrag/{versicherungsnummer}/beitrag", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Beitrag> getBeitrag(
			@PathVariable(name = "versicherungsnummer") Long versicherungsnummer) {
		try {
			// @formatter:off
			Beitrag beitrag = service.getBeitrag(versicherungsnummer);
			if (beitrag != null) {
				return ResponseEntity.ok(beitrag);
			}
			return ResponseEntity.noContent().build();
			// @formatter:on
		} catch (ResourceNotFoundException exception) {
			return ResponseEntity.notFound().build();
		} catch (InternalServerErrorException exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(path = "/api/vertrag/{versicherungsnummer}/beitrag/zahlbeitrag", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Double> getZahlbeitrag(
			@PathVariable(name = "versicherungsnummer") Long versicherungsnummer) {
		try {
			return ResponseEntity.ok(service.getZahlbeitrag(versicherungsnummer));
		} catch (ResourceNotFoundException exception) {
			return ResponseEntity.notFound().build();
		} catch (InternalServerErrorException exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(path = "/api/vertrag/{versicherungsnummer}/jahresbeitrag/zahlbeitrag", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Double> getZahlbeitragJahr(
			@PathVariable(name = "versicherungsnummer") Long versicherungsnummer) {
		try {
			return ResponseEntity.ok(service.getZahlbeitragJahr(versicherungsnummer));
		} catch (ResourceNotFoundException exception) {
			return ResponseEntity.notFound().build();
		} catch (InternalServerErrorException exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
