package com.underdogCounty.underdogCountyProject.domain.exception.handler;

import com.underdogCounty.underdogCountyProject.domain.exception.ExceptionCode;
import com.underdogCounty.underdogCountyProject.domain.exception.WrongArtist;
import com.underdogCounty.underdogCountyProject.domain.exception.WrongEmail;
import com.underdogCounty.underdogCountyProject.domain.exception.WrongPhoneNumber;
import com.underdogCounty.underdogCountyProject.domain.exception.WrongWork;
import javax.validation.ConstraintViolationException;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongEmail.class)
    public ErrorResult wrongEmailPattern(IllegalArgumentException e) {
        return new ErrorResult(ExceptionCode.WRONG_EMAIL);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongPhoneNumber.class)
    public ErrorResult wrongPhoneNumberPattern(IllegalArgumentException e) {
        return new ErrorResult(ExceptionCode.WRONG_PHONENUMBER);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResult nullInput(ConstraintViolationException e) {
        return new ErrorResult(ExceptionCode.NULL_INPUT);
    }

}
