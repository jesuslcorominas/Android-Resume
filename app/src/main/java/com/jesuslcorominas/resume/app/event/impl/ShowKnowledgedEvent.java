package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.data.entity.Knowledge;

import java.util.ArrayList;

/**
 * @author Jesús López Corominas
 */
public class ShowKnowledgedEvent implements Event {

    private final ArrayList<Knowledge> knowledges;

    public ShowKnowledgedEvent(ArrayList<Knowledge> knowledges) {
        this.knowledges = knowledges;
    }

    public ArrayList<Knowledge> getKnowledges() {
        return knowledges;
    }
}
