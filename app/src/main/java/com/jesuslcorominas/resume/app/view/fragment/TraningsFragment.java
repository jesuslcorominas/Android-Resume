package com.jesuslcorominas.resume.app.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowTrainingsEvent;
import com.jesuslcorominas.resume.app.view.adapter.TrainingRecyclerAdapter;
import com.jesuslcorominas.resume.app.view.adapter.divider.HorizontalSpaceItemDecoration;
import com.jesuslcorominas.resume.app.view.adapter.divider.VerticalSpaceItemDecoration;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

/**
 * @author Jesús López Corominas
 */
@EFragment(R.layout.fragment_trainings)
public class TraningsFragment extends AbstractBaseFragment {

    @ViewById(R.id.fragment_trainings_recyclerView_trainings)
    RecyclerView recyclerViewTrainings;

    @Bean
    TrainingRecyclerAdapter trainingRecyclerAdapter;

    @Bean
    HorizontalSpaceItemDecoration horizontalSpaceItemDecoration;

    @Bean
    VerticalSpaceItemDecoration verticalSpaceItemDecoration;

    // =========================================
    //  NewInstance
    // =========================================
    public static TraningsFragment newInstance() {
        return TraningsFragment_.builder().build();
    }

    // =========================================
    //  AbstractBaseFragment
    // =========================================
    @Override
    void init() {
        recyclerViewTrainings.setAdapter(trainingRecyclerAdapter);

        verticalSpaceItemDecoration.setHeightDimen(R.dimen.margin);
        horizontalSpaceItemDecoration.setWidthDimen(R.dimen.margin);

        recyclerViewTrainings.addItemDecoration(verticalSpaceItemDecoration);
        recyclerViewTrainings.addItemDecoration(horizontalSpaceItemDecoration);

        recyclerViewTrainings.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onShowKnowledgesEvent(ShowTrainingsEvent event) {
        trainingRecyclerAdapter.addItems(event.getTrainings());
    }
}
