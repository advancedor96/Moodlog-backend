package com.ding.xxx_crud;

import com.ding.xxx_crud.dto.MoodLogRequestDto;
import com.ding.xxx_crud.exception.MyException;
import com.ding.xxx_crud.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MoodLogService {
    private final MoodLogRepository repository;
    private final UserService userService;

    public MoodLogService(MoodLogRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }
    public List<MoodLog> findAll(String account) {
        UUID userId = userService.getIdByAccount(account);
        return repository.findByUserId(userId);
    }
    public MoodLog findById(UUID id, String account) {
        MoodLog moodLog = repository.findById(id).orElseThrow(()-> new NotFoundException(id));

        UUID userId = userService.getIdByAccount(account);
        if (!moodLog.userId().equals(userId)) {
            throw new MyException(403, "❌ can't find another user's data.");
        }
        return moodLog;
    }
    public MoodLog create(MoodLogRequestDto req, String account) {
        UUID userId = userService.getIdByAccount(account);
        MoodLog moodLog = new MoodLog(
                null,
                userId,
                req.entryDate(),
                req.mood(),
                req.content()
        );
        return repository.save(moodLog);
    }


    public MoodLog update(UUID id, MoodLogRequestDto req, String account) {
        MoodLog old = repository.findById(id).orElseThrow(()-> new NotFoundException(id));
        UUID userId = userService.getIdByAccount(account);
        if (!old.userId().equals(userId)) {
            throw new MyException(403, "❌ can't modify another user's data.");
        }
        MoodLog updated = new MoodLog(
                old.id(),
                old.userId(),
                req.entryDate(),
                req.mood(),
                req.content()
        );
        return repository.save(updated);
    }
    public void delete(UUID id, String account) {
        MoodLog ml = repository.findById(id).orElseThrow(()->new NotFoundException(id));
        UUID userId = userService.getIdByAccount(account);
        if (!ml.userId().equals(userId)) {
            throw new MyException(403, "❌can't delete another user's data.");
        }
        repository.delete(ml);
    }
}
