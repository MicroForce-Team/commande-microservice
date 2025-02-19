package com.microforce.commandemicroservice.DTO;


import com.microforce.commandemicroservice.domain.entities.Order;
import com.microforce.commandemicroservice.domain.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "deliveryTrackingNumber", source = "delivery.trackingNumber")
    @Mapping(target = "deliveryStatus", source = "delivery.status")
    @Mapping(source = "orderItems", target = "orderItems")
    OrderResponse ToOrderResponse(Order order);



    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "subtotal", target = "subtotal")

    OrderItemDTO orderItemToOrderItemDTO(OrderItem orderItem);

}
