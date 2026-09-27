package com.ding.xxx_crud.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(UUID id) {
        super("找不到:" + id);
    }
    public NotFoundException(String message) {
        super(message);
    }
}
