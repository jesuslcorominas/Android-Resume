package com.jesuslcorominas.resume.app.view.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowKnowledgesEvent;
import com.jesuslcorominas.resume.app.view.adapter.KnowledgesRecyclerAdapter;
import com.jesuslcorominas.resume.app.view.adapter.divider.HorizontalSpaceItemDecoration;
import com.jesuslcorominas.resume.app.view.adapter.divider.VerticalSpaceItemDecoration;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

/**
 * @author Jesús López Corominas
 */
@EFragment(R.layout.fragment_knowledges)
public class KnowledgesFragment extends AbstractBaseFragment {

    private static final int COLUMNS = 3;

    @ViewById(R.id.fragment_knowledges_recyclerView_knowledges)
    RecyclerView recyclerViewKnowledges;

    @Bean
    KnowledgesRecyclerAdapter knowledgesRecyclerAdapter;

    @Bean
    HorizontalSpaceItemDecoration horizontalSpaceItemDecoration;

    @Bean
    VerticalSpaceItemDecoration verticalSpaceItemDecoration;

    // =========================================
    //  NewInstance
    // =========================================
    public static KnowledgesFragment newInstance() {
        return KnowledgesFragment_.builder().build();
    }

    // =========================================
    //  AbstractBaseFragment
    // =========================================
    @Override
    void init() {
        recyclerViewKnowledges.setAdapter(knowledgesRecyclerAdapter);

        verticalSpaceItemDecoration.setHeightDimen(R.dimen.margin);
        horizontalSpaceItemDecoration.setWidthDimen(R.dimen.margin);

        recyclerViewKnowledges.addItemDecoration(verticalSpaceItemDecoration);
        recyclerViewKnowledges.addItemDecoration(horizontalSpaceItemDecoration);


        recyclerViewKnowledges.setLayoutManager(new GridLayoutManager(getActivity(), COLUMNS));
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onShowKnowledgesEvent(ShowKnowledgesEvent event) {
        knowledgesRecyclerAdapter.addItems(event.getKnowledges());
    }
}
