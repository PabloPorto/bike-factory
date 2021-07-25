package com.bikefactory.exception;

public class CustomerTableEmptyException extends RuntimeException{
    public static final String EXCEPTION_CODE = "Customer table is empty";

    public CustomerTableEmptyException() {
        super(EXCEPTION_CODE);
    }
}
