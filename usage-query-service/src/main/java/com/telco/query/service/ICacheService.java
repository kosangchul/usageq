// File: usage-query-service/src/main/java/com/telco/query/service/ICacheService.java
package com.telco.query.service;

import com.telco.common.dto.CacheStatus;
import java.util.Optional;

public interface ICacheService<T> {
    Optional<T> get(String key);
    void set(String key, T value);
    void delete(String key);
    CacheStatus getStatus();
}