package de.lv1871.dms.Vertragsauskunft.api.documentation;

public enum ApiKeyHeadername {

	DEFAULTHEADERNAME("apikey");

	private final String headername;

	private ApiKeyHeadername(String headername) {
		this.headername = headername;
	}

	public String getHeadername() {
		return headername;
	}

}
