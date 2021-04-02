package lol.redScarf.yjdf.openapi.infrastructure.exception.handler;

import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;
import lol.redScarf.yjdf.openapi.infrastructure.web.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"lol.redScarf.yjdf.openapi.web.api"})
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public RestResponseBody handleError(Throwable e) {
        return RestResponseBody.builder().code(ResultCode.INTERNAL_SERVER_ERROR).message(e.getMessage()).build();
    }
}
