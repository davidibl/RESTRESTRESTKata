package de.lv1871.dms.Vertragsauskunft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.lv1871.dms.Vertragsauskunft.model.Vertrag;
import de.lv1871.dms.Vertragsauskunft.service.VertragService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@CrossOrigin
public class VertragResource {

	@Autowired
	private VertragService service;

	@RequestMapping(path = "/api/vertrag", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@formatter:off
	@ApiOperation(value = "Liefert eine Liste aller Verträge eines Kunden", notes = "Derzeit nur für Kundennummer 511718")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Erfolgreich", response = Vertrag[].class),
			@ApiResponse(code = 404, message = "Vertrag nicht gefunden", response = WebError.class),
			@ApiResponse(code = 500, message = "Interner Fehler dieses REST Services.", response = WebError.class)
		})
//	@formatter:on
	public @ResponseBody List<Vertrag> getVertraege(
			@ApiParam(name = "kundennummer", required = true) @RequestParam(name = "kundennummer") Long kundennummer) {
		return service.getVertraegeZuKundennummer(kundennummer);
	}

	@RequestMapping(path = "/api/vertrag/{versicherungsnummer}/beitrag/zahlbeitrag", method = RequestMethod.GET)
//	@formatter:off
	@ApiOperation(value = "Liefert den tatsächlichen Netto Beitrag des angegebenen Vertrags", notes = "Derzeit nur für Kundennummer 511718")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Erfolgreich", response = Double.class),
			@ApiResponse(code = 404, message = "Vertrag nicht gefunden", response = WebError.class),
			@ApiResponse(code = 500, message = "Interner Fehler dieses REST Services.", response = WebError.class)
		})
//	@formatter:on
	public @ResponseBody Double getZahlbeitrag(
			@ApiParam(name = "versicherungsnummer", required = true) @PathVariable(name = "versicherungsnummer") Long versicherungsnummer) {
		return service.getZahlbeitrag(versicherungsnummer);
	}

	@RequestMapping(path = "/api/vertrag/{versicherungsnummer}/jahresbeitrag/zahlbeitrag", method = RequestMethod.GET)
//	@formatter:off
	@ApiOperation(value = "Liefert den tatsächlichen Netto Jahresbeitrag des angegebenen Vertrags", notes = "Derzeit nur für Kundennummer 511718")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Erfolgreich", response = Double.class),
			@ApiResponse(code = 404, message = "Vertrag nicht gefunden", response = WebError.class),
			@ApiResponse(code = 500, message = "Interner Fehler dieses REST Services.", response = WebError.class)
		})
//	@formatter:on
	public @ResponseBody Double getZahlbeitragJahr(
			@ApiParam(name = "versicherungsnummer", required = true) @PathVariable(name = "versicherungsnummer") Long versicherungsnummer) {
		return service.getZahlbeitragJahr(versicherungsnummer);
	}
}
