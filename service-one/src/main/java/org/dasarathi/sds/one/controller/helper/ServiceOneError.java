package org.dasarathi.sds.one.controller.helper;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ServiceOneError {
    private HttpStatus httpStatus;
    private String errorMessage;
    private List<String> errorList;

    public ServiceOneError() {
        super();
    }

    public ServiceOneError(HttpStatus httpStatus, String message, List<String> errorList) {
        super();
        this.httpStatus = httpStatus;
        this.errorMessage = message;
        this.errorList = errorList;
    }

    public ServiceOneError(HttpStatus status, String message, String error) {
        super();
        this.httpStatus = status;
        this.errorMessage = message;
        errorList = Arrays.asList(error);
    }
}
