package org.example.expert.domain.common.handler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.example.expert.domain.common.exception.BaseException;
import org.example.expert.domain.common.exception.ExceptionCode;
import org.example.expert.domain.common.exception.InvalidRequestException;
import org.example.expert.domain.common.exception.ServerException;
import org.example.expert.domain.common.response.ApiResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 입력 값 검증 예외 핸들러
    @ExceptionHandler(value = {
        ResponseStatusException.class,
        ConstraintViolationException.class,
        MethodArgumentNotValidException.class
    })
    public ApiResponse<?> handleValidationException(Exception ex) {
        log.error("Catch Validation Exception : {}", ex.getMessage());
        return ApiResponse.fail(new InvalidRequestException(ExceptionCode.NOT_VALID_ERROR));
    }

    // 커스텀 예외 핸들러
    @ExceptionHandler(BaseException.class)
    public ApiResponse<?> handleBusinessException(BaseException ex) {
        log.error("Catch Business Exception : {}", ex.getMessage());
        return ApiResponse.fail(ex);
    }

    // 예상치 못한 예외 핸들러
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleGeneralException(Exception e) {
        log.error("Catch General Exception : {}", e.getMessage());
        return ApiResponse.fail(new ServerException(ExceptionCode.SERVER_ERROR));
    }

}
