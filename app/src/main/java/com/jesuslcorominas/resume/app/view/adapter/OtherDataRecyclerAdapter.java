package com.jesuslcorominas.resume.app.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jesuslcorominas.resume.app.view.adapter.item.OtherDataItemView;
import com.jesuslcorominas.resume.app.view.adapter.item.OtherDataItemView_;
import com.jesuslcorominas.resume.data.entity.OtherData;

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
        return OtherDataItemView_.build(context);
    }
}
