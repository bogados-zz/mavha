package ar.com.mavha.test.mapper;

import org.springframework.context.MessageSource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Locale;
import java.util.stream.Collectors;

@Singleton
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
	@Inject
	private MessageSource messageSource;

	@Override
	public Response toResponse(ConstraintViolationException e) {
		return Response.status(Response.Status.BAD_REQUEST.getStatusCode())
						.entity(e.getConstraintViolations().stream().map(element -> this.messageSource.getMessage(element.getMessage(), null, Locale.getDefault())).collect(Collectors.toList())).build();
	}
}
