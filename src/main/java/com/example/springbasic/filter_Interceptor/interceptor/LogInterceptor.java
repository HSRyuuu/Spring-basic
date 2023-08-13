package com.example.springbasic.filter_Interceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("[preHandle] LogInterceptor :  " + Thread.currentThread());
        log.info("[preHandle] handler : " + handler);

        //요청이 계속 진행되게
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("[postHandle] LogInterceptor :  " + Thread.currentThread());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        log.info("[afterCompletion] LogInterceptor :  " + Thread.currentThread());
        if(ex != null){
            log.info("[!!! afterCompletion exception] : " + ex);
        }
    }
}
