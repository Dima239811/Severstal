package org.severstal.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReportDto {
    private Long supplierId;
    private String supplierName;
    private String  productKind;
    private BigDecimal totalWeight;
    private BigDecimal totalCost;

    public ReportDto(Long supplierId, String supplierName, String  productKind, BigDecimal totalWeight, BigDecimal totalCost) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.productKind = productKind;
        this.totalWeight = totalWeight;
        this.totalCost = totalCost;
    }
}
