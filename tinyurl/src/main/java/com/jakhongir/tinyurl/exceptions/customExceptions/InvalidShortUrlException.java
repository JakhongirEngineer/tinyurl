package com.jakhongir.tinyurl.exceptions.customExceptions;

public class InvalidShortUrlException extends RuntimeException{
    public InvalidShortUrlException(String message) {
        super(message);
    }
}
