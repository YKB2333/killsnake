package lol.redScarf.yjdf.openapi.infrastructure.exception.handler;

import lol.redScarf.yjdf.openapi.infrastructure.exception.handler.customize.CustomizeExceptionHandler;
import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;
import lol.redScarf.yjdf.openapi.infrastructure.web.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class OpenApiExceptionHandler {

    @Autowired
    private List<CustomizeExceptionHandler> exceptionHandlerList = new ArrayList<>();

    @ExceptionHandler(Throwable.class)
    public RestResponseBody handleError(Throwable e) {
        for (CustomizeExceptionHandler customizeExceptionHandler : exceptionHandlerList) {
            if (customizeExceptionHandler.supports(e)) {
                return customizeExceptionHandler.handle(e);
            }
        }
        return RestResponseBody.builder().code(ResultCode.UNKOWN_ERROR).build();
    }
}
