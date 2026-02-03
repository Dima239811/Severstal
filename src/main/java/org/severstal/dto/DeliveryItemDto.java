package org.severstal.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryItemDto {
    private Long productId;
    private BigDecimal weightKg;

    public DeliveryItemDto(Long productId, BigDecimal weightKg) {
        this.productId = productId;
        this.weightKg = weightKg;
    }
}
