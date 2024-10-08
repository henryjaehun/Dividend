package com.dayone.exception.impl;

import com.dayone.exception.AbstractExcetption;
import org.springframework.http.HttpStatus;

public class NoCompanyException extends AbstractExcetption {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "존재하지 않는 회사명 입니다.";
    }
}
