package lol.redScarf.yjdf.openapi.infrastructure.exception;

import lol.redScarf.yjdf.openapi.infrastructure.web.ResultCode;
import lombok.Getter;

public class NetworkException extends RuntimeException {

    @Getter
    private ResultCode code;

    public NetworkException() {
        this(ResultCode.NETWORK_ERROR);
    }

    public NetworkException(ResultCode code) {
        super(code.getMsg());
        this.code = code;
    }

    public NetworkException(ResultCode code, String message) {
        super(message);
        this.code = code;
    }

    public NetworkException(ResultCode code, Throwable cause) {
        super(code.getMsg(), cause);
        this.code = code;
    }

    public NetworkException(ResultCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
