package com.jesuslcorominas.resume.data.database;

import io.objectbox.BoxStore;

/**
 * @author Jesús López Corominas
 */
public class BoxFactory {

    private BoxStore boxStore;

    public BoxStore getBoxStore() {
        return boxStore;
    }

    public BoxFactory(BoxStore boxStore) {
        this.boxStore = boxStore;
    }
}
