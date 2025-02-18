package com.microforce.commandemicroservice.service;

import com.microforce.commandemicroservice.DTO.OrderRequest;
import com.microforce.commandemicroservice.domain.entities.Order;

public interface OrderService {

    Order createOrder(OrderRequest orderRequest);
}
