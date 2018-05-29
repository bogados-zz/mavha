package ar.com.mavha.test.mapper;


import ar.com.mavha.test.exception.BusinessException;
import org.springframework.context.MessageSource;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Locale;

@Singleton
@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

	@Inject
	private MessageSource messageSource;

	@Override
	public Response toResponse(BusinessException excpetion) {
		return Response.status(excpetion.getHttpStatus().value())
				.entity(new CustomError(excpetion.getCode(),
						messageSource.getMessage(excpetion.getMessageCode(), excpetion.getMessageArgs(), Locale.getDefault()),
						messageSource.getMessage(excpetion.getDescriptionCode(), excpetion.getDescriptionArgs(), Locale.getDefault())))
				.build();
	}
}
