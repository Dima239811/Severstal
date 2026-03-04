package org.severstal.repository;

import org.severstal.entity.Product;
import org.severstal.entity.SupplierPrice;
import org.severstal.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface SupplierPriceRepository extends JpaRepository<SupplierPrice, Long> {
    List<SupplierPrice> findBySupplierAndProductAndDateFromLessThanEqualAndDateToGreaterThanEqual(
            Supplier supplier, Product product, LocalDate from, LocalDate to
    );

    @Query("""
    select case when count(sp) > 0 then true else false end
    from SupplierPrice sp
    where sp.supplier = :supplier
      and sp.product = :product
      and sp.dateFrom <= :dateTo
      and sp.dateTo >= :dateFrom
""")
    boolean existsOverlap(
            @Param("supplier") Supplier supplier,
            @Param("product") Product product,
            @Param("dateFrom") LocalDate dateFrom,
            @Param("dateTo") LocalDate dateTo
    );

    @Query("SELECT sp FROM SupplierPrice sp " +
            "WHERE sp.supplier = :supplier " +
            "AND sp.product.id IN :productIds " +
            "AND :date >= sp.dateFrom " +
            "AND :date <= sp.dateTo")
    List<SupplierPrice> findPrices(
            @Param("supplier") Supplier supplier,
            @Param("productIds") Collection<Long> productIds,
            @Param("date") LocalDate date
    );
}
