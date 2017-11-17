package com.jesuslcorominas.resume.app.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jesuslcorominas.resume.app.view.adapter.item.ExperienceItemView;
import com.jesuslcorominas.resume.app.view.adapter.item.ExperienceItemView_;
import com.jesuslcorominas.resume.data.entity.Experience;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * @author Jesús López Corominas
 */
@EBean
public class ExperiencesRecyclerAdapter extends RecyclerViewBaseAdapter<Experience, ExperienceItemView> {

    @RootContext
    Context context;

    @Override
    protected ExperienceItemView onCreateItemView(ViewGroup parent, int viewType) {
        return ExperienceItemView_.build(context);
    }
}
