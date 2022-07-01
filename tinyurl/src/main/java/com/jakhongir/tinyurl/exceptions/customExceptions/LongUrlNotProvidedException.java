package com.jakhongir.tinyurl.exceptions.customExceptions;


public class LongUrlNotProvidedException extends RuntimeException{
    public LongUrlNotProvidedException(String message) {
        super(message);
    }
}
