package org.example.expert.domain.common.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

  public abstract HttpStatus getStatus();
  public abstract String getMessage();

}
