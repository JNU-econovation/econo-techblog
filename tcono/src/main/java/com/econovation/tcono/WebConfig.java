package com.econovation.tcono;

import com.econovation.tcono.Interceptor.LogInterceptor;
import com.econovation.tcono.Interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico","**/*.graphql","**/*.graphqls" ,"/error", "/api/user/**","/api/confirm-email/**","/api/unique-email/**");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/api/user/**","/api/user","**/*.graphql","**/*.graphqls","/api/confirm-email/**", "/api/login", "/api/logout","/api/find-email/**",
                        "/css/**", "/*.ico", "/error");
    }
}