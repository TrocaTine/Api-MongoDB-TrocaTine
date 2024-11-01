package com.example.apitrocatinemongo.exception;

import java.util.Map;

public record ExceptionValidDTO(
        int status,
        String message,
        Map<String, String> errors
) {
}

