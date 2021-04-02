package lol.redScarf.yjdf.openapi.infrastructure.exception.handler.customize;

import lol.redScarf.yjdf.openapi.infrastructure.exception.ParamentException;
import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;
import org.springframework.stereotype.Component;

@Component
public class CustomizeParamentExceptionHandler implements CustomizeExceptionHandler<ParamentException> {

    @Override
    public boolean supports(Throwable throwable) {
        return throwable instanceof ParamentException;
    }

    @Override
    public RestResponseBody handle(ParamentException exception) {
        return RestResponseBody.builder().code(exception.getCode()).message(exception.getMessage()).build();
    }
}
