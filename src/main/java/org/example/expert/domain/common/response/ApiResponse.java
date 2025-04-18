package org.example.expert.domain.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.exception.BaseException;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {

    private final HttpStatus httpStatus;
    private final T data;

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(HttpStatus.OK, data);
    }

    public static <T> ApiResponse<T> created(final T data) {
        return new ApiResponse<>(HttpStatus.CREATED, data);
    }

    public static ApiResponse<String> fail(final BaseException e) {
        return new ApiResponse<>(e.getExceptionCode().getHttpStatus(), e.getMessage());
    }

}
