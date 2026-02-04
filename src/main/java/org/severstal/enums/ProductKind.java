package org.severstal.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.severstal.exception.IncorrectEnumValue;

public enum ProductKind {
    GOLDEN,
    RED,
    CONFERENCE,
    WILLIAMS;

    @JsonCreator
    public static ProductKind fromValue(String value) {
        for (ProductKind kind : values()) {
            if (kind.name().equalsIgnoreCase(value)) {
                return kind;
            }
        }
        throw new IncorrectEnumValue("Unknown ProductKind: " + value);
    }
}
