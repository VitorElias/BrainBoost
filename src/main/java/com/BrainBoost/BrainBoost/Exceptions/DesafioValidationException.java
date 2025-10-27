package com.BrainBoost.BrainBoost.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DesafioValidationException extends RuntimeException {
    public DesafioValidationException(String message) {
        super(message);
    }
}
