// File: usage-management-service/src/main/java/com/telco/management/repository/UsageRepository.java
package com.telco.management.repository;

import com.telco.management.entity.Usage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsageRepository extends JpaRepository<Usage, Long> {

    // findByUserId 메서드 - Optional 리턴
    Optional<Usage> findByUserId(String userId);

    // existsByUserId 메서드 - boolean 리턴
    boolean existsByUserId(String userId);

    // findByUserIdWithLock 메서드 - JPQL 쿼리 수정
    @Query("SELECT u FROM Usage u WHERE u.userId = :userId")
    Optional<Usage> findByUserIdWithLock(@Param("userId") String userId);
}