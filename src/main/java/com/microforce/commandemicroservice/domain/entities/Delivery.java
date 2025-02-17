package com.microforce.commandemicroservice.domain.entities;

import com.microforce.commandemicroservice.domain.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @OneToOne
    private Order order;

    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
