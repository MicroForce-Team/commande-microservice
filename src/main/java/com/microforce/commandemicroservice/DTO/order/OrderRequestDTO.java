package com.microforce.commandemicroservice.DTO.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDTO {
    @NotNull(message = "user id cant be null")
    private UUID userId;
    @NotBlank(message = "reference cant be blank")
    private String reference;

}
