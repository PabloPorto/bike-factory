package com.bikefactory.exception;

public class SalesOrderDetailNotFoundException extends RuntimeException{
    public static final String EXCEPTION_CODE = "Sales order detail not found";

    public SalesOrderDetailNotFoundException() {
        super(EXCEPTION_CODE);
    }
}
