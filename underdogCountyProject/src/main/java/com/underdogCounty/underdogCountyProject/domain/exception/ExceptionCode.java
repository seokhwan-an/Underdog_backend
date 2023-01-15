package com.underdogCounty.underdogCountyProject.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode {

    WRONG_ARTIST(HttpStatus.BAD_REQUEST.value(), "잘못된 아티스트 입니다."),
    WRONG_WORK(HttpStatus.BAD_REQUEST.value(), "잘못된 작업물 입니다.");

    private final int code;
    private final String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
