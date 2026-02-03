package org.severstal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DeliveryRequestDto {
    private Long supplierId;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate deliveryDate;

    private List<DeliveryItemDto> items;
}
