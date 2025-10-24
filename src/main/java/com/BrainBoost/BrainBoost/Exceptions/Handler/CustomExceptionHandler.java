package com.BrainBoost.BrainBoost.Exceptions.Handler;

import com.BrainBoost.BrainBoost.Exceptions.*;
import com.BrainBoost.BrainBoost.Exceptions.Response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class CustomExceptionHandler{

    public static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseEntityCustom> notFound(NotFoundException ex, WebRequest request){
        logger.warn("ValidationException: {} - {}", ex.getMessage(), request.getDescription(false));        ResponseEntityCustom rec = new ResponseEntityCustom(new Date(), ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(rec, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ResponseEntityCustom> validation(ValidationException ex, WebRequest request){
        logger.warn("ValidationException: {} - {}", ex.getMessage(), request.getDescription(false));
        ResponseEntityCustom rec= new ResponseEntityCustom(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(rec, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseEntityCustom> runtime(RuntimeException ex, WebRequest request){
        logger.error("RuntimeException: {} - {}", ex.getMessage(), request.getDescription(false), ex);
        ResponseEntityCustom rec= new ResponseEntityCustom(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(rec, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
