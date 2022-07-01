package com.jakhongir.tinyurl.exceptions.customExceptions;


public class LongUrlNotProvided extends RuntimeException{
    public LongUrlNotProvided(String message) {
        super(message);
    }
}
