package ar.com.mavha.test.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public abstract class BusinessException extends RuntimeException {
	private String code;
	private String messageCode;
	private String[] messageArgs;
	private String descriptionCode;
	private String[] descriptionArgs;
	private HttpStatus httpStatus;
}
