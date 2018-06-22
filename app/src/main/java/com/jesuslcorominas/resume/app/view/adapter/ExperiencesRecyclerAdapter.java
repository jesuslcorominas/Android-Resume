package com.jesuslcorominas.resume.app.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import com.jesuslcorominas.resume.app.view.adapter.item.ExperienceItemView;
import com.jesuslcorominas.resume.app.view.adapter.item.ExperienceItemView_;
import com.jesuslcorominas.resume.commons.model.Experience;
import com.jesuslcorominas.resume.data.entity.ExperienceObjectBoxEntity;

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
        ExperienceItemView itemView =  ExperienceItemView_.build(context);
        itemView.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT));

        return itemView;
    }
}
