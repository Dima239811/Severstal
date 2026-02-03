package org.severstal.service;

import jakarta.transaction.Transactional;
import org.severstal.dto.*;
import org.severstal.entity.*;
import org.severstal.exception.NotFoundException;
import org.severstal.repository.DeliveryRepository;
import org.severstal.repository.ProductRepository;
import org.severstal.repository.SupplierPriceRepository;
import org.severstal.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final SupplierPriceRepository supplierPriceRepository;

    public DeliveryService(DeliveryRepository deliveryRepository,
                           SupplierRepository supplierRepository,
                           ProductRepository productRepository,
                           SupplierPriceRepository supplierPriceRepository) {
        this.deliveryRepository = deliveryRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
        this.supplierPriceRepository = supplierPriceRepository;
    }

    public DeliveryResponseDto acceptDelivery(DeliveryRequestDto request) {

        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new NotFoundException("Supplier not found"));

        Delivery delivery = new Delivery();
        delivery.setSupplier(supplier);
        delivery.setDeliveryDate(request.getDeliveryDate());

        List<DeliveryItem> items = new ArrayList<>();

        for (DeliveryItemDto itemDto : request.getItems()) {

            Product product = productRepository.findById(itemDto.getProductId())
                    .orElseThrow(() -> new NotFoundException("Product not found"));

            List<SupplierPrice> prices = supplierPriceRepository
                    .findBySupplierAndProductAndDateFromLessThanEqualAndDateToGreaterThanEqual(
                            supplier,
                            product,
                            request.getDeliveryDate(),
                            request.getDeliveryDate()
                    );

            SupplierPrice price = prices.stream()
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException("Price not found for this date"));

            DeliveryItem item = new DeliveryItem();
            item.setDelivery(delivery);
            item.setProduct(product);
            item.setWeightKg(itemDto.getWeightKg());
            item.setPricePerKg(price.getPricePerKg());

            items.add(item);
        }

        delivery.setItems(items);

        Delivery saved = deliveryRepository.save(delivery);
        return mapToDto(saved);
    }

    private DeliveryResponseDto mapToDto(Delivery delivery) {
        DeliveryResponseDto dto = new DeliveryResponseDto();
        dto.setId(delivery.getId());
        dto.setDeliveryDate(delivery.getDeliveryDate());

        SupplierDTO supplierDto = new SupplierDTO();
        supplierDto.setId(delivery.getSupplier().getId());
        supplierDto.setName(delivery.getSupplier().getName());
        dto.setSupplier(supplierDto);

        List<DeliveryItemResponseDto> items = delivery.getItems().stream().map(item -> {
            DeliveryItemResponseDto itemDto = new DeliveryItemResponseDto();
            itemDto.setId(item.getId());
            itemDto.setWeightKg(item.getWeightKg());
            itemDto.setPricePerKg(item.getPricePerKg());

            ProductDTO productDto = new ProductDTO();
            productDto.setId(item.getProduct().getId());
            productDto.setName(item.getProduct().getName() + " " + item.getProduct().getType());
            itemDto.setProduct(productDto);

            return itemDto;
        }).toList();

        dto.setItems(items);
        return dto;
    }
}
