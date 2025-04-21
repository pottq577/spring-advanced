package org.example.expert.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
        HttpServletRequest request, HttpServletResponse response, Object handler
    ) throws Exception {
        String uuid = UUID.randomUUID().toString();
        String requestURI = request.getMethod() + " " + request.getRequestURL();

        log.info("Request [{}][{}]", uuid, requestURI);
        LogUtility.set(uuid, requestURI);

        return true;
    }

    @Override
    public void afterCompletion(
        HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex
    ) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
