package com.jesuslcorominas.resume.app.view.adapter.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.data.entity.Training;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author Jesús López Corominas
 */
@EViewGroup(R.layout.item_training)
public class TrainingItemView extends CardView implements ItemView<Training> {

    Context context;

    @ViewById(R.id.item_training_textView_name)
    TextView textViewName;

    @ViewById(R.id.item_training_textView_school)
    TextView textViewSchool;

    @ViewById(R.id.item_training_textView_hours)
    TextView textViewDuration;

    @ViewById(R.id.item_training_textView_mark)
    TextView textViewMark;

    Training training;

    public TrainingItemView(Context context) {
        super(context);

        this.context = context;
    }

    @Override
    public void bind(Training item) {
        this.training = item;

        this.setCardBackgroundColor(context.getResources().getColor(R.color.background_light));

        String school = item.getSchool();


        if (item.getStart() != null) {
            if (item.getEnd() != null) {
                if (item.getStart().getYear() != item.getEnd().getYear()) {
                    textViewSchool.setText(context.getString(R.string.training_start_and_end, item.getSchool(), item.getStart().getYear(), item.getEnd().getYear()));
                } else {
                    textViewSchool.setText(context.getString(R.string.training_in_year, item.getSchool(), item.getStart().getYear()));
                }
            } else {
                textViewSchool.setText(context.getString(R.string.training_in_progress, item.getSchool(), item.getStart().getYear()));
            }
        } else {
            // Si no tenemos fecha de inicio no se pone fecha
            textViewSchool.setText(item.getSchool());
        }


        if (item.getMark() != null && item.getMark() > 0) {
            textViewMark.setVisibility(VISIBLE);
            textViewMark.setText(context.getString(R.string.training_mark, String.valueOf(item.getMark())));
        } else {
            textViewMark.setVisibility(GONE);
        }

        if (item.getHours() > 0) {
            textViewDuration.setVisibility(VISIBLE);
            textViewDuration.setText(context.getString(R.string.training_duration, item.getHours()));
        } else {
            textViewDuration.setVisibility(GONE);
        }

        textViewName.setText(item.getName());
    }
}
