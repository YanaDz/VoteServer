package com.dziadkouskaya.votingserver.controller.handler;

import com.dziadkouskaya.votingserver.exception.ApplicationException;
import com.dziadkouskaya.votingserver.exception.ResourceNotFoundException;
import com.dziadkouskaya.votingserver.exception.RestErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

import static com.dziadkouskaya.votingserver.utils.Constants.ACCESS_DENIED_MESSAGE;
import static com.dziadkouskaya.votingserver.utils.Constants.INNER_SERVER_ERROR_MESSAGE;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<RestErrorResponse> handleBindException(ResourceNotFoundException ex, WebRequest request) {
        return handleInternal(ex, INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(ApplicationException.class)
    protected ResponseEntity<RestErrorResponse> handleBindException(ApplicationException ex, WebRequest request) {
        return handleInternal(ex, INTERNAL_SERVER_ERROR, INNER_SERVER_ERROR_MESSAGE);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<RestErrorResponse> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        return handleInternal(ex, FORBIDDEN, ACCESS_DENIED_MESSAGE);
    }


    private ResponseEntity<RestErrorResponse> handleInternal(Exception ex, HttpStatus status, String error) {
        log.error(error, ex);
        return new ResponseEntity<>(new RestErrorResponse(error), new HttpHeaders(), status);
    }
}

