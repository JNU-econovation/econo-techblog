package com.econovation.tcono.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    public static final String LOG_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        request.setAttribute(LOG_ID, uuid);

        //@RequestMapping: HandlerMethod
        //정적 리소스: ResourceHttpRequestHandler
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;//호출할 컨트롤러 메서드의 모든 정보가 포함되어 있다.
        }

        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle [{}]", modelAndView);
        log.info("postHandle response Status : ", response.getStatus());
    }

//    afterCompletion은 뷰가 렌더링 된 이후에 나타난다. API 서버에서 뷰가 없기 때문에 예외처리
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Oabject handler, Exception ex) throws Exception {
//        String requestURI = request.getRequestURI();
//        String logId = (String) request.getAttribute(LOG_ID);
//        log.info("RESPONSE [{}][{}][{}]", logId, requestURI, handler);
//        if (ex != null) {
//            log.error("afterCompletion error!!", ex);
//        }
//
//    }
}

