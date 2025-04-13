package com.musinsa.coord.common.error.exception;

import com.musinsa.coord.common.error.ErrorResponse;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorResponse errorResponse;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorResponse = ErrorResponse.of(errorCode);
    }

    public BusinessException(ErrorCode errorCode, String additionalMessage) {
        super(errorCode.getMessage());
        this.errorResponse = ErrorResponse.of(errorCode, additionalMessage);
    }

}
