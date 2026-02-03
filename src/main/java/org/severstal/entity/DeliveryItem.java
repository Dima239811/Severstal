package org.severstal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "delivery_items")
@NoArgsConstructor
public class DeliveryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Delivery delivery;

    @ManyToOne
    private Product product;

    private BigDecimal weightKg;

    private BigDecimal pricePerKg;
}
