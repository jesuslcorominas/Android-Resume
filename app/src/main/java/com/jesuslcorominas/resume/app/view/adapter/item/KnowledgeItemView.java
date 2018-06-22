package com.jesuslcorominas.resume.app.view.adapter.item;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.widget.ProgressBar;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.util.Keys;
import com.jesuslcorominas.resume.commons.model.Knowledge;
import com.jesuslcorominas.resume.commons.model.KnowledgeLevel;
import com.jesuslcorominas.resume.data.entity.KnowledgeObjectBoxEntity;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author Jesús López Corominas
 */
@EViewGroup(R.layout.item_knowledges)
public class KnowledgeItemView extends CardView implements ItemView<Knowledge> {

    Context context;

    Knowledge knowledge;

    @ViewById(R.id.item_knowledge_textView_name)
    AppCompatTextView textViewName;

    @ViewById(R.id.item_knowledge_progressBar_level)
    ProgressBar progressBarLevel;

    @ViewById(R.id.item_knowledge_imageView_logo)
    AppCompatImageView imageViewLogo;

    public KnowledgeItemView(Context context) {
        super(context);

        this.context = context;
    }

    @Override
    public void bind(Knowledge item) {
        this.knowledge = item;

        this.setCardBackgroundColor(context.getResources().getColor(R.color.background_light));

        textViewName.setText(item.getName());
        Picasso.
                with(context).
                load(Keys.IMAGES_PATH + item.getImage()).
                error(R.drawable.ic_no_image).
                into(imageViewLogo);

        // Sumamos 1 porque nunca se puede saber algo al completo
        progressBarLevel.setMax(KnowledgeLevel.getMaxValue() + 1);
        progressBarLevel.setProgress(item.getLevel().getValue());

    }
}
