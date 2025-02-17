package com.microforce.commandemicroservice.service.implementations;

import com.microforce.commandemicroservice.domain.entities.Order;
import com.microforce.commandemicroservice.domain.enums.OrderStatus;
import com.microforce.commandemicroservice.repository.OrderRepository;
import com.microforce.commandemicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

}
