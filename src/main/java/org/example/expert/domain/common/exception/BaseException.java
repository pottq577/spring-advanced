package org.example.expert.domain.common.exception;

public abstract class BaseException extends RuntimeException {

    public abstract ExceptionCode getExceptionCode();
    public abstract String getMessage();

}
