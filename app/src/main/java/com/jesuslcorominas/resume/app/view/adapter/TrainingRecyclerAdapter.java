package com.jesuslcorominas.resume.app.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import com.jesuslcorominas.resume.app.view.adapter.item.TrainingItemView;
import com.jesuslcorominas.resume.app.view.adapter.item.TrainingItemView_;
import com.jesuslcorominas.resume.commons.model.Training;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * @author Jesús López Corominas
 */
@EBean
public class TrainingRecyclerAdapter extends RecyclerViewBaseAdapter<Training, TrainingItemView> {

    @RootContext
    Context context;

    @Override
    protected TrainingItemView onCreateItemView(ViewGroup parent, int viewType) {
        TrainingItemView itemView = TrainingItemView_.build(context);
        itemView.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT));

        return itemView;
    }
}
