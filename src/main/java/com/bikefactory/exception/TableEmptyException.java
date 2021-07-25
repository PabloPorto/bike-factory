package com.bikefactory.exception;

public class TableEmptyException extends RuntimeException{
    public static final String EXCEPTION_CODE = "This table is empty";

    public TableEmptyException() {
        super(EXCEPTION_CODE);
    }
}
