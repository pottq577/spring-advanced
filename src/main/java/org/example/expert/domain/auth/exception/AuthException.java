package org.example.expert.domain.auth.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.exception.BaseException;
import org.example.expert.domain.common.exception.ExceptionCode;

@Getter
@RequiredArgsConstructor
public class AuthException extends BaseException {

    private final ExceptionCode exceptionCode;

    @Override
    public ExceptionCode getExceptionCode(){
        return exceptionCode;
    }

    @Override
    public String getMessage(){
        return exceptionCode.getMessage();
    }

}
