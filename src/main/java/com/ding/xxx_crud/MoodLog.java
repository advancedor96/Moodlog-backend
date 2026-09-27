package com.ding.xxx_crud;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("mood_fuck_logs")
public record MoodLog(
        @Id
        UUID id,
        UUID userId,
        LocalDate entryDate,
        String mood,
        String content
) {
}
