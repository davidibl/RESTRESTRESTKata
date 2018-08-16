package de.lv1871.dms.Vertragsauskunft.modeltest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Vertrag {

	private Long versicherungsnummer;
	private Beitrag beitrag;
	private String tarif;
	private Versicherungsumfang umfang;
	private Double renteMonatlich;
	private Double versicherungssumme;
	private Vertragsstatus status;
	// Kan nur zwei Werte enthalten muss aber ein String sein ('Toller Vertrag'
	// und 'Prima Vertrag')
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
