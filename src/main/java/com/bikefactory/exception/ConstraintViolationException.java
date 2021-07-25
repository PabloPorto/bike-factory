package com.bikefactory.exception;

public class ConstraintViolationException extends RuntimeException{
    public static final String EXCEPTION_CODE = "Constraint violation";

    public ConstraintViolationException() {
        super(EXCEPTION_CODE);
    }
}
