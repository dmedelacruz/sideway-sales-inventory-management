package com.sideway.management.exception.validation;


public class DuplicateCodeException extends RuntimeException {
    public DuplicateCodeException(String message) {
        super(message);
    }
}
