package lol.redScarf.yjdf.openapi.infrastructure.exception.handler.customize;

import lol.redScarf.yjdf.openapi.infrastructure.exception.RepeatSubmitionException;
import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;
import org.springframework.stereotype.Component;

@Component
public class CustomizeRepeatSubmitionExceptionHandler implements CustomizeExceptionHandler<RepeatSubmitionException> {

    @Override
    public boolean supports(Throwable throwable) {
        return throwable instanceof RepeatSubmitionException;
    }

    @Override
    public RestResponseBody handle(RepeatSubmitionException exception) {
        return RestResponseBody.builder().code(exception.getCode()).message(exception.getMessage()).build();
    }
}
