package com.jakhongir.tinyurl.exceptions.customExceptions;

public class ShortUrlNotProvidedException extends RuntimeException{
    public ShortUrlNotProvidedException(String message) {
        super(message);
    }
}
