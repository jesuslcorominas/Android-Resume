package com.jesuslcorominas.resume.app.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import com.jesuslcorominas.resume.app.view.adapter.item.OtherDataItemView;
import com.jesuslcorominas.resume.app.view.adapter.item.OtherDataItemView_;
import com.jesuslcorominas.resume.commons.model.OtherData;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * @author Jesús López Corominas
 */
@EBean
public class OtherDataRecyclerAdapter extends RecyclerViewBaseAdapter<OtherData, OtherDataItemView> {

    @RootContext
    Context context;

    @Override
    protected OtherDataItemView onCreateItemView(ViewGroup parent, int viewType) {
        OtherDataItemView itemView = OtherDataItemView_.build(context);
        itemView.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, CardView.LayoutParams.WRAP_CONTENT));

        return itemView;
    }
}
