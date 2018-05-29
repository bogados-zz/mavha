package ar.com.mavha.test.mapper;

import org.springframework.context.MessageSource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.nio.file.AccessDeniedException;

@Singleton
@Provider
public class AccessExceptionMapper implements ExceptionMapper<AccessDeniedException> {
	@Inject
	private MessageSource messageSource;

	@Override
	public Response toResponse(AccessDeniedException e) {
		return Response.status(Response.Status.NOT_FOUND.getStatusCode())
						.entity(new CustomError("404", "You are not authorized for access to this resource,","")).build();
	}
}
