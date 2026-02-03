package org.severstal.service;

import org.severstal.dto.SupplierPriceRequestDto;
import org.severstal.entity.Product;
import org.severstal.entity.Supplier;
import org.severstal.entity.SupplierPrice;
import org.severstal.exception.BadRequestException;
import org.severstal.exception.NotFoundException;
import org.severstal.repository.ProductRepository;
import org.severstal.repository.SupplierPriceRepository;
import org.severstal.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierPriceService {
    private final SupplierPriceRepository priceRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    public SupplierPriceService(SupplierPriceRepository priceRepository,
                                SupplierRepository supplierRepository,
                                ProductRepository productRepository) {
        this.priceRepository = priceRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    public SupplierPrice create(SupplierPriceRequestDto dto) {

        Supplier supplier = supplierRepository.findById(dto.getSupplierId())
                .orElseThrow(() -> new NotFoundException("Supplier not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new NotFoundException("Product not found"));

        boolean overlap = priceRepository.existsOverlap(
                supplier,
                product,
                dto.getDateFrom(),
                dto.getDateTo()
        );

        if (overlap) {
            throw new BadRequestException("Price already exists for this product and date range");
        }

        SupplierPrice price = new SupplierPrice();
        price.setSupplier(supplier);
        price.setProduct(product);
        price.setPricePerKg(dto.getPricePerKg());
        price.setDateFrom(dto.getDateFrom());
        price.setDateTo(dto.getDateTo());

        return priceRepository.save(price);
    }

    public List<SupplierPrice> getAll() {
        return priceRepository.findAll();
    }
}
