package com.belajar.springbootmanytomany.controller;

import com.belajar.springbootmanytomany.exception.ErrorException;
import com.belajar.springbootmanytomany.model.Response;
import com.belajar.springbootmanytomany.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, List<String>> errors = new HashMap<>();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            String field = fieldError.getField();

            if (!errors.containsKey(field)) {
                errors.put(field, new ArrayList<>());
            }

            errors.get(field).add(fieldError.getDefaultMessage());
        }

        Response<Void> response = ResponseUtil.build(null, errors, null, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<Response<Void>> handleErrorException(ErrorException e) {
        Response<Void> response = ResponseUtil.build(null, e.getErrors(), e.getMetadata(), e.getHttpStatus());

        return new ResponseEntity<>(response, e.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleException(Exception e) {
        Response<Void> response = ResponseUtil.build(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
