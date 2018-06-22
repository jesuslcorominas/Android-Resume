package com.jesuslcorominas.resume.app.util;

import android.app.Activity;
import android.content.Context;

import com.jesuslcorominas.resume.app.R;
import com.jesuslcorominas.resume.app.view.activity.ExperienceDetailActivity_;
import com.jesuslcorominas.resume.app.view.activity.ExperiencesActivity_;
import com.jesuslcorominas.resume.app.view.activity.KnowledgesActivity_;
import com.jesuslcorominas.resume.app.view.activity.MainActivity_;
import com.jesuslcorominas.resume.app.view.activity.OtherDataActivity_;
import com.jesuslcorominas.resume.app.view.activity.ProjectDetailActivity_;
import com.jesuslcorominas.resume.app.view.activity.TrainingsActivity_;
import com.jesuslcorominas.resume.data.entity.ExperienceObjectBoxEntity;
import com.jesuslcorominas.resume.data.entity.ProjectObjectBoxEntity;

import org.androidannotations.annotations.EBean;

/**
 * @author Jesús López Corominas
 */
@EBean(scope = EBean.Scope.Singleton)
public class Navigator {

    public void main(Context origin) {
        MainActivity_.intent(origin).start();
        anim(origin);
    }

    public void experiences(Context origin) {
        ExperiencesActivity_.intent(origin).start();
        anim(origin);
    }

    public void experienceDetail(Context origin, ExperienceObjectBoxEntity experience) {
        ExperienceDetailActivity_.intent(origin).experienceId(experience.getId()).start();
        anim(origin);
    }

    public void projectDetail(Context origin, ProjectObjectBoxEntity project) {
        ProjectDetailActivity_.intent(origin).projectId(project.getId()).start();
        anim(origin);
    }

    public void otherData(Context origin) {
        OtherDataActivity_.intent(origin).start();
        anim(origin);
    }

    public void knowledges(Context origin) {
        KnowledgesActivity_.intent(origin).start();
        anim(origin);
    }

    public void trainings(Context origin) {
        TrainingsActivity_.intent(origin).start();
        anim(origin);
    }

    private void anim(Context context) {
        if (context instanceof Activity) {
            anim((Activity) context);
        }
    }

    public void up(Activity origin) {
        origin.finish();
        origin.overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_right);
    }

    private void anim(Activity origin) {
        origin.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

}
