package com.jakhongir.tinyurl.repositories;

import com.jakhongir.tinyurl.entities.TinyUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TinyUrlRepository extends JpaRepository<TinyUrlEntity, Long> {
    Optional<TinyUrlEntity> findByLongUrl(String longUrl);
    Optional<TinyUrlEntity> findByShortUrl(String shortUrl);
}
