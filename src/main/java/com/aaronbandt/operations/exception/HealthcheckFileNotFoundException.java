package com.aaronbandt.operations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class HealthcheckFileNotFoundException extends RuntimeException {

    /** * */
    private static final long serialVersionUID = -9159573945488152299L;

    public HealthcheckFileNotFoundException(String healthcheckFilePath) {
        super("Healthcheck file not present at " + healthcheckFilePath);
    }

}
