package com.ding.xxx_crud.exception;

import org.springframework.http.HttpStatus;

public class MyException extends RuntimeException{
    private final int status;

    public MyException(int status, String msg) {
        super(msg);
        this.status = status;
    }
    public int getStatus(){ return status; }
}
