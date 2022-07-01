package com.jakhongir.tinyurl.exceptions.customExceptions;

public class ShortUrlNotProvided extends RuntimeException{
    public ShortUrlNotProvided(String message) {
        super(message);
    }
}
