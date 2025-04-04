package org.example;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class ConversionResult {
    @JsonbProperty("value")
    private final double value;

    @JsonbCreator
    public ConversionResult(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
