package de.lv1871.dms.Vertragsauskunft.service;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 121313123L;

	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
