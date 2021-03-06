package de.lv1871.dms.Vertragsauskunft.service;

import static de.lv1871.dms.Vertragsauskunft.operation.Calculator.multiplyWith12;
import static de.lv1871.dms.Vertragsauskunft.operation.Lambda.doTransformIf;
import static de.lv1871.dms.Vertragsauskunft.operation.Lambda.equal;
import static de.lv1871.dms.Vertragsauskunft.operation.Lambda.isPresent;
import static de.lv1871.dms.Vertragsauskunft.operation.Lambda.notEqual;
import static de.lv1871.dms.Vertragsauskunft.operation.Lambda.orThrow;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.lv1871.dms.Vertragsauskunft.data.Kundenrepository;
import de.lv1871.dms.Vertragsauskunft.data.Vertragsrepository;
import de.lv1871.dms.Vertragsauskunft.model.Beitrag;
import de.lv1871.dms.Vertragsauskunft.model.Kunde;
import de.lv1871.dms.Vertragsauskunft.model.Vertrag;
import de.lv1871.dms.Vertragsauskunft.model.Vertragsstatus;
import de.lv1871.dms.Vertragsauskunft.model.Zahlweise;

@Service
public class VertragService {

	@Autowired
	private Kundenrepository kundenRepo;

	@Autowired
	private Vertragsrepository vertragRepo;

	public List<Vertrag> getVertraegeZuKundennummer(Long kundennummer) {

		// @formatter:off
		return Arrays.asList(kundennummer)
			.stream()
			.map(kundenRepo::getKunde)
			.map(orThrow(notFoundException.apply("Der Kunde konnte nicht gefunden werden")))
			.map(Kunde::getVertraege)
			.flatMap(v -> v.stream())
			.map(vertragRepo::getVertrag)
			.filter(Optional::isPresent)
			.map(Optional::get)
			.filter(vertragGueltig)
			.collect(Collectors.toList());
		// @formatter:on
	}

	public Beitrag getBeitrag(Long versicherungsnummer) {
		return getGueltigenBeitrag(versicherungsnummer).orElse(null);
	}

	public Double getZahlbeitrag(Long versicherungsnummer) {
		// @formatter:off
		return getGueltigenBeitrag(versicherungsnummer)
				.map(Beitrag::getZahlbeitrag)
				.orElseThrow(notFoundException.apply("Beitrag wurde nicht gefunden"));
		// @formatter:on
	}

	public Double getZahlbeitragJahr(Long versicherungsnummer) {
		// @formatter:off
		return getGueltigenBeitrag(versicherungsnummer)
				.filter(isPresent(Beitrag::getZahlbeitrag))
				.map(doTransformIf(isMonatlicheZahlweise,
									Beitrag::setZahlbeitrag,
									multiplyWith12(),
									Beitrag::getZahlbeitrag))
				.map(Beitrag::getZahlbeitrag)
				.orElseThrow(badRequestException.apply("Fehler bei der Verarbeitung"));
		// @formatter:on
	}

	private Optional<Beitrag> getGueltigenBeitrag(Long versicherungsnummer) {
		// @formatter:off
		return vertragRepo
			.getVertrag(versicherungsnummer)
			.filter(vertragGueltig)
			.map(Vertrag::getBeitrag);
		// @formatter:on
	}

	private Function<String, Supplier<InternalServerErrorException>> badRequestException = message -> () -> new InternalServerErrorException(
			message);
	private Function<String, Supplier<ResourceNotFoundException>> notFoundException = message -> () -> new ResourceNotFoundException(
			message);
	private Predicate<Beitrag> isMonatlicheZahlweise = equal(Beitrag::getZahlweise, () -> Zahlweise.MONATLICH);
	private Predicate<Vertrag> vertragGueltig = notEqual(Vertrag::getStatus, () -> Vertragsstatus.GESPERRT);

}
