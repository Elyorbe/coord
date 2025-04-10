package com.musinsa.coord.core.error;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public record FieldError(
        String field,
        String value,
        String reason
) {

    public static List<FieldError> of(String field, String value, String reason) {
        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(new FieldError(field, value, reason));
        return fieldErrors;
    }

    public static List<FieldError> of(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(error -> new FieldError(
                        error.getField(),
                        error.getRejectedValue() == null ? null : error.getRejectedValue().toString(),
                        error.getDefaultMessage())
                ).toList();
    }

}
