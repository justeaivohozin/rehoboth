package org.icc.campusservice.common.exception;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.icc.campusservice.common.exception.custom.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Global Error Handling through Country Manager
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * Handle entity not found exception
     *
     * @param ex      custom exception
     * @param request request
     * @return ApiError
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        logger.info("Handle error for entity not found.");
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                Collections.emptyList()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiError> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        logger.info("Handle validation error for entity.");

        List<ApiValidationError> subErrorLists = new java.util.ArrayList<>();
        for (ConstraintViolation<?> fieldError : ex.getConstraintViolations()) {
            subErrorLists.add(new ApiValidationError(fieldError.getRootBeanClass().getName() + " " + fieldError.getPropertyPath(), fieldError.getMessage()));
        }
        ApiError error = new ApiError(
                HttpStatus.UNPROCESSABLE_ENTITY,
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                subErrorLists
        );
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
