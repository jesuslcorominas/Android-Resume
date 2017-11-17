package com.jesuslcorominas.resume.app.event.impl;

import com.jesuslcorominas.resume.app.event.Event;
import com.jesuslcorominas.resume.data.entity.OtherData;

import java.util.ArrayList;

/**
 * @author Jesús López Corominas
 */
public class ShowOtherDataEvent implements Event {

    private final ArrayList<OtherData> otherDataList;

    public ShowOtherDataEvent(ArrayList<OtherData> otherDataList) {
        this.otherDataList = otherDataList;
    }

    public ArrayList<OtherData> getOtherDataList() {
        return otherDataList;
    }
}
