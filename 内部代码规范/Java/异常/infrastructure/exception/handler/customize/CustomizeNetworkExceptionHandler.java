package lol.redScarf.yjdf.openapi.infrastructure.exception.handler.customize;

import lol.redScarf.yjdf.openapi.infrastructure.exception.NetworkException;
import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;
import org.springframework.stereotype.Component;

@Component
public class CustomizeNetworkExceptionHandler implements CustomizeExceptionHandler<NetworkException> {

    @Override
    public boolean supports(Throwable throwable) {
        return throwable instanceof NetworkException;
    }

    @Override
    public RestResponseBody handle(NetworkException exception) {
        return RestResponseBody.builder().code(exception.getCode()).message(exception.getMessage()).build();
    }
}
