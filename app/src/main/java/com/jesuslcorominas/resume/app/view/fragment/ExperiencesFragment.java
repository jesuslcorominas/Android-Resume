package com.jesuslcorominas.resume.app.view.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowExperiencesEvent;
import com.jesuslcorominas.resume.app.view.adapter.ExperiencesRecyclerAdapter;
import com.jesuslcorominas.resume.app.view.adapter.divider.HorizontalSpaceItemDecoration;
import com.jesuslcorominas.resume.app.view.adapter.divider.VerticalSpaceItemDecoration;
import com.jesuslcorominas.resume.app.view.adapter.item.ExperienceItemView;
import com.jesuslcorominas.resume.data.entity.Experience;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

/**
 * @author Jesús López Corominas
 */
@EFragment(R.layout.fragment_experiences)
public class ExperiencesFragment extends AbstractBaseFragment implements ExperiencesRecyclerAdapter.OnItemClickListener<Experience, ExperienceItemView> {

    private static final int COLUMNS = 2;

    @ViewById(R.id.fragment_experiences_recyclerView_experiences)
    RecyclerView recyclerViewExperiences;

    @Bean
    ExperiencesRecyclerAdapter experiencesRecyclerAdapter;

    @Bean
    HorizontalSpaceItemDecoration horizontalSpaceItemDecoration;

    @Bean
    VerticalSpaceItemDecoration verticalSpaceItemDecoration;

    // =========================================
    //  NewInstance
    // =========================================
    public static ExperiencesFragment newInstance() {
        return ExperiencesFragment_.builder().build();
    }

    // =========================================
    //  AbstractBaseFragment
    // =========================================
    @Override
    void init() {
        experiencesRecyclerAdapter.setOnItemClickListener(this);

        recyclerViewExperiences.setAdapter(experiencesRecyclerAdapter);

        verticalSpaceItemDecoration.setHeightDimen(R.dimen.margin);
        horizontalSpaceItemDecoration.setWidthDimen(R.dimen.margin);

        recyclerViewExperiences.addItemDecoration(verticalSpaceItemDecoration);
        recyclerViewExperiences.addItemDecoration(horizontalSpaceItemDecoration);

        recyclerViewExperiences.setLayoutManager(new GridLayoutManager(getActivity(), COLUMNS));
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onShowExperiencesEvent(ShowExperiencesEvent event) {
        experiencesRecyclerAdapter.addItems(event.getExperiences());
    }

    @Override
    public void onItemClick(int position, ExperienceItemView view, Experience data) {
        Log.d(ExperiencesFragment.class.getName(), "Click en la experiencia " + data.getCompanyName());
    }
}
