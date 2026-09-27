package com.ding.xxx_crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MoodLogRequestDto(
        @NotNull
        LocalDate entryDate,
        @NotBlank
        String mood,

        String content
) {
}
