package org.severstal.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryItemResponseDto {
    private Long id;
    private ProductDTO product;
    private BigDecimal weightKg;
    private BigDecimal pricePerKg;
}
