package com.example.board.service;

import com.example.board.dto.ArticleDto;
import com.example.board.enums.SearchType;
import com.example.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository repository;


    @Transactional(readOnly = true)
    public Page<ArticleDto> search(SearchType searchType, String searchKeyword) {
        return Page.empty();
    }
}
