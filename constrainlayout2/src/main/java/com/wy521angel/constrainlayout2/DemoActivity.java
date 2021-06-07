package com.wy521angel.constrainlayout2;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.utils.widget.ImageFilterView;

public class DemoActivity extends AppCompatActivity {

    private int type = 0;
    public static String TYPE = "type";
    public static int FLOW = 1;
    public static int LAYER = 2;
    public static int HELPER = 3;
    public static int IMAGE = 4;
    public static int MOCKVIEW = 5;
    public static int MOTIONLAYOUT_1 = 6;
    public static int MOTIONLAYOUT_2 = 7;
    public static int MOTIONLAYOUT_3 = 8;
    public static int MOTIONLAYOUT_4 = 9;
    public static int MOTIONLAYOUT_KEYCYCLE = 10;
    public static int MOTIONLAYOUT_KEYTIMECYCLE = 11;
    public static int MOTIONLAYOUT_KEYTRIGGER = 12;
    public static int ANIMATION_1 = 13;
    public static int ANIMATION_2 = 14;
    public static int MOTIONLAYOUT_TRANSFORM = 15;

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
                case 3:
                    setContentView(R.layout.activity_constrainthelper);
                    break;
                case 4:
                    setContentView(R.layout.activity_image);
                    break;
                case 5:
                    setContentView(R.layout.activity_mockview);
                    break;
                case 6:
                    setContentView(R.layout.activity_motionlayout1);
                    break;
                case 7:
                    setContentView(R.layout.activity_motionlayout2);
                    break;
                case 8:
                    setContentView(R.layout.activity_motionlayout3);
                    break;
                case 9:
                    setContentView(R.layout.activity_motionlayout4);
                    break;
                case 10:
                    setContentView(R.layout.activity_keycycle);
                    break;
                case 11:
                    setContentView(R.layout.activity_keytimecycle);
                    break;
                case 12:
                    setContentView(R.layout.activity_keytrigger);
                    break;
                case 13:
                    setContentView(R.layout.activity_animation_1);
                    doAnimation();
                    break;
                case 14:
                    setContentView(R.layout.activity_animation_2);
                    doAnimation2();
                    break;
                case 15:
                    setContentView(R.layout.activity_transform);
                    break;
                default:
                    break;
            }
        }

    }

    private void doAnimation() {
        final View root = findViewById(R.id.root);
        final ImageFilterView image1 = findViewById(R.id.image1);
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int distance = root.getWidth() - image1.getWidth();
                image1.animate().translationX(distance).start();
            }
        });

        final ImageFilterView image2 = findViewById(R.id.image2);
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) image2.getLayoutParams();
                lp.gravity = Gravity.END;
                image2.setLayoutParams(lp);
            }
        });

        final ImageFilterView image3 = findViewById(R.id.image3);
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition((ViewGroup) image3.getParent());
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) image3.getLayoutParams();
                lp.gravity = Gravity.END;
                image3.setLayoutParams(lp);
            }
        });
    }

    private void doAnimation2() {
        Button btn1 = findViewById(R.id.btn1);
        final ImageView image = findViewById(R.id.image2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 属性动画
                image.animate()
                        .scaleX(2.0f)
                        .scaleY(2.0f)
                        .start();

            }
        });

        final ImageFilterView image2 = findViewById(R.id.image2);
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 过渡动画
                TransitionManager.beginDelayedTransition((ViewGroup) image.getParent());
                ViewGroup.LayoutParams lp = image.getLayoutParams();
                lp.width *= 2;
                lp.height *= 2;
                image.setLayoutParams(lp);
            }
        });
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


