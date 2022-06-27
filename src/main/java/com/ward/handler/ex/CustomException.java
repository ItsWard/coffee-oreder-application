package com.ward.handler.ex;

public class CustomException extends RuntimeException{

    private static final long seralVersionUID = 1L;

    private String message;

    public CustomException(String message) {
        super(message);
    }
}
