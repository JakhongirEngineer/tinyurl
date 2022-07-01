package com.jakhongir.tinyurl.controllers;

import com.jakhongir.tinyurl.exceptions.customExceptions.LongUrlNotProvided;
import com.jakhongir.tinyurl.exceptions.customExceptions.ShortUrlNotProvided;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TinyUrlController {

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam(name = "longUrl") Optional<String> longUrl) {
        String s = longUrl.orElseThrow(() -> new LongUrlNotProvided("longUrl is not provided"));

        return "short ulr";
    }


    @GetMapping("/{shortUrl}")
    public String getLongUrl(@PathVariable(name = "shortUrl") Optional<String> shortUrlOptional) {
        String shortUrl = shortUrlOptional.orElseThrow(() -> new ShortUrlNotProvided("shortUrl is not provided"));

        return "long url";
    }
}
