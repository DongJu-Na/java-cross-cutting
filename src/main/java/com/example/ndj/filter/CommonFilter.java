package com.example.ndj.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("웹 컨테이너(톰캣)이 시작될 때 필터 최초 한 번 인스턴스 생성");
        jakarta.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("클라이언트의 요청 시 전/후 처리 FilterChain을 통해 전달");
    }

    @Override
    public void destroy() {
        log.info("필터 인스턴스가 제거될 때 실행되는 메서드, 종료하는 기능");
        jakarta.servlet.Filter.super.destroy();
    }
}


