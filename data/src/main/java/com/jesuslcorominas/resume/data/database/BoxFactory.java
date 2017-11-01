package com.jesuslcorominas.resume.data.database;

import javax.inject.Inject;

import io.objectbox.BoxStore;

/**
 * @author Jesús López Corominas
 */
public class BoxFactory {

    private BoxStore boxStore;

    @Inject
    public BoxFactory(BoxStore boxStore) {
        this.boxStore = boxStore;
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
