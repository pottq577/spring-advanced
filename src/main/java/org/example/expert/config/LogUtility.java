package org.example.expert.config;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class LogUtility {

    @Getter
    @AllArgsConstructor
    public static class LogInfo{
        private LocalDateTime requestTime;
        private String requestURI;
    }

    private static final ThreadLocal<LogInfo> REQUEST_INFO = new ThreadLocal<>();

    public static void set(LocalDateTime requestTime, String requestURI){
        REQUEST_INFO.set(new LogInfo(requestTime, requestURI));
    }

    public static LocalDateTime getRequestTime(){
        return REQUEST_INFO.get().getRequestTime();
    }

    public static String getRequestURI(){
        return REQUEST_INFO.get().getRequestURI();
    }

    public static void remove(){
        REQUEST_INFO.remove();
    }

}
