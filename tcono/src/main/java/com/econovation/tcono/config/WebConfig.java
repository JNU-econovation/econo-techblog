<<<<<<< HEAD
<<<<<<< HEAD:tcono/src/main/java/com/econovation/tcono/config/WebConfig.java
package com.econovation.tcono.config;
=======
package com.econovation.tcono;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e:tcono/src/main/java/com/econovation/tcono/WebConfig.java

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
=======
//package blog.econovation.tcono.config;
//
//import blog.econovation.tcono.Interceptor.LogInterceptor;
//import blog.econovation.tcono.Interceptor.LoginCheckInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LogInterceptor())
//                .order(1)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/css/**", "/*.ico", "/error");
//        registry.addInterceptor(new LoginCheckInterceptor())
//                .order(2)
//                .addPathPatterns("/**")
//                .excludePathPatterns(
//                        "/", "/members/add", "/login", "/logout",
//                        "/css/**", "/*.ico", "/error"
//                );
//    }
//}
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e
