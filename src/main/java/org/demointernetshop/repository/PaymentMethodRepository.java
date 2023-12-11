package org.demointernetshop.repository;

import org.demointernetshop.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {

    Optional<PaymentMethod> findByMethod(String method);

}
