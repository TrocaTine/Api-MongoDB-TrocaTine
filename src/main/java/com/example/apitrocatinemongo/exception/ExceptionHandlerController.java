package com.example.apitrocatinemongo.exception;

import com.example.apitrocatinemongo.models.DTO.Response.StandardResponseDTO;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "401", description = "Unauthorized token",
                    content = @Content(schema = @Schema(implementation = StandardResponseDTO.class)))
    })
    @ExceptionHandler(UnauthorizedToken.class)
    public ResponseEntity<StandardResponseDTO> handleUnauthorizedToken(HttpServletRequest request, UnauthorizedToken ut) {
        StandardResponseDTO response = new StandardResponseDTO(true,
                new ExceptionHandlerDTO(401, ut.getMessage(), request.getServletPath()));
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Resource not found",
                    content = @Content(schema = @Schema(implementation = ExceptionHandlerDTO.class)))
    })
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<StandardResponseDTO> handleNotFound(HttpServletRequest request, NotFound nt) {
        StandardResponseDTO response = new StandardResponseDTO(true,
                new ExceptionHandlerDTO(404, nt.getMessage(), request.getServletPath()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Validation error",
                    content = @Content(schema = @Schema(implementation = ExceptionHandler.class)))
    })
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
                "Validation error",
                errors
        ));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}