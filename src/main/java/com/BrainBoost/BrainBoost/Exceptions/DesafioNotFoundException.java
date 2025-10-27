package com.BrainBoost.BrainBoost.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DesafioNotFoundException extends RuntimeException {
    public DesafioNotFoundException(String message) {
        super(message);
    }
}
