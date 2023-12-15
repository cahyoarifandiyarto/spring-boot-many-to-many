package com.belajar.springbootmanytomany.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Getter
public class ErrorException extends RuntimeException {

    private final Map<String, List<String>> errors;

    private final Map<String, Object> metadata;

    private final HttpStatus httpStatus;

}
