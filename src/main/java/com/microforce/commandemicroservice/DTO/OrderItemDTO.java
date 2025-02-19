package com.microforce.commandemicroservice.DTO;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {

    private UUID productId;

    private Integer quantity;

    private Long price;

    private Long subtotal;
}
