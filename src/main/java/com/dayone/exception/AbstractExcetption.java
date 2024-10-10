package com.dayone.exception;

public abstract class AbstractExcetption extends RuntimeException {

    abstract public int getStatusCode();
    abstract public String getMessage();
}
