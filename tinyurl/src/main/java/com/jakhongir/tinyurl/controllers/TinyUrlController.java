package com.jakhongir.tinyurl.controllers;

import com.jakhongir.tinyurl.exceptions.customExceptions.LongUrlNotProvidedException;
import com.jakhongir.tinyurl.exceptions.customExceptions.ShortUrlNotProvidedException;
import com.jakhongir.tinyurl.services.TinyUrlService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TinyUrlController {
    private final TinyUrlService tinyUrlService;

    public TinyUrlController(TinyUrlService tinyUrlService) {
        this.tinyUrlService = tinyUrlService;
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam(name = "longUrl") Optional<String> longUrlOptional) {
        String longUrl = longUrlOptional.orElseThrow(() -> new LongUrlNotProvidedException("longUrl is not provided"));
        return tinyUrlService.shorten(longUrl);
    }


    @GetMapping("/{shortUrl}")
    public String getLongUrl(@PathVariable(name = "shortUrl") Optional<String> shortUrlOptional) {
        String shortUrl = shortUrlOptional.orElseThrow(() -> new ShortUrlNotProvidedException("shortUrl is not provided"));
        return tinyUrlService.getLongUrl(shortUrl);
    }
}
