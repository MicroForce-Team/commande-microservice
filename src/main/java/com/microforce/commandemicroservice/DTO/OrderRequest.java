package com.microforce.commandemicroservice.DTO;

import com.microforce.commandemicroservice.domain.entities.OrderItem;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    @NotNull(message = "user id is required")
    private UUID userId;
    @NotEmpty(message = "")
    private List<OrderItem> orderItems;

}
