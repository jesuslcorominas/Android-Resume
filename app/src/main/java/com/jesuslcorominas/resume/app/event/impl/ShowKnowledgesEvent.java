package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.data.entity.KnowledgeObjectBoxEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ShowKnowledgesEvent implements Event {

    private final List<Knowledge> knowledges;

    public ShowKnowledgesEvent(List<Knowledge> knowledges) {
        this.knowledges = knowledges;
    }

    public List<Knowledge> getKnowledges() {
        return knowledges;
    }
}
