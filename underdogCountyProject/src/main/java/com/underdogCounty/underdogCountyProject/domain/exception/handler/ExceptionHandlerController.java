package com.underdogCounty.underdogCountyProject.domain.exception.handler;

import com.underdogCounty.underdogCountyProject.domain.exception.ExceptionCode;
import com.underdogCounty.underdogCountyProject.domain.exception.WrongArtist;
import com.underdogCounty.underdogCountyProject.domain.exception.WrongWork;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongArtist.class)
    public ErrorResult wrongArtistId(IllegalArgumentException e) {
        return new ErrorResult(ExceptionCode.WRONG_ARTIST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongWork.class)
    public ErrorResult wrongWorkId(IllegalArgumentException e) {
        return new ErrorResult(ExceptionCode.WRONG_WORK);
    }

}
