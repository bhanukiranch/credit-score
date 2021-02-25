package com.credit.score.api.calculate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CreditScoreRepository extends JpaRepository<CreditScore, String>,
        JpaSpecificationExecutor<CreditScore> {
    Optional<CreditScore> findBySsnNumber(String ssnNumber);
}
