package com.todocodeacademy.shop.products_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.todocodeacademy.shop.products_service.exceptions.ProductNotFoundException;
import com.todocodeacademy.shop.products_service.response.ErrorResponse;
import com.todocodeacademy.shop.products_service.response.ValidationError;
import com.todocodeacademy.shop.products_service.response.ValidationErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status,
            String message) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(status)
                .statusCode(status.value())
                .message(message)
                .reason(status.getReasonPhrase())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(errorResponse, status);
    }

    private ResponseEntity<ValidationErrorResponse> buildValidationErrorResponse(HttpStatus status,
            String message,
            Map<String, List<ValidationError>> validationErrors) {
        ValidationErrorResponse validationErrorResponse = ValidationErrorResponse.builder()
                .status(status)
                .statusCode(status.value())
                .message(message)
                .reason(status.getReasonPhrase())
                .validationErrors(validationErrors)
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(validationErrorResponse, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationError(MethodArgumentNotValidException e) {
        Map<String, List<ValidationError>> validationErrors = new HashMap<>();
        ResponseEntity<ValidationErrorResponse> errorResponseResponseEntity = buildValidationErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Validation Error", validationErrors);

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            List<ValidationError> validationErrorList = Objects.requireNonNull(errorResponseResponseEntity.getBody())
                    .getValidationErrors().get(fieldError.getField());
            if (validationErrorList == null) {
                validationErrorList = new ArrayList<>();
                errorResponseResponseEntity.getBody().getValidationErrors().put(fieldError.getField(),
                        validationErrorList);
            }
            ValidationError validationError = ValidationError.builder()
                    .code(fieldError.getCode())
                    .message(fieldError.getDefaultMessage())
                    .build();
            validationErrorList.add(validationError);
        }

        return errorResponseResponseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception e) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, AppConstants.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException e) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, AppConstants.PRODUCT_NOT_FOUND);
    }

}
