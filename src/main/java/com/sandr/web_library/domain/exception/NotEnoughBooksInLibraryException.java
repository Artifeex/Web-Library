package com.sandr.web_library.domain.exception;

public class NotEnoughBooksInLibraryException extends RuntimeException {
    public NotEnoughBooksInLibraryException(String message) {
        super(message);
    }
}
