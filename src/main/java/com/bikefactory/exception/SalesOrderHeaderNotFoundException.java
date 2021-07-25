package com.bikefactory.exception;

public class SalesOrderHeaderNotFoundException extends RuntimeException{
    public static final String EXCEPTION_CODE = "Sales order header not found";

    public SalesOrderHeaderNotFoundException() {
        super(EXCEPTION_CODE);
    }
}
