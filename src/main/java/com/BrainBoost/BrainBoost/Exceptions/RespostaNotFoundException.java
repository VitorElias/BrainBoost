package com.BrainBoost.BrainBoost.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RespostaNotFoundException extends RuntimeException {
    public RespostaNotFoundException(String message) {
        super(message);
    }
}
