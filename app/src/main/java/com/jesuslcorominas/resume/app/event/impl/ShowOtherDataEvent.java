package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.commons.model.OtherData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jesús López Corominas
 */
public class ShowOtherDataEvent implements Event {

    private final List<OtherData> otherDataList;

    public ShowOtherDataEvent(List<OtherData> otherDataList) {
        this.otherDataList = otherDataList;
    }

    public List<OtherData> getOtherDataList() {
        return otherDataList;
    }
}
