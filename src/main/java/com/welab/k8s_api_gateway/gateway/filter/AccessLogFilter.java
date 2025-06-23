package com.welab.k8s_api_gateway.gateway.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;



@Component
public class AccessLogFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessLogFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String method = request.getMethod();          // GET, POST 등
        String uri = request.getRequestURI();         // /api/v1/users 등

        logger.info("HTTP_REQ method={} path={}", method, uri);

        filterChain.doFilter(request, response);
    }
}