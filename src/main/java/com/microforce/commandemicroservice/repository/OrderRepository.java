package com.microforce.commandemicroservice.repository;

import com.microforce.commandemicroservice.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order> findByReference(String reference);
}
