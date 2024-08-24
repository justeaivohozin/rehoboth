package org.icc.campusservice.common.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    /**
     * Exception generated status
     */
    private HttpStatus status;
    /**
     * Date and time when exception occurs
     */
    private LocalDateTime timestamp;
    /**
     * Exception Message added by business
     */
    private String message;
    /**
     * Exception debug message
     */
    private String debugMessage;
    /**
     * In case of multiple error (as validation error)
     * This field get all errors
     */
    private List<ApiValidationError> subErrors;

    public ApiError(HttpStatus status, LocalDateTime timestamp, String message, String debugMessage, List<ApiValidationError> subErrors) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.debugMessage = debugMessage;
        this.subErrors = subErrors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApiValidationError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiValidationError> subErrors) {
        this.subErrors = subErrors;
    }
}
