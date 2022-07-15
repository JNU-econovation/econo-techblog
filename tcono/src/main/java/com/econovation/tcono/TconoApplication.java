package com.econovation.tcono;

import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class TconoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TconoApplication.class, args);
    }
}