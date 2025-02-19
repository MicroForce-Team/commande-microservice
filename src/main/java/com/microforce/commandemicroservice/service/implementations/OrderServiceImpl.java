package com.microforce.commandemicroservice.service.implementations;



import com.microforce.commandemicroservice.DTO.OrderMapper;
import com.microforce.commandemicroservice.DTO.OrderRequest;
import com.microforce.commandemicroservice.DTO.OrderResponse;
import com.microforce.commandemicroservice.domain.entities.Delivery;
import com.microforce.commandemicroservice.domain.entities.Order;
import com.microforce.commandemicroservice.domain.entities.OrderItem;
import com.microforce.commandemicroservice.domain.enums.DeliveryStatus;
import com.microforce.commandemicroservice.domain.enums.OrderStatus;
import com.microforce.commandemicroservice.exception.OrderNotFoundException;
import com.microforce.commandemicroservice.repository.OrderRepository;
import com.microforce.commandemicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest) {

        Order order = Order.builder()
                .userId(orderRequest.getUserId())
                .creationDate(LocalDateTime.now())
                .status(OrderStatus.PENDING)
                .reference(UUID.randomUUID().toString())
                .orderItems(new ArrayList<OrderItem>())
                .build();

        long totalAmount = 0L;
        for (OrderItem item : orderRequest.getOrderItems()) {
            order.addOrderItem(item);
            totalAmount += (item.getPrice() * item.getQuantity());
        }
        order.setTotalAmount(totalAmount);

        Delivery delivery = Delivery.builder()
                .order(order)
                .status(DeliveryStatus.PREPARED)
                .trackingNumber(UUID.randomUUID().toString())
                .build();

        order.setDelivery(delivery);

        Order savedOrder =   orderRepository.save(order);
        return orderMapper.ToOrderResponse(savedOrder);
    }

    @Override
    public Page<OrderResponse> getAllOrders(Pageable pageable) {
        Page<Order> ordersPage = orderRepository.findAll(pageable);
        return ordersPage.map(orderMapper::ToOrderResponse);
    }

    @Override
    public OrderResponse getOrderById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        return orderMapper.ToOrderResponse(order);
    }

}
