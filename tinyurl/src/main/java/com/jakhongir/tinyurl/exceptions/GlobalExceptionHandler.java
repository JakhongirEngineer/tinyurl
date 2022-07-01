package com.jakhongir.tinyurl.exceptions;



import com.jakhongir.tinyurl.exceptions.customExceptions.LongUrlNotProvided;
import com.jakhongir.tinyurl.exceptions.customExceptions.ShortUrlNotProvided;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {LongUrlNotProvided.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleLongUrlNotProvided(LongUrlNotProvided e, WebRequest request) {
        return new ExceptionResponse(e.getMessage());
    }

    @ExceptionHandler(value = {ShortUrlNotProvided.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleShortUrlNotProvided(ShortUrlNotProvided e, WebRequest request){
        return new ExceptionResponse(e.getMessage());
    }

}
