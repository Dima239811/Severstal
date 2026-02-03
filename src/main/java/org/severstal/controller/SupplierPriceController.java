package org.severstal.controller;

import org.severstal.dto.SupplierPriceRequestDto;
import org.severstal.entity.SupplierPrice;
import org.severstal.service.SupplierPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class SupplierPriceController {

    private final SupplierPriceService priceService;

    public SupplierPriceController(SupplierPriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping
    public ResponseEntity<SupplierPrice> create(@RequestBody SupplierPriceRequestDto dto) {
        return ResponseEntity.ok(priceService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<SupplierPrice>> getAll() {
        return ResponseEntity.ok(priceService.getAll());
    }
}
