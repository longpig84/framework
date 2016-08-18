package com.vaadin.tests.components.abstractfield;

import java.util.Locale;

import com.vaadin.legacy.data.util.converter.LegacyConverter;

public class Vaadin6ImplicitDoubleConverter
        implements LegacyConverter<String, Double> {

    @Override
    public Double convertToModel(String value,
            Class<? extends Double> targetType, Locale locale)
            throws com.vaadin.legacy.data.util.converter.LegacyConverter.ConversionException {
        if (null == value) {
            return null;
        }
        return new Double(value.toString());
    }

    @Override
    public String convertToPresentation(Double value,
            Class<? extends String> targetType, Locale locale)
            throws com.vaadin.legacy.data.util.converter.LegacyConverter.ConversionException {
        if (value == null) {
            return null;
        }
        return value.toString();

    }

    @Override
    public Class<Double> getModelType() {
        return Double.class;
    }

    @Override
    public Class<String> getPresentationType() {
        return String.class;
    }

}