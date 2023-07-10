package com.example.board.service;

import com.example.board.repository.ArticleCommentRepository;
import com.example.board.repository.ArticleRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks
    private ArticleCommentService service;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private ArticleCommentRepository articleCommentRepository;
}