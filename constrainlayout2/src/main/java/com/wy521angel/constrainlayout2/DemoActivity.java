package com.wy521angel.constrainlayout2;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Layer;

public class DemoActivity extends AppCompatActivity {

    private int type = 0;
    public static String TYPE = "type";
    public static int FLOW = 1;
    public static int LAYER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        type = getIntent().getIntExtra(TYPE, 0);
        if (type <= 0) {
            finish();
        } else {
            switch (type) {
                case 1:
                    setContentView(R.layout.activity_flow);
                    break;
                case 2:
                    setContentView(R.layout.activity_layer);
                    Layer layer = findViewById(R.id.layer);
                    addAnimator(layer);
                    break;
                default:
                    break;
            }
        }

    }

    private void addAnimator(final Layer layer) {
        final ValueAnimator animator = ValueAnimator.ofFloat(0f, 360f);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setDuration(2000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                layer.setRotation((Float) animation.getAnimatedValue());
            }
        });
        layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });
    }
}


