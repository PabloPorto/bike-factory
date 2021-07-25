package com.bikefactory.exception;

public class ProductNotFoundException extends RuntimeException {
    public static final String EXCEPTION_CODE = "Product not found exception";

    public ProductNotFoundException() {
        super(EXCEPTION_CODE);
    }
}
