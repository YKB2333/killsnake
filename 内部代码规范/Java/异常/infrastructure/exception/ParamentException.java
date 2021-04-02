package lol.redScarf.yjdf.openapi.infrastructure.exception;

import lol.redScarf.yjdf.openapi.infrastructure.web.ResultCode;
import lombok.Getter;

public class ParamentException extends RuntimeException {

    @Getter
    private ResultCode code;

    public ParamentException() {
        this(ResultCode.PARAMENT_ERROR);
    }

    public ParamentException(ResultCode code) {
        super(code.getMsg());
        this.code = code;
    }

    public ParamentException(ResultCode code, String message) {
        super(message);
        this.code = code;
    }

    public ParamentException(ResultCode code, Throwable cause) {
        super(code.getMsg(), cause);
        this.code = code;
    }

    public ParamentException(ResultCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
