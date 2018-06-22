package com.jesuslcorominas.resume.data.database.converter;

import com.jesuslcorominas.resume.commons.model.KnowledgeType;

import io.objectbox.converter.PropertyConverter;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeTypeConverter implements PropertyConverter<KnowledgeType, Integer> {

    @Override
    public KnowledgeType convertToEntityProperty(Integer databaseValue) {
        return KnowledgeType.getKnowledgeType(databaseValue);
    }

    @Override
    public Integer convertToDatabaseValue(KnowledgeType entityProperty) {
        return entityProperty == null ? null : entityProperty.getValue();
    }
}