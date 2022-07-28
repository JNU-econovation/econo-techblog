package com.econovation.tcono.config;

import com.econovation.tcono.Interceptor.LogInterceptor;
import com.econovation.tcono.Interceptor.LoginCheckInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico","**/*.graphql","**/*.graphqls" ,"/error", "/api/usernames/**" ,"/api/login","/api/user/**",
                        "/api/confirm-email/**","/api/unique-email/**","/api/file");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/api/user/**","/api/user","/api/file","**/*.graphql","**/*.graphqls","/api/usernames/**","/api/confirm-email/**", "/api/login", "/api/logout","/api/find-email/**",
                        "/css/**", "/*.ico", "/error","/api/file");
    }
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("*");
////                .allowCredentials(true);
//    }
}
