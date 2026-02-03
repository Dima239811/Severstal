package org.severstal.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class DeliveryResponseDto {
    private Long id;
    private SupplierDTO supplier;
    private LocalDate deliveryDate;
    private List<DeliveryItemResponseDto> items;
}
