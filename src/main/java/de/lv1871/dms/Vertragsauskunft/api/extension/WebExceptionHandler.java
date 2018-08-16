package de.lv1871.dms.Vertragsauskunft.api.extension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import de.lv1871.dms.Vertragsauskunft.service.InternalServerErrorException;

@ControllerAdvice
public class WebExceptionHandler extends AbstractWebExceptionHandler {

	@ExceptionHandler({ RuntimeException.class })
	protected ResponseEntity<Object> handleUnknownExceptions(RuntimeException exception, WebRequest request) {

		return handleDefaultError(exception, HttpStatus.BAD_REQUEST, exception.getMessage(), request);
	}

	@ExceptionHandler({ de.lv1871.dms.Vertragsauskunft.service.ResourceNotFoundException.class })
	protected ResponseEntity<Object> handleNotAuthorizedException(
			de.lv1871.dms.Vertragsauskunft.service.ResourceNotFoundException exception, WebRequest request) {

		return handleDefaultError(exception, HttpStatus.NOT_FOUND, exception.getMessage(), request);
	}

	@ExceptionHandler({ InternalServerErrorException.class })
	protected ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException exception,
			WebRequest request) {

		return handleDefaultError(exception, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), request);
	}

}
