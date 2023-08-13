package com.example.springbasic.filter_Interceptor.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.info("=> start - Log filter: " + Thread.currentThread());

        //외부 -> filter -> (처리) -> filter -> 외부
        chain.doFilter(request, response); //여러개의 filter가 chain처럼 이어지게 하려면

        log.info("=> finish - Log filter : " + Thread.currentThread());

    }
}
