package com.dmx.regusers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7992904489502842099L;

    public ResourceNotFoundException() {
        this("EntityRepresentationModel not found!");
    }

    public ResourceNotFoundException(String message) {
        this(message, null);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
