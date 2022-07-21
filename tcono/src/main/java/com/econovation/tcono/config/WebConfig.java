package com.econovation.tcono.config;

import com.econovation.tcono.Interceptor.LogInterceptor;
import com.econovation.tcono.Interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico","**/*.graphql","**/*.graphqls" ,"/error", "/api/usernames/**" ,"/api/user/**","/api/confirm-email/**","/api/unique-email/**");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/api/user/**","/api/user","**/*.graphql","**/*.graphqls","/api/usernames/**","/api/confirm-email/**", "/api/login", "/api/logout","/api/find-email/**",
                        "/css/**", "/*.ico", "/error");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://13.124.120.147:3000").maxAge(3600); // 3600초 동안 preflight 결과를 캐시에 저장
        registry.addMapping("/**").allowedOrigins("http://13.124.120.147:8080").maxAge(3600); // 3600초 동안 preflight 결과를 캐시에 저장
        registry.addMapping("/api/**").allowedOrigins("*").allowedMethods("GET", "POST","DELETE","PUT");
    }
}