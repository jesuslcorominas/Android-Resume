package com.jesuslcorominas.resume.data.database.converter;

import com.jesuslcorominas.resume.data.entity.Position;

import io.objectbox.converter.PropertyConverter;

/**
 * @author Jesús López Corominas
 */
public class PositionConverter implements PropertyConverter<Position, Integer> {

    @Override
    public Position convertToEntityProperty(Integer databaseValue) {
        return Position.getPosition(databaseValue);
    }

    @Override
    public Integer convertToDatabaseValue(Position entityProperty) {
        return entityProperty == null ? null : entityProperty.getValue();
    }
}
