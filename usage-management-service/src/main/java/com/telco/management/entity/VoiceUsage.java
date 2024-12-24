package com.telco.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VoiceUsage {
    @Column(name = "voice_total_usage")
    private long totalUsage;

    @Column(name = "voice_free_usage")
    private long freeUsage;

    @Column(name = "voice_excess_usage")
    private long excessUsage;

    @Builder
    public VoiceUsage(long totalUsage, long freeUsage) {
        this.totalUsage = totalUsage;
        this.freeUsage = freeUsage;
        calculateExcessUsage();
    }

    public void addUsage(long amount) {
        this.totalUsage += amount;
        calculateExcessUsage();
    }

    private void calculateExcessUsage() {
        this.excessUsage = Math.max(0, totalUsage - freeUsage);
    }
}