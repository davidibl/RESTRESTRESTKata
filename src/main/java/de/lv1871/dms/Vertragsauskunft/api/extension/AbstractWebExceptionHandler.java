package de.lv1871.dms.Vertragsauskunft.api.extension;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.lv1871.dms.Vertragsauskunft.api.WebError;

public class AbstractWebExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleDefaultError(Exception exception, HttpStatus status, String message,
			WebRequest request) {

		WebError error = new WebError();
		error.setMessage(message);
		error.setStatus(status.value());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return handleExceptionInternal(exception, error, headers, status, request);
	}

}
