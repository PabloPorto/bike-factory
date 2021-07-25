package com.bikefactory.exception;

public class CustomerNotFoundException extends RuntimeException{
    public static final String EXCEPTION_CODE = "Customer not found exception";

    public CustomerNotFoundException() {
        super(EXCEPTION_CODE);
    }
}
