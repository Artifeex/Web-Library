package com.sandr.web_library.domain.exception;

public class BadDto extends RuntimeException {

    public BadDto(String message) {
        super(message);
    }
}
