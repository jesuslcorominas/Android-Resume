package com.jesuslcorominas.resume.data.database.converter;

import com.jesuslcorominas.resume.commons.model.KnowledgeLevel;

import io.objectbox.converter.PropertyConverter;

/**
 * @author Jesús López Corominas
 */
public class KnowledgeLevelConverter implements PropertyConverter <KnowledgeLevel, Integer> {

    @Override
    public KnowledgeLevel convertToEntityProperty(Integer databaseValue) {
        return KnowledgeLevel.getKnowledgeLevel(databaseValue);
    }

    @Override
    public Integer convertToDatabaseValue(KnowledgeLevel entityProperty) {
        return entityProperty == null ? null : entityProperty.getValue();
    }
}
