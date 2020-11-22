package org.zdjavapol12.springcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zdjavapol12.springcourse.exception.WrongPageException;
import org.zdjavapol12.springcourse.model.Error;

@RestControllerAdvice
public class GlobalExceptionController {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongPageException.class)
    public Error pageExceptionHandler(WrongPageException wrongPageException) {
        return new Error(wrongPageException.getMessage());
    }

}
