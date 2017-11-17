package com.jesuslcorominas.resume.app.view.fragment;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.event.impl.ShowPersonalDataEvent;
import com.jesuslcorominas.resume.data.entity.PersonalData;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.Subscribe;

/**
 * @author Jesús López Corominas
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends AbstractBaseFragment {

    @ViewById(R.id.fragment_main_textView_email)
    AppCompatTextView textViewEmail;

    @ViewById(R.id.fragment_main_textView_phone)
    AppCompatTextView textViewPhone;

    @ViewById(R.id.fragment_main_textView_summary)
    AppCompatTextView textViewSummary;

    @ViewById(R.id.fragment_main_cardView_email)
    CardView cardViewEmail;

    @ViewById(R.id.fragment_main_cardView_phone)
    CardView cardViewPhone;

    @ViewById(R.id.fragment_main_cardView_summary)
    CardView cardViewSummary;

    // =========================================
    //  NewInstance
    // =========================================
    public static MainFragment newInstance() {
        return MainFragment_.builder().build();
    }

    // =========================================
    //  AbstractBaseFragment
    // =========================================
    @Override
    void init() {

    }

    @SuppressWarnings("unused")
    @Subscribe
    void onShowPersonalData(ShowPersonalDataEvent event) {
        PersonalData personalData = event.getPersonalData();

        textViewPhone.setText(personalData.getPhoneNumber());
        cardViewPhone.setVisibility(TextUtils.isEmpty(personalData.getPhoneNumber()) ? View.GONE : View.VISIBLE);

        textViewEmail.setText(personalData.getEmail());
        cardViewEmail.setVisibility(TextUtils.isEmpty(personalData.getEmail()) ? View.GONE : View.VISIBLE);

        textViewSummary.setText(personalData.getSummary());
        cardViewSummary.setVisibility(TextUtils.isEmpty(personalData.getSummary()) ? View.GONE : View.VISIBLE);
    }
}
