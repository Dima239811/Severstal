package org.severstal.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SupplierPriceRequestDto {
    private Long supplierId;
    private Long productId;
    private BigDecimal pricePerKg;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public SupplierPriceRequestDto(Long supplierId, Long productId, BigDecimal pricePerKg, LocalDate dateFrom, LocalDate dateTo) {
        this.supplierId = supplierId;
        this.productId = productId;
        this.pricePerKg = pricePerKg;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
