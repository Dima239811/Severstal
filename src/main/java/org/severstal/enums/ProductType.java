package org.severstal.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.severstal.exception.IncorrectEnumValue;

public enum ProductType {
    APPLE,
    PEAR;


    @JsonCreator
    public static ProductType fromValue(String value) {
        for (ProductType type : values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IncorrectEnumValue("Unknown ProductType: " + value);
    }
}
