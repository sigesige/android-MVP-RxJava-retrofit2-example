package com.hond.mvpexample.Utils;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/**
 * Created by hond on 11/17/2016.
 */

public class UtilFunction {
    public static ProgressBar createProgressBar(Activity activity) {

        FrameLayout rootFrameLayout = (FrameLayout) activity.findViewById(android.R.id.content);
        FrameLayout.LayoutParams layoutParams =
                new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;

        ProgressBar progressBar = new ProgressBar(activity);
        progressBar.setLayoutParams(layoutParams);
        progressBar.setVisibility(View.GONE);
        rootFrameLayout.addView(progressBar);
        return progressBar;
    }
}
