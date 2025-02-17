package com.microforce.commandemicroservice.service.implementations;


import com.microforce.commandemicroservice.DTO.order.OrderDTOMapper;
import com.microforce.commandemicroservice.DTO.order.OrderRequestDTO;
import com.microforce.commandemicroservice.DTO.order.OrderResponseDto;
import com.microforce.commandemicroservice.domain.entities.Delivery;
import com.microforce.commandemicroservice.domain.entities.Order;
import com.microforce.commandemicroservice.domain.entities.OrderItem;
import com.microforce.commandemicroservice.domain.enums.OrderStatus;
import com.microforce.commandemicroservice.repository.OrderRepository;
import com.microforce.commandemicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDTOMapper orderDTOMapper;

    public OrderResponseDto createOrder(OrderRequestDTO orderDTO) {
        Order order = Order.builder()
                .reference(orderDTO.getReference())
                .creationDate(LocalDateTime.now())
                .status(OrderStatus.PENDING)
                .userId(orderDTO.getUserId())
                .build();

        Order savedOrder = orderRepository.save(order);
        return orderDTOMapper.ToOrderDTO(savedOrder);
    }

}
