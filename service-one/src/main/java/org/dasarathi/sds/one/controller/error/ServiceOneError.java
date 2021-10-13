package org.dasarathi.sds.one.controller.error;

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

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
