package lol.redScarf.yjdf.openapi.infrastructure.exception.handler.customize;

import lol.redScarf.yjdf.openapi.infrastructure.exception.ValidationException;
import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;
import org.springframework.stereotype.Component;

@Component
public class CustomizeValidationExceptionHandler implements CustomizeExceptionHandler<ValidationException> {

    @Override
    public boolean supports(Throwable throwable) {
        return throwable instanceof ValidationException;
    }

    @Override
    public RestResponseBody handle(ValidationException exception) {
        return RestResponseBody.builder().code(exception.getCode()).message(exception.getMessage()).build();
    }
}
