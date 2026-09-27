package com.ding.xxx_crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.ding.xxx_crud.dto.RegisterReq;
import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String loginPage(){
        return "login ing...";
    }
    // 註冊
    @PostMapping("/register")
    public String register(@RequestBody RegisterReq req) {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE account = ?", Integer.class, req.getAccount());
        if (count != null && count > 0) {
            return "帳號已存在";
        }
        jdbcTemplate.update("INSERT INTO users (account, password, enabled) VALUES (?, ?, ?)", req.getAccount(), passwordEncoder.encode(req.getPassword()), true);
        return "註冊成功";
    }

    // 取得目前登入使用者
    @GetMapping("/me")
    public String getCurrentUser(Principal principal) {
        return principal != null ? principal.getName() : "未登入";
    }
}
