package com.jesuslcorominas.resume.app.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jesuslcorominas.resume.app.view.adapter.item.KnowledgeItemView;
import com.jesuslcorominas.resume.app.view.adapter.item.KnowledgeItemView_;
import com.jesuslcorominas.resume.app.view.adapter.item.OtherDataItemView;
import com.jesuslcorominas.resume.app.view.adapter.item.OtherDataItemView_;
import com.jesuslcorominas.resume.data.entity.Knowledge;
import com.jesuslcorominas.resume.data.entity.OtherData;

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
        return KnowledgeItemView_.build(context);
    }
}
