package com.microforce.commandemicroservice.service.implementations;



import com.microforce.commandemicroservice.DTO.OrderRequest;
import com.microforce.commandemicroservice.domain.entities.Delivery;
import com.microforce.commandemicroservice.domain.entities.Order;
import com.microforce.commandemicroservice.domain.entities.OrderItem;
import com.microforce.commandemicroservice.domain.enums.DeliveryStatus;
import com.microforce.commandemicroservice.domain.enums.OrderStatus;
import com.microforce.commandemicroservice.repository.OrderRepository;
import com.microforce.commandemicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order createOrder(OrderRequest orderRequest) {

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

        return  orderRepository.save(order);

    }

}
