package de.lv1871.dms.Vertragsauskunft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Vertrag {

	@ApiModelProperty("Die Versicherungsnummer dieses Vertrags")
	private Long versicherungsnummer;
	@ApiModelProperty("Vollständige Beitragsinformationen")
	private Beitrag beitrag;
	@ApiModelProperty("Der Kurzbezeichner des Tarifs")
	private String tarif;
	@ApiModelProperty("Umfang beschreibt den gegenständlichen Umfang dieses Versicherungsvertrags")
	private Versicherungsumfang umfang;
	@ApiModelProperty(value = "Die garantierte monatliche Rente im Leistungsfall (Optional)", required = false)
	private Double renteMonatlich;
	@ApiModelProperty(value = "Die garantierte Versicherungssumme im Leistungsfall (Optional)", required = false)
	private Double versicherungssumme;
	@ApiModelProperty("Der aktuelle Vertragsstatus")
	private Vertragsstatus status;
	// Kan nur zwei Werte enthalten muss aber ein String sein ('Toller Vertrag'
	// und 'Prima Vertrag')
	@ApiModelProperty(value = "Die Vertragsart", allowableValues = "Toller Vertrag, Prima Vertrag")
	private String vertragsart;

	public Long getVersicherungsnummer() {
		return versicherungsnummer;
	}

	public void setVersicherungsnummer(Long versicherungsnummer) {
		this.versicherungsnummer = versicherungsnummer;
	}

	public Beitrag getBeitrag() {
		return beitrag;
	}

	public void setBeitrag(Beitrag beitrag) {
		this.beitrag = beitrag;
	}

	public String getTarif() {
		return tarif;
	}

	public void setTarif(String tarif) {
		this.tarif = tarif;
	}

	public Versicherungsumfang getUmfang() {
		return umfang;
	}

	public void setUmfang(Versicherungsumfang umfang) {
		this.umfang = umfang;
	}

	public Double getRenteMonatlich() {
		return renteMonatlich;
	}

	public void setRenteMonatlich(Double renteMonatlich) {
		this.renteMonatlich = renteMonatlich;
	}

	public Double getVersicherungssumme() {
		return versicherungssumme;
	}

	public void setVersicherungssumme(Double versicherungssumme) {
		this.versicherungssumme = versicherungssumme;
	}

	public Vertragsstatus getStatus() {
		return status;
	}

	public void setStatus(Vertragsstatus status) {
		this.status = status;
	}

	public String getVertragsart() {
		return vertragsart;
	}

	public void setVertragsart(String vertragsart) {
		this.vertragsart = vertragsart;
	}
}
