package com.example.board.service;

import com.example.board.dto.ArticleCommentDto;
import com.example.board.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleCommentRepository repository;

    public List<ArticleCommentDto> searchArticleComment(Long articleId) {
        return List.of();
    }
}
