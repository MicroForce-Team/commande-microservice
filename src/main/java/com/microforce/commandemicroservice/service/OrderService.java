package com.microforce.commandemicroservice.service;

import com.microforce.commandemicroservice.DTO.OrderRequest;
import com.microforce.commandemicroservice.DTO.OrderResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);
    Page<OrderResponse> getAllOrders(Pageable pageable);
    OrderResponse getOrderById(UUID id);
    public void deleteOrder(UUID id);
}
