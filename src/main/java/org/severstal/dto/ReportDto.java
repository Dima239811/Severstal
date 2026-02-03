package org.severstal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ReportDto {
    private Long supplierId;
    private String supplierName;
    private String  productKind;
    private BigDecimal totalWeight;
    private BigDecimal totalCost;
}
