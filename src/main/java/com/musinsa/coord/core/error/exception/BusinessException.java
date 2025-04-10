package com.musinsa.coord.core.error.exception;

import com.musinsa.coord.core.error.ErrorResponse;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorResponse errorResponse;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorResponse = ErrorResponse.of(errorCode);
    }

}
