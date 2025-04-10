package com.musinsa.coord.common.error;

import com.musinsa.coord.common.error.exception.BusinessException;
import com.musinsa.coord.common.error.exception.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException exception, HttpServletRequest request) {
        logError(request, exception);
        ErrorResponse response = exception.getErrorResponse();
        return buildResponseEntity(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e, HttpServletRequest request) {
        logWarn("handleMethodArgumentNotValidException", request, e);
        ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return buildResponseEntity(response);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        logWarn("handleMethodArgumentTypeMismatchException", request, e);
        ErrorResponse response = ErrorResponse.of(e);
        return buildResponseEntity(response);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        logWarn("handleHttpRequestMethodNotSupportedException", request, e);
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    ResponseEntity<ErrorResponse> handleNoHandlerFoundException(HttpServletRequest request) {
        log.warn("{}. Request path: {}", "handleNoHandlerFoundException", request.getRequestURI());
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.NO_HANDLER_FOUND);
        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorResponse> handleMessageNotReadableException(
            HttpMessageNotReadableException e, HttpServletRequest request) {
        logWarn("handleMessageNotReadableException", request, e);
        var bindingResult = new MapBindingResult(Map.of("body", "unreadable"), e.getClass().getSimpleName());
        bindingResult.rejectValue("body", "unreadable", e.getMessage().split(":")[0]);
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, bindingResult);
        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(BindException.class)
    ResponseEntity<ErrorResponse> handleBindException(BindException e, HttpServletRequest request) {
        logWarn("handleBindException", request, e);
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    ResponseEntity<ErrorResponse> handleRequestParamException(
            MissingServletRequestParameterException e, HttpServletRequest request) {
        logWarn("handleRequestParamException", request, e);
        var bindingResult = new MapBindingResult(Map.of(e.getParameterName(), e.getMessage()), e.getClass().getSimpleName());
        bindingResult.rejectValue(e.getParameterName(), e.getMessage(), e.getMessage());
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, bindingResult);
        return buildResponseEntity(errorResponse);
    }

    private void logWarn(String handlerMethod, HttpServletRequest request, Exception exception) {
        log.warn("{}. Request path: {}", handlerMethod, request.getRequestURI(), exception);
    }

    private void logError(HttpServletRequest request, Exception exception) {
        log.error("{}. Request path: {}", "handleBusinessException", request.getRequestURI(), exception);
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(ErrorResponse response) {
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
