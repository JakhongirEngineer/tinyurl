package com.jakhongir.tinyurl.services;

public interface TinyUrlService {

    String shorten(String longUrl);
    String getLongUrl(String shortUrl);
}
