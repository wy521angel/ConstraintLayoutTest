package com.wy521angel.constrainlayout2;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ADHelper extends ConstraintHelper {
    public ADHelper(Context context) {
        super(context);
    }

    public ADHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void updatePostLayout(ConstraintLayout container) {
        super.updatePostLayout(container);
        View[] views = getViews(container);
        for (View v : views) {
            Animator animator = ViewAnimationUtils.createCircularReveal(v, 0, 0, 0f, v.getWidth());
            animator.setDuration(5000);
            animator.start();
        }
    }
}
