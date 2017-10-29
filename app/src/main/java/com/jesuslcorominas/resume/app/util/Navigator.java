package com.jesuslcorominas.resume.app.util;

import android.app.Activity;
import android.content.Context;

import com.jesuslcorominas.resume.app.view.activity.MainActivity_;

import org.androidannotations.annotations.EBean;

/**
 * @author Jesús López Corominas
 */
@EBean(scope = EBean.Scope.Singleton)
public class Navigator {

    public void main(Context origin) {
        MainActivity_.intent(origin).start();
        if (origin instanceof Activity) {
            anim(origin);
        }
    }

    public boolean up(Activity origin) {
        origin.finish();
        return true;
    }

    private void anim(Context context) {
        if (context instanceof Activity) {
            anim((Activity) context);
        }
    }

    private void anim(Activity origin) {

    }
}
