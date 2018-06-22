package com.jesuslcorominas.resume.app.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import com.jesuslcorominas.resume.app.view.adapter.item.KnowledgeItemView;
import com.jesuslcorominas.resume.app.view.adapter.item.KnowledgeItemView_;
import com.jesuslcorominas.resume.commons.model.Knowledge;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * @author Jesús López Corominas
 */
@EBean
public class KnowledgesRecyclerAdapter extends RecyclerViewBaseAdapter<Knowledge, KnowledgeItemView> {

    @RootContext
    Context context;

    @Override
    protected KnowledgeItemView onCreateItemView(ViewGroup parent, int viewType) {
        KnowledgeItemView itemView = KnowledgeItemView_.build(context);
        itemView.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT));

        return itemView;
    }
}
