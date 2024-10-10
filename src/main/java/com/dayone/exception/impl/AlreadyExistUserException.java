package com.dayone.exception.impl;

import com.dayone.exception.AbstractExcetption;
import org.springframework.http.HttpStatus;

public class AlreadyExistUserException extends AbstractExcetption {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "이미 존재하는 사용자명입니다.";
    }
}
