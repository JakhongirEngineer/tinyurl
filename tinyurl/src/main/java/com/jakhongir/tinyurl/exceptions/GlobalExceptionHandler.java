package com.jakhongir.tinyurl.exceptions;



import com.jakhongir.tinyurl.exceptions.customExceptions.InvalidShortUrlException;
import com.jakhongir.tinyurl.exceptions.customExceptions.LongUrlNotProvidedException;
import com.jakhongir.tinyurl.exceptions.customExceptions.ShortUrlNotProvidedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {LongUrlNotProvidedException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleLongUrlNotProvided(LongUrlNotProvidedException e, WebRequest request) {
        return new ExceptionResponse(e.getMessage());
    }

    @ExceptionHandler(value = {ShortUrlNotProvidedException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleShortUrlNotProvided(ShortUrlNotProvidedException e, WebRequest request){
        return new ExceptionResponse(e.getMessage());
    }

    @ExceptionHandler(value = {InvalidShortUrlException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleInvalidShortUrlException(InvalidShortUrlException e, WebRequest request) {
        return new ExceptionResponse(e.getMessage());
    }


}
