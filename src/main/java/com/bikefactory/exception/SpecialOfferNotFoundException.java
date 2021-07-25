package com.bikefactory.exception;

public class SpecialOfferNotFoundException extends RuntimeException{
    public static final String EXCEPTION_CODE = "Special offer product not found";

    public SpecialOfferNotFoundException() {
        super(EXCEPTION_CODE);
    }
}
