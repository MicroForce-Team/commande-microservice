package com.microforce.commandemicroservice.DTO.delivery;

import com.microforce.commandemicroservice.domain.enums.DeliveryStatus;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryDTO {
    private UUID id;
    private String trackingNumber;
    private DeliveryStatus status;
}
