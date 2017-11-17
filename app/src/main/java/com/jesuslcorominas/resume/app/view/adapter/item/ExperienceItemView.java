package com.jesuslcorominas.resume.app.view.adapter.item;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.util.Keys;
import com.jesuslcorominas.resume.app.util.PositionHelper;
import com.jesuslcorominas.resume.data.entity.Experience;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author Jesús López Corominas
 */
@EViewGroup(R.layout.item_experience)
public class ExperienceItemView extends CardView implements ItemView<Experience> {

    Context context;

    @ViewById(R.id.item_experience_imageView_logo)
    ImageView imageViewLogo;

    @ViewById(R.id.item_experience_textView_name)
    TextView textViewName;

    @ViewById(R.id.item_experience_textView_position)
    TextView textViewPosition;

    Experience experience;

    public ExperienceItemView(Context context) {
        super(context);

        this.context = context;
    }

    @Override
    public void bind(Experience item) {
        this.experience = item;

        this.setCardBackgroundColor(context.getResources().getColor(R.color.background_light));

        Picasso.
                with(context).
                load(Keys.IMAGES_PATH + item.getImage()).
                error(R.drawable.ic_no_image).
                into(imageViewLogo);

        textViewName.setText(item.getCompanyName());
        textViewPosition.setText(PositionHelper.getValue(item.getPosition()));
    }
}
