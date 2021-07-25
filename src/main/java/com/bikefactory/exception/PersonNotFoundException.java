package com.bikefactory.exception;

public class PersonNotFoundException extends RuntimeException {
    public static final String EXCEPTION_CODE = "Person not found exception";

    public PersonNotFoundException() {
        super(EXCEPTION_CODE);
    }
}
