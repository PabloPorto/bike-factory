package com.bikefactory.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationException extends RuntimeException {
    public static final String EXCEPTION_CODE = "error.validation";

    private final transient StandardError standardError;

    public ValidationException(List<String> errors) {
        standardError = new StandardError(LocalDateTime.now(), EXCEPTION_CODE, errors);
    }

    public StandardError getStandardError() {
        return standardError;
    }
}