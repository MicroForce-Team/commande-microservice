package com.microforce.commandemicroservice.DTO.order;

import com.microforce.commandemicroservice.DTO.delivery.DeliveryDTO;
import com.microforce.commandemicroservice.DTO.orderItem.OrderItemDTO;
import com.microforce.commandemicroservice.domain.entities.Delivery;
import com.microforce.commandemicroservice.domain.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private UUID id;
    private String reference;
    private LocalDateTime creationDate;
    private OrderStatus status;
    private List<OrderItemDTO> orderItems;
    private DeliveryDTO delivery;
    private UUID userId;

}
