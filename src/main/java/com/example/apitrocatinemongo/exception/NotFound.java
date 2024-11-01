package com.example.apitrocatinemongo.exception;

public class NotFound extends RuntimeException {
    public NotFound(String notFoundProduct) {
        super(notFoundProduct);
    }
}
