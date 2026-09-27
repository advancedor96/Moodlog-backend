package com.ding.xxx_crud.config;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String sql = "SELECT account, password, enabled FROM users WHERE account = ?";
        try {
            return jdbcTemplate.queryForObject(sql,
                    (rs, rowNum) -> User.builder()
                                    .username(rs.getString("account"))
                                    .password(rs.getString("password"))
                                    .disabled(!rs.getBoolean("enabled"))
                                    .roles("USER")  // 沒有 authorities 表，直接固定給
                                    .build(),
                    username
            );
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("找不到帳號: " + username);
        }
    }
}
