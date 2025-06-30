package com.example.userservice.controller;

import com.example.userservice.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PostMapping("/{key}")
    public String save(@PathVariable String key, @RequestBody String value) {
        redisService.save(key, value);
        return "Saved!";
    }

    @GetMapping("/{key}")
    public String get(@PathVariable String key) {
        return redisService.get(key);
    }

    @DeleteMapping("/{key}")
    public String delete(@PathVariable String key) {
        redisService.delete(key);
        return "Deleted!";
    }
}