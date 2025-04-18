package org.example.expert.domain.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    // 인증/인가
    ALREADY_USED_EMAIL(HttpStatus.BAD_REQUEST, "이미 사용 중인 이메일입니다."),
    NOT_SIGNUP_USER(HttpStatus.NOT_FOUND, "가입되지 않은 유저입니다."),
    PASSWORD_INCORRECT(HttpStatus.BAD_REQUEST, "잘못된 비밀번호입니다."),
    NEW_PASSWORD_SAME_AS_OLD(HttpStatus.BAD_REQUEST, "새 비밀번호는 기존 비밀번호와 같을 수 없습니다."),
    PASSWORD_VALIDATION(HttpStatus.BAD_REQUEST, "비밀번호는 8자 이상이어야 합니다."),

    // 일정
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "일정 정보를 찾을 수 없습니다."),
    INVALID_TODO_OWNER(HttpStatus.BAD_REQUEST, "해당 일정을 만든 유저가 유효하지 않습니다."),
    CANNOT_ASSIGN_SELF_AS_MANAGER(HttpStatus.BAD_REQUEST, "일정 작성자는 본인을 담당자로 등록할 수 없습니다."),

    // 담당자
    MANAGER_NOT_FOUND(HttpStatus.NOT_FOUND, "매니저 정보를 찾을 수 없습니다."),
    MANAGER_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "등록하려고 하는 담당자 유저가 존재하지 않습니다."),
    MANAGER_TODO_MISMATCH(HttpStatus.BAD_REQUEST, "해당 일정에 등록된 담당자가 아닙니다."),

    // 유저
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저 정보를 찾을 수 없습니다."),

    // 공통
    AUTH_USER_TYPE_INVALID(HttpStatus.INTERNAL_SERVER_ERROR, "@Auth와 AuthUser 타입은 함께 사용되어야 합니다."),
    FAIL_TO_GET_WEATHER_DATA(HttpStatus.INTERNAL_SERVER_ERROR, "날씨 데이터를 가져오는데 실패했습니다."),
    NO_WEATHER_DATA(HttpStatus.INTERNAL_SERVER_ERROR, "날씨 데이터가 없습니다."),
    FAIL_TO_GET_WEATHER_TODAY(HttpStatus.INTERNAL_SERVER_ERROR, "오늘에 해당하는 날씨 데이터를 찾을 수 없습니다."),
    TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "토큰 정보를 찾을 수 없습니다."),
    NOT_VALID_ERROR(HttpStatus.BAD_REQUEST, "Validation Exception 발생"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 에러 발생"),
    INVALID_USER_ROLE(HttpStatus.BAD_REQUEST, "유효하지 않은 UerRole");

    private final HttpStatus httpStatus;
    private final String message;

}
