package com.spotts.vinyl_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Allows you to handle exceptions across the whole application not just the controller.
 * Intercepter of exceptions for methods annotated @RequestMapping
 */
@ControllerAdvice
public class VinylNotFoundAdvice {

    @ResponseBody // advice will be rendered to the response body
    @ExceptionHandler(VinylNotFoundException.class) // configure only if an exception is thrown
    @ResponseStatus(HttpStatus.NOT_FOUND) // issues a 404
    String vinylNotFoundHandler(VinylNotFoundException ex) {
        return ex.getMessage();
    }
}
