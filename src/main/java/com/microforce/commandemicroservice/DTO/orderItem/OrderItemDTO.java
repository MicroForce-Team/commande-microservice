package com.microforce.commandemicroservice.DTO.orderItem;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemDTO {
    private UUID id;
    private UUID productId;
    private Integer quantity;
    private BigDecimal price;
}
