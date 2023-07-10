package com.example.board.service;

import com.example.board.domain.Article;
import com.example.board.dto.ArticleDto;
import com.example.board.enums.SearchType;
import com.example.board.repository.ArticleRepository;
import org.assertj.core.api.AssertJProxySetup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;

    @Mock
    private ArticleRepository repository;

    @Test
    public void search() {
        Page<ArticleDto> articleDtos = articleService.search(SearchType.SEARCH_TYPE, "search keyword");
        assertThat(articleDtos).isNotNull();
    }

    @Test
    public void save() {
        given(repository.save(any(Article.class)));

        articleService.save(ArticleDto.of("title","content", "hashtag", "himina", LocalDateTime.now()));

        then(repository).should().save(any(Article.class));
    }

    @Test
    public void delete() {
        willDoNothing().given(repository).delete(any(Article.class));

        articleService.deleteById(1L);

        then(repository).should().delete(any(Article.class));
    }
}