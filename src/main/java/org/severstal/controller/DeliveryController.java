package org.severstal.controller;

import org.severstal.dto.DeliveryRequestDto;
import org.severstal.dto.DeliveryResponseDto;
import org.severstal.service.DeliveryService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping
    public DeliveryResponseDto accept(@RequestBody DeliveryRequestDto request) {
        return deliveryService.acceptDelivery(request);
    }
}
