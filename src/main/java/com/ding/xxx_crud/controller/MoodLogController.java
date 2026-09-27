package com.ding.xxx_crud.controller;

import com.ding.xxx_crud.MoodLog;
import com.ding.xxx_crud.dto.MoodLogRequestDto;
import com.ding.xxx_crud.MoodLogService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

//@CrossOrigin(origins = {"https://moolog.dpdns.org", "http://localhost:4200"},allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MoodLogController {
    private final MoodLogService service;
    public MoodLogController(MoodLogService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String health() { return "OK"; }
    @GetMapping("/hello")
    public String hello(){
        return "09/18. Hello fucking world.";
    }
    @GetMapping("/logs")
    public List<MoodLog> getAll(Principal principal){
        return service.findAll(principal.getName());
    }
    @PostMapping("/logs")
    public MoodLog create(@Valid @RequestBody MoodLogRequestDto req, Principal principal){
        return service.create(req, principal.getName());
    }
    @GetMapping("/logs/{id}")
    public MoodLog getById(@PathVariable UUID id, Principal principal) {
        return service.findById(id, principal.getName());
    }

    @PutMapping("/logs/{id}")
    public MoodLog update(@PathVariable UUID id, @Valid @RequestBody MoodLogRequestDto req, Principal principal) {
        return service.update(id, req, principal.getName());
    }

    @DeleteMapping("/logs/{id}")
    public void delete(@PathVariable UUID id, Principal principal) {
        service.delete(id, principal.getName());
    }
}
