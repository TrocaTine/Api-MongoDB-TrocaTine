package com.example.apitrocatinemongo.exception;

import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UnauthorizedToken.class)
    public ResponseEntity<StandardResponseDTO> UnauthorizedToken(HttpServletRequest request, UnauthorizedToken ut){
        StandardResponseDTO response = new StandardResponseDTO(true,
                new ExceptionHandlerDTO(401, ut.getMessage(), request.getServletPath()));
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<StandardResponseDTO> UnauthorizedToken(HttpServletRequest request, NotFound nt){
        StandardResponseDTO response = new StandardResponseDTO(true,
                new ExceptionHandlerDTO(404, nt.getMessage(), request.getServletPath()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        StandardResponseDTO response = new StandardResponseDTO(true, new ExceptionValidDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação",
                errors
        ));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



}
