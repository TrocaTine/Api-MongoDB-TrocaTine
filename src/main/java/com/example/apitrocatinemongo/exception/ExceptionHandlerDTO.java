package com.example.apitrocatinemongo.exception;

public record ExceptionHandlerDTO(
        int code,
        String message,
        String path
) {
}
