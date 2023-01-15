package com.underdogCounty.underdogCountyProject.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode {

    WRONG_ARTIST(HttpStatus.BAD_REQUEST.value(), "잘못된 아티스트 입니다."),
    WRONG_WORK(HttpStatus.BAD_REQUEST.value(), "잘못된 작업물 입니다."),
    WRONG_EMAIL(HttpStatus.BAD_REQUEST.value(), "이메일 형식이 올바르지 못합니다"),
    WRONG_PHONENUMBER(HttpStatus.BAD_REQUEST.value(), "번호 형식이 올바르지 못합니다"),
    NULL_INPUT(HttpStatus.BAD_REQUEST.value(), "필수로 입력해야 하는 값입니다");

    private final int code;
    private final String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
