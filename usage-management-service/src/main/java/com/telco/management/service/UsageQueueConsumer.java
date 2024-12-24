// File: usage-management-service/src/main/java/com/telco/management/service/UsageQueueConsumer.java
package com.telco.management.service;

import com.telco.common.dto.UsageDTO;
import com.telco.common.dto.UsageUpdateRequest;
import com.telco.management.entity.*;
import com.telco.management.mapper.UsageMapper;
import com.telco.management.repository.UsageRepository;
import com.telco.management.service.cache.ICacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UsageQueueConsumer {

    private final UsageRepository usageRepository;
    private final ICacheService<UsageDTO> cacheService;
    private final UsageMapper usageMapper;

    @Autowired
    public UsageQueueConsumer(UsageRepository usageRepository,
                              ICacheService<UsageDTO> cacheService,
                              UsageMapper usageMapper) {
        this.usageRepository = usageRepository;
        this.cacheService = cacheService;
        this.usageMapper = usageMapper;
    }

    @RabbitListener(queues = "usage.queue")
    @Transactional
    public void processUsageUpdate(UsageUpdateRequest request) {
        if (request == null || request.getUserId() == null) {
            log.error("Invalid usage update request");
            return;
        }

        String userId = request.getUserId();
        log.info("Received usage update request for userId: {}", userId);

        try {
            Usage usage = usageRepository.findByUserId(userId)
                    .orElseGet(() -> createNewUsage(userId));

            updateUsage(usage, request);
            usageRepository.save(usage);
            updateCache(usage);

            log.info("Successfully processed usage update for userId: {}", userId);

        } catch (Exception e) {
            log.error("Failed to process usage update for userId: {}, error: {}",
                    userId, e.getMessage());
            throw e;
        }
    }

    private Usage createNewUsage(String userId) {
        return Usage.builder()
                .userId(userId)
                .voiceUsage(new VoiceUsage(0L, 18000L))
                .videoUsage(new VideoUsage(0L, 7200L))
                .messageUsage(new MessageUsage(0L, 300L))
                .dataUsage(new DataUsage(0L, 5368709120L))
                .build();
    }

    private void updateUsage(Usage usage, UsageUpdateRequest request) {
        if (request.getType() == null || request.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid usage type or amount");
        }

        usage.updateUsage(request.getType(), request.getAmount());
    }

    private void updateCache(Usage usage) {
        try {
            UsageDTO usageDTO = usageMapper.toDTO(usage);
            String cacheKey = String.format("usage:%s", usage.getUserId());
            cacheService.set(cacheKey, usageDTO);
        } catch (Exception e) {
            log.error("Failed to update cache for userId: {}, error: {}",
                    usage.getUserId(), e.getMessage());
        }
    }
}