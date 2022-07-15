package com.econovation.tcono.Interceptor;

<<<<<<< HEAD:tcono/src/main/java/com/econovation/tcono/Interceptor/LoginCheckInterceptor.java
import com.econovation.tcono.web.controller.SessionConst;
=======
import com.econovation.tcono.web.SessionConst;
>>>>>>> 3511556d4c5fdf308ee96f20f9e11bd248b24c5e:tcono/src/main/java/blog/econovation/tcono/Interceptor/LoginCheckInterceptor.java
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();

        log.info("인증 체크 인터셉터 실행 {}", requestURI);

        HttpSession session = request.getSession();

        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            log.info("LoginCheckInterceptor/ Session :", session);
            //로그인으로 redirect
//            response.sendRedirect("/api/login?redirectURL=" + requestURI);
            return false;
        }
        return true;
    }
}

