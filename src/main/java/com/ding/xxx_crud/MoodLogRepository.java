package com.ding.xxx_crud;

import org.springframework.data.repository.ListCrudRepository;
import java.util.*;

public interface MoodLogRepository extends ListCrudRepository<MoodLog, UUID> {
    List<MoodLog> findByUserId(UUID userId);
}
