package org.severstal.repository;

import org.severstal.dto.ReportDto;
import org.severstal.entity.DeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryItemRepository extends JpaRepository<DeliveryItem, Long> {
    @Query("SELECT new org.severstal.dto.ReportDto(" +
            "di.delivery.supplier.id, " +
            "di.delivery.supplier.name, " +
            "CONCAT(di.product.type, ' ', di.product.kind), " +
            "SUM(di.weightKg), " +
            "SUM(di.weightKg * di.pricePerKg)) " +
            "FROM DeliveryItem di " +
            "WHERE di.delivery.deliveryDate BETWEEN :from AND :to " +
            "GROUP BY di.delivery.supplier.id, di.delivery.supplier.name, di.product.type, di.product.kind")
    List<ReportDto> findReport(@Param("from") LocalDate from, @Param("to") LocalDate to);
}
