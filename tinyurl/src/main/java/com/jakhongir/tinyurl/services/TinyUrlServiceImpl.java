package com.jakhongir.tinyurl.services;

import com.jakhongir.tinyurl.entities.TinyUrlEntity;
import com.jakhongir.tinyurl.exceptions.customExceptions.InvalidShortUrlException;
import com.jakhongir.tinyurl.repositories.TinyUrlRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TinyUrlServiceImpl implements TinyUrlService{

    private final TinyUrlRepository tinyUrlRepository;

    public TinyUrlServiceImpl(TinyUrlRepository tinyUrlRepository) {
        this.tinyUrlRepository = tinyUrlRepository;
    }

    @Override
    public String shorten(String longUrl) {
        Optional<TinyUrlEntity> optionalTinyUrlEntity = tinyUrlRepository.findByLongUrl(longUrl);

        if (optionalTinyUrlEntity.isPresent()) {
            return optionalTinyUrlEntity.get().getShortUrl();
        }
        // TODO
        // 1. get unique id from unique id generator
        long uniqueId = 111111L; // needs to be implemented;
        //TODO

        // 2. convert unique id into string using 'base 62 conversion'
        String shortUrl = convertIdIntoStringUsingBase62Conversion(uniqueId);
        // 3. save the id, longUrl, shortUrl into DB
        TinyUrlEntity tinyUrlEntity = new TinyUrlEntity(uniqueId, longUrl, shortUrl);
        TinyUrlEntity savedTinyUrl = tinyUrlRepository.save(tinyUrlEntity);
        // 4. return shortUrl
        return savedTinyUrl.getShortUrl();
    }

    private String convertIdIntoStringUsingBase62Conversion(long uniqueId) {
        List<Integer> reminders = new LinkedList<>();
        while (uniqueId > 0) {
            int reminder = (int) uniqueId % 62;
            reminders.add(0, reminder);
            uniqueId /= 62;
        }

        StringBuilder builder = new StringBuilder();
        for (int value : reminders) {
            if (value >= 0 && value <= 9) {
                builder.append(value);
            } else if (value >= 10 && value <= 35) {
                // small letters
                builder.append((char)(value + 87));
            } else if(value >= 36 && value <= 61) {
                // capital letters
                builder.append((char)(value + 29));
            }
        }
        return builder.toString();
    }
    @Override
    public String getLongUrl(String shortUrl) {
        return tinyUrlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new InvalidShortUrlException("given short url is not valid"))
                .getLongUrl();
    }

}
