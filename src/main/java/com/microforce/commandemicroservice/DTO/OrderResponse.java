package com.microforce.commandemicroservice.DTO;

import com.microforce.commandemicroservice.domain.entities.OrderItem;
import com.microforce.commandemicroservice.domain.enums.DeliveryStatus;
import com.microforce.commandemicroservice.domain.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private UUID id;

    private String reference;

    private LocalDateTime creationDate;

    private OrderStatus status;

    private Long totalAmount;

    private String deliveryTrackingNumber;

    private DeliveryStatus deliveryStatus;

    private List<OrderItemDTO> orderItems;
}
