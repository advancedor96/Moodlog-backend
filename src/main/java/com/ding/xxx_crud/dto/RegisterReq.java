package com.ding.xxx_crud.dto;

import lombok.Data;

@Data
public class RegisterReq {
    private String account;
    private String password;
    private String email;   // 未來用
    // getters & setters
}
