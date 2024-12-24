// File: usage-query-service/src/main/java/com/telco/query/service/RedisCacheService.java
package com.telco.query.service;

import com.telco.common.dto.CacheStatus;
import com.telco.common.dto.UsageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisCacheService implements ICacheService<UsageDTO> {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final long DEFAULT_TTL = 600; // 10분

    @Override
    public Optional<UsageDTO> get(String key) {
        try {
            Object value = redisTemplate.opsForValue().get(key);
            if (value != null) {
                redisTemplate.expire(key, DEFAULT_TTL, TimeUnit.SECONDS);
                return Optional.of((UsageDTO) value);
            }
            return Optional.empty();
        } catch (Exception e) {
            log.error("Failed to get value from cache - key: {}, error: {}", key, e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void set(String key, UsageDTO value) {
        try {
            redisTemplate.opsForValue().set(key, value, DEFAULT_TTL, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Failed to set value to cache - key: {}, error: {}", key, e.getMessage());
        }
    }

    @Override
    public void delete(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            log.error("Failed to delete value from cache - key: {}, error: {}", key, e.getMessage());
        }
    }

    @Override
    public CacheStatus getStatus() {
        try {
            long size = Optional.ofNullable(redisTemplate.keys("*"))
                    .map(keys -> (long) keys.size())
                    .orElse(0L);

            return CacheStatus.builder()
                    .totalSize(size)
                    .usedSize(size)
                    .hitCount(0L)
                    .missCount(0L)
                    .build();
        } catch (Exception e) {
            log.error("Failed to get cache status: {}", e.getMessage());
            return CacheStatus.builder().build();
        }
    }
}