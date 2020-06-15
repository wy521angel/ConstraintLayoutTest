package com.example.constraintlayouttest;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class ClickActivity extends AppCompatActivity {

    private ConstraintSet orbitsConstraint = new ConstraintSet();
    private ConstraintSet detailsConstraint = new ConstraintSet();
    private ConstraintLayout mConstraintLayout;
    ValueAnimator earthAnimator;
    ValueAnimator marsAnimator;
    ValueAnimator saturnAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        mConstraintLayout = findViewById(R.id.root);
        orbitsConstraint.clone(mConstraintLayout);
        detailsConstraint.clone(this, R.layout.activity_circle2);

        ImageView sunImage = findViewById(R.id.sun_image);
        ImageView earthImage = findViewById(R.id.earth_image);
        ImageView marsImage = findViewById(R.id.mars_image);
        ImageView saturnImage = findViewById(R.id.saturn_image);

        earthAnimator = animatePlanet(earthImage, TimeUnit.SECONDS.toMillis(2));
        marsAnimator = animatePlanet(marsImage, TimeUnit.SECONDS.toMillis(6));
        saturnAnimator = animatePlanet(saturnImage, TimeUnit.SECONDS.toMillis(12));

        earthAnimator.start();
        marsAnimator.start();
        saturnAnimator.start();

        sunImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickActivity.this.cancelAnim();
                TransitionManager.beginDelayedTransition(mConstraintLayout);
                detailsConstraint.applyTo(mConstraintLayout);
            }
        });
    }

    private void cancelAnim() {
        if (earthAnimator.isRunning()) earthAnimator.cancel();
        if (marsAnimator.isRunning()) marsAnimator.cancel();
        if (saturnAnimator.isRunning()) saturnAnimator.cancel();
    }

    private ValueAnimator animatePlanet(final ImageView planet, long orbitDuration) {
        ValueAnimator anim = ValueAnimator.ofInt(0, 359);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) planet.getLayoutParams();
                layoutParams.circleAngle = val;
                planet.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(orbitDuration);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        return anim;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelAnim();
    }
}
