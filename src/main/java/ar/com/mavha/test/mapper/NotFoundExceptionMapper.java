package ar.com.mavha.test.mapper;

import org.springframework.context.MessageSource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Locale;
import java.util.stream.Collectors;

@Singleton
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
	@Inject
	private MessageSource messageSource;

	@Override
	public Response toResponse(NotFoundException e) {
		return Response.status(Response.Status.NOT_FOUND.getStatusCode())
						.entity(new CustomError("404", "The resource that you are trying to access was not found","")).build();
	}
}
