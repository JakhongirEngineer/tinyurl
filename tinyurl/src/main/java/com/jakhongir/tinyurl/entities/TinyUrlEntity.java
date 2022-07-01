package com.jakhongir.tinyurl.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TinyUrlEntity {
    @Id
    private Long id;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String longUrl;
    @Column(nullable = false)
    private String shortUrl;

    public TinyUrlEntity() {
    }

    public TinyUrlEntity(Long id, String longUrl, String shortUrl) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
