package com.jesuslcorominas.resume.app.view.fragment;

import com.jesuslcorominas.resume.app.R;

import org.androidannotations.annotations.EFragment;

/**
 * @author Jesús López Corominas
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends AbstractBaseFragment {

    // =========================================
    //  NewInstance
    // =========================================
    public static MainFragment newInstance() {
        return MainFragment_.builder().build();
    }

    // =========================================
    //  AbstractBaseFragment
    // =========================================
    @Override
    void init() {

    }
}
