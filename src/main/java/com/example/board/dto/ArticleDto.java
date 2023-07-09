package com.example.board.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto(
        String title,
        String content,
        String hashtag,
        String createdBy,
        LocalDateTime createdAt
) implements Serializable {

    public static ArticleDto of(String title, String content, String hashtag, String createdBy, LocalDateTime createdAt) {
        return new ArticleDto(title, content, hashtag, createdBy, createdAt);
    }
}
