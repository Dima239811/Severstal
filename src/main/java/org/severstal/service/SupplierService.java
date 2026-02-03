package org.severstal.service;

import org.severstal.entity.Supplier;
import org.severstal.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> getById(Long id) {
        return supplierRepository.findById(id);
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}
