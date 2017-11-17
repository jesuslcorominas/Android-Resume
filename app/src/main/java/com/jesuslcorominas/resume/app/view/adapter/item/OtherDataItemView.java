package com.jesuslcorominas.resume.app.view.adapter.item;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.data.entity.OtherData;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author Jesús López Corominas
 */
@EViewGroup(R.layout.item_other_data)
public class OtherDataItemView extends CardView implements ItemView<OtherData> {

    Context context;

    OtherData otherData;

    @ViewById(R.id.item_otherData_textView_name)
    AppCompatTextView textViewName;

    @ViewById(R.id.item_otherData_textView_description)
    AppCompatTextView textViewDescription;

    public OtherDataItemView(Context context) {
        super(context);

        this.context = context;
    }

    @Override
    public void bind(OtherData item) {
        this.otherData = item;

        this.setCardBackgroundColor(context.getResources().getColor(R.color.background_light));

        textViewName.setText(item.getName());
        textViewDescription.setText(item.getDescription());
    }
}
