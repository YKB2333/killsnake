package lol.redScarf.yjdf.openapi.infrastructure.exception.handler.customize;

import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;

public interface CustomizeExceptionHandler<T extends Throwable> {

    boolean supports(Throwable throwable);

    RestResponseBody handle(T exception);
}
