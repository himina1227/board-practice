package com.example.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    public AuditorAware<String> auditorAware() {
        // TODO: 스프링 인증 후 추가 구현
        return () -> Optional.of("himina");
    }
}