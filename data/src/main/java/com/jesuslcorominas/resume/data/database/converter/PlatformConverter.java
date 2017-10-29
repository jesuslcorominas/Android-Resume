package com.jesuslcorominas.resume.data.database.converter;

import com.jesuslcorominas.resume.data.entity.Platform;

import io.objectbox.converter.PropertyConverter;

/**
 * @author Jesús López Corominas
 */
public class PlatformConverter implements PropertyConverter<Platform, Integer> {

    @Override
    public Platform convertToEntityProperty(Integer databaseValue) {
        return Platform.getPlatform(databaseValue);
    }

    @Override
    public Integer convertToDatabaseValue(Platform entityProperty) {
        return entityProperty == null ? null : entityProperty.getValue();
    }
}