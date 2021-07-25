package com.bikefactory.exception;

public class RowGuidNotFoundException extends RuntimeException {
    public static final String EXCEPTION_CODE = "RowGuide not found exception";

    public RowGuidNotFoundException() {
        super(EXCEPTION_CODE);
    }
}
