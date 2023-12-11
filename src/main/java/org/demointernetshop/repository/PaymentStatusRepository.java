package org.demointernetshop.repository;

import org.demointernetshop.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Integer> {

    Optional<PaymentStatus> findByStatus(String status);

}
