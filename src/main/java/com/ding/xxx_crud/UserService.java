package com.ding.xxx_crud;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JdbcTemplate jdbcTemplate;
    public UUID getIdByAccount(String account) {
        return jdbcTemplate.queryForObject(
                "SELECT id FROM users WHERE account = ?", UUID.class, account
        );
    }
}
