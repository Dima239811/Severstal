package org.severstal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class DeliveryRequestDto {
    private Long supplierId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate deliveryDate;

    private List<DeliveryItemDto> items;

    public DeliveryRequestDto(Long supplierId, LocalDate deliveryDate, List<DeliveryItemDto> items) {
        this.supplierId = supplierId;
        this.deliveryDate = deliveryDate;
        this.items = items;
    }
}
