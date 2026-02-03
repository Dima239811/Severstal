package org.severstal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class DeliveryItemDto {
    private Long productId;
    private BigDecimal weightKg;
}
