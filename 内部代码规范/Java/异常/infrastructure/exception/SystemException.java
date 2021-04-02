package lol.redScarf.yjdf.openapi.infrastructure.exception;

import lol.redScarf.yjdf.openapi.infrastructure.web.ResultCode;
import lombok.Getter;

public class SystemException extends RuntimeException {

    @Getter
    private ResultCode code;

    public SystemException() {
        this(ResultCode.UNKOWN_ERROR);
    }

    public SystemException(ResultCode code) {
        super(code.getMsg());
        this.code = code;
    }

    public SystemException(ResultCode code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(ResultCode code, Throwable cause) {
        super(code.getMsg(), cause);
        this.code = code;
    }

    public SystemException(ResultCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
