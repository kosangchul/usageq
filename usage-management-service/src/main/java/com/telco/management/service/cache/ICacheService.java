package com.telco.management.service.cache;

import com.telco.common.dto.CacheStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICacheService<T> {
    Optional<T> get(String key);
    void set(String key, T value);
    void delete(String key);
    CacheStatus getStatus();
}