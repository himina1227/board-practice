package com.example.board.service;

import com.example.board.dto.ArticleDto;
import com.example.board.enums.SearchType;
import com.example.board.repository.ArticleRepository;
import org.assertj.core.api.AssertJProxySetup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}