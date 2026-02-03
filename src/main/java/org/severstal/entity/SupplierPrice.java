package org.severstal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "supplier_prices")
public class SupplierPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Product product;

    private BigDecimal pricePerKg;

    private LocalDate dateFrom;
    private LocalDate dateTo;
}
