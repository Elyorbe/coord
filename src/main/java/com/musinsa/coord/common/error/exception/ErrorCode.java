package com.musinsa.coord.common.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C001", "Method not allowed"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C002", "Internal server error"),
    UNPROCESSABLE_REQUEST(HttpStatus.UNPROCESSABLE_ENTITY,"C003" ,"Unprocessable request"),
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "C004", "Resource already exists"),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C005", "Invalid input value"),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C005", " Invalid type value"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "C006", "Resource doesn't exist"),
    NO_HANDLER_FOUND(HttpStatus.NOT_FOUND, "C007", "No handler found for the request"),
    DATA_INTEGRITY_VIOLATION(HttpStatus.BAD_REQUEST, "C008", "Data integrity violated"),

    DUPLICATE_PRODUCT(HttpStatus.CONFLICT, "D001", "Product with same brand and category already exists"),
    REFERENCED_RESOURCE_NOT_EXISTS(HttpStatus.BAD_REQUEST, "D002", "Referenced resource not exists"),
    BRAND_HAS_ASSOCIATED_PRODUCTS(HttpStatus.BAD_REQUEST,"D003","Brand has associated products and cannot be deleted");

    private final HttpStatus status;
    private final String message;
    private final String code;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

}
