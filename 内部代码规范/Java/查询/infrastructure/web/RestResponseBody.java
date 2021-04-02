package lol.redScarf.yjdf.openapi.infrastructure.web;

import lol.redScarf.yjdf.openapi.infrastructure.exception.NetworkException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
public class RestResponseBody<T> implements Serializable {

    /**
     * 构造函数私有化是要控制响应体必须用ResultCode枚举返回响应码
     */
    private RestResponseBody() {
    }

    private String message;
    private Integer resultCode;

    private ResultCode code = ResultCode.SUCCESS;

    private T result;

    public boolean isSuccess() {
        if (ResultCode.SUCCESS.equals(code)) {
            return true;
        }
        if (resultCode != null && resultCode.equals(ResultCode.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }

    public void isSuccessThrowException() {
        if (!isSuccess()) {
            if (this.code != null && !this.code.equals(ResultCode.INTERNAL_SERVER_ERROR)) {
                throw new NetworkException(this.code, this.message);
            }
            throw new NetworkException(ResultCode.NETWORK_ERROR, this.message);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T> {
        private RestResponseBody<T> restResponseBody;

        public Builder() {
            this.restResponseBody = new RestResponseBody();
        }

        public Builder code(ResultCode code) {
            this.restResponseBody.code = code;
            return this;
        }

        public Builder message(String message) {
            this.restResponseBody.message = message;
            return this;
        }

        public Builder result(T result) {
            this.restResponseBody.result = result;
            return this;
        }

        public RestResponseBody<T> build() {
            if (StringUtils.isBlank(this.restResponseBody.message)) {
                this.restResponseBody.message = this.restResponseBody.code.msg;
            }
            this.restResponseBody.resultCode = this.restResponseBody.code.code;
            return this.restResponseBody;
        }
    }
}