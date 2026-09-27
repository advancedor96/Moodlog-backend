package com.ding.xxx_crud.dto;

import java.util.Map;

public record ErrorResponseDto(
        int status,
        String message,
        Map<String, String> errors
) {
}
