package com.example.board.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;

    private Article article;

    private String content;

    private LocalDateTime createDateAt;

    private String createBy;

    private LocalDateTime modifiedAt;

    private String modifiedBy;
}
