package lol.redScarf.yjdf.openapi.infrastructure.exception;

import lol.redScarf.yjdf.openapi.infrastructure.web.ResultCode;
import lombok.Getter;

public class ValidationException extends RuntimeException {

    @Getter
    private ResultCode code;

    public ValidationException() {
        this(ResultCode.DATA_VALID_ERROR);
    }

    public ValidationException(ResultCode code) {
        super(code.getMsg());
        this.code = code;
    }

    public ValidationException(ResultCode code, String message) {
        super(message);
        this.code = code;
    }

    public ValidationException(ResultCode code, Throwable cause) {
        super(code.getMsg(), cause);
        this.code = code;
    }

    public ValidationException(ResultCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
