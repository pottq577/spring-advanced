package org.example.expert.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
        HttpServletRequest request, HttpServletResponse response, Object handler
    ) throws Exception {
        String requestURI = request.getMethod() + " " + request.getRequestURL();

        log.info("Request [{}][{}]", LocalDateTime.now(), requestURI);
        LogUtility.set(LocalDateTime.now(), requestURI);

        return true;
    }

    @Override
    public void afterCompletion(
        HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex
    ) throws Exception {
        log.info("Response {} [{}][{}]",
            response.getStatus(), LogUtility.getRequestTime(), handler);
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
