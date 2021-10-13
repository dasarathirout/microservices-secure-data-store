package org.dasarathi.sds.one.controller.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServiceOneExceptionHandler extends ResponseEntityExceptionHandler {
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers,
                                                                          HttpStatus status,
                                                                          WebRequest request) {
        String error = ex.getParameterName() + " : Required Parameter Missing";
        ServiceOneError serviceOneError = new ServiceOneError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(serviceOneError, new HttpHeaders(), serviceOneError.getHttpStatus());
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadable(
                                       HttpMessageNotReadableException ex,
                                       HttpHeaders headers,
                                       HttpStatus status,
                                       WebRequest request) {
        String error = ex.getMessage() + " : Required Data Set Missing";
        ServiceOneError serviceOneError = new ServiceOneError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return handleExceptionInternal(ex, serviceOneError, headers, serviceOneError.getHttpStatus(), request);
    }

    protected ResponseEntity<Object> handleHttpMessageNotWritable(
                                        HttpMessageNotWritableException ex,
                                        HttpHeaders headers,
                                        HttpStatus status,
                                        WebRequest request) {
        String error = ex.getMessage() + " : Unable To Write Given Missing";
        ServiceOneError serviceOneError = new ServiceOneError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return handleExceptionInternal(ex, serviceOneError, headers, status, request);
    }
}
