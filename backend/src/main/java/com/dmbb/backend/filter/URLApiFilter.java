package com.dmbb.backend.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class URLApiFilter implements Filter {

    private final static String API_PATTERN = "^\\/api\\/(.+)$";
    private final static String POINT_EXCLUSION_PATTERN = "^([^.]+)$";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        if (!requestURI.equals(contextPath) && !requestURI.matches(API_PATTERN) && requestURI.matches(POINT_EXCLUSION_PATTERN)) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/");
            dispatcher.forward(servletRequest, servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
