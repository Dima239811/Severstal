package org.severstal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.severstal.enums.ProductKind;
import org.severstal.enums.ProductType;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Enumerated(EnumType.STRING)
    private ProductKind kind;

    @Transient
    private String name;

    public String getName() {
        return type + " " + kind;
    }
}
