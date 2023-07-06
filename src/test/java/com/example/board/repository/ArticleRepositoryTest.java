package com.example.board.repository;

import com.example.board.config.JpaConfig;
import com.example.board.domain.Article;
import com.example.board.domain.ArticleComment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 해당 설정을 안해주면 AuditorAware 를 사용할 수 없다.
 * 때문에, CreatedBy나 CreatedAt 등이 채워지지 않는다.
 */
@Import(JpaConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ArticleRepositoryTest {

    private final ArticleRepository articleRepository;

    private final ArticleCommentRepository articleCommentRepository;

    public ArticleRepositoryTest(@Autowired ArticleRepository articleRepository, @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @BeforeAll
    public void init() {
        Article article = Article.of("initTitle", "initContent", "#hashtag");
        articleRepository.save(article);
    }

    @DisplayName("article select test")
    @Test
    void selectArticle() {
        List<Article> articles = articleRepository.findAll();

        assertThat(articles)
                .isNotNull()
                .hasSize(1);
    }

    @DisplayName("article insert test")
    @Test
    public void insertArticle() {
        // given
        Article article = Article.of("article", "content", "#hashtag");

        // when
        article = articleRepository.save(article);

        // then
        assertThat(article.getTitle()).isEqualTo("article");
    }

    /**
     * 기본적으로 트랜잭션이 걸려있기 때문에
     * update 동작이 기본적으로 생략되어진다.
     * 때문에 saveAndFlush를 통해 update동작을 보여줄 수 있게 처리한다.
     */
    @Test
    public void updateArticle() {
        Article article = Article.of("article", "content", "#hashtag");
        article = articleRepository.save(article);

        article.setContent("new");
        // 해당부분을 save로 실행시키면 update가 생략됨을 알 수 있다.
        articleRepository.saveAndFlush(article);
        assertThat(article.getContent()).isEqualTo("new");
    }
}