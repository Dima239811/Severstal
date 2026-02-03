package org.severstal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class SupplierPriceRequestDto {
    private Long supplierId;
    private Long productId;
    private BigDecimal pricePerKg;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
