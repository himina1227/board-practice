package com.example.board.repository;

import com.example.board.domain.Article;
import com.example.board.domain.ArticleComment;
import com.example.board.domain.QArticle;
import com.example.board.domain.QArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long>
        , QuerydslPredicateExecutor<ArticleComment>
        , QuerydslBinderCustomizer<QArticleComment> {
    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        // listing되지 않는것들은 검색 조건에서 제외
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.content, root.createdAt);
//        bindings.bind(root.title).first((path, value) -> path.eq(value));
//        bindings.bind(root.title).first(StringExpression::likeIgnoreCase); // %title
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // %title%
        bindings.bind(root.createdAt).first(DateTimeExpression::eq); // %title%
    }
}
