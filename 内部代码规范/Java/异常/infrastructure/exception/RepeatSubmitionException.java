package lol.redScarf.yjdf.openapi.infrastructure.exception;

import lol.redScarf.yjdf.openapi.infrastructure.web.ResultCode;
import lombok.Getter;

public class RepeatSubmitionException extends RuntimeException {

    @Getter
    private ResultCode code;

    public RepeatSubmitionException() {
        this(ResultCode.REPEAT_SUBMITION_ERROR);
    }

    public RepeatSubmitionException(ResultCode code) {
        super(code.getMsg());
        this.code = code;
    }

    public RepeatSubmitionException(ResultCode code, String message) {
        super(message);
        this.code = code;
    }

    public RepeatSubmitionException(ResultCode code, Throwable cause) {
        super(code.getMsg(), cause);
        this.code = code;
    }

    public RepeatSubmitionException(ResultCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
