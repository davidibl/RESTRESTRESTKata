package de.lv1871.dms.Vertragsauskunft.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Beitrag {

	@ApiModelProperty("Der tatsächliche Netto Zahlbeitrag")
	private Double zahlbeitrag;
	@ApiModelProperty("Das aktuelle Zahlungsintervall")
	private Zahlweise zahlweise;

	public Double getZahlbeitrag() {
		return zahlbeitrag;
	}

	public void setZahlbeitrag(Double zahlbeitrag) {
		this.zahlbeitrag = zahlbeitrag;
	}

	public Zahlweise getZahlweise() {
		return zahlweise;
	}

	public void setZahlweise(Zahlweise zahlweise) {
		this.zahlweise = zahlweise;
	}
}
