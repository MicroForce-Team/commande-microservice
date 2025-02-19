package com.microforce.commandemicroservice.service;

import com.microforce.commandemicroservice.DTO.OrderRequest;
import com.microforce.commandemicroservice.DTO.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);
}
