package com.jesuslcorominas.resume.app.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowOtherDataEvent;
import com.jesuslcorominas.resume.app.view.adapter.OtherDataRecyclerAdapter;
import com.jesuslcorominas.resume.app.view.adapter.divider.HorizontalSpaceItemDecoration;
import com.jesuslcorominas.resume.app.view.adapter.divider.VerticalSpaceItemDecoration;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

/**
 * @author Jesús López Corominas
 */
@EFragment(R.layout.fragment_other_data)
public class OtherDataFragment extends AbstractBaseFragment {

    @ViewById(R.id.fragment_otherData_recyclerView_otherData)
    RecyclerView recyclerViewOtherData;

    @Bean
    OtherDataRecyclerAdapter otherDataRecyclerAdapter;

    @Bean
    HorizontalSpaceItemDecoration horizontalSpaceItemDecoration;

    @Bean
    VerticalSpaceItemDecoration verticalSpaceItemDecoration;

    // =========================================
    //  NewInstance
    // =========================================
    public static OtherDataFragment newInstance() {
        return OtherDataFragment_.builder().build();
    }

    // =========================================
    //  AbstractBaseFragment
    // =========================================
    @Override
    void init() {
        recyclerViewOtherData.setAdapter(otherDataRecyclerAdapter);

        verticalSpaceItemDecoration.setHeightDimen(R.dimen.margin);
        horizontalSpaceItemDecoration.setWidthDimen(R.dimen.margin);

        recyclerViewOtherData.addItemDecoration(verticalSpaceItemDecoration);
        recyclerViewOtherData.addItemDecoration(horizontalSpaceItemDecoration);

        recyclerViewOtherData.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void onShowOtherDataEvent(ShowOtherDataEvent event) {
        otherDataRecyclerAdapter.addItems(event.getOtherDataList());
    }
}
