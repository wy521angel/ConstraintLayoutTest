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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

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
    public static int MOTIONLAYOUT_JAVA = 16;
    public static int MOTIONLAYOUT_VIEWPAGER = 17;

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
                case 16:
                    setContentView(R.layout.activity_java);
                    doChange();
                    break;
                case 17:
                    setContentView(R.layout.activity_view_pager);
                    initViewForViewPager();
                    break;
                default:
                    break;
            }
        }

    }

    private void initViewForViewPager() {
        final List<Fragment> fragmentList = new ArrayList<>();
        int[] avatars = {R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4};
        final String[] titles = {"大雄", "胖虎", "小夫", "静香"};
        for (int avatar : avatars) {
            fragmentList.add(ItemFragment.newInstance(avatar));
        }
        final FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        };

        final MotionLayout motionLayout = findViewById(R.id.motionLayout);
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                motionLayout.setProgress((position + positionOffset) / (adapter.getCount() - 1));
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void doChange() {
        final MotionLayout motionLayout = findViewById(R.id.motionLayout);
        Button btnState1 = findViewById(R.id.btnState1);
        Button btnState2 = findViewById(R.id.btnState2);
        btnState1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintSet constraintSet = motionLayout.getConstraintSet(R.id.end);
                ConstraintSet.Constraint constraint = constraintSet.getConstraint(R.id.box);
                constraint.layout.topToTop = Constraints.LayoutParams.PARENT_ID;
                constraint.layout.bottomToBottom = Constraints.LayoutParams.PARENT_ID;
                constraint.layout.endToEnd = Constraints.LayoutParams.PARENT_ID;
                //transform 可以改变旋转缩放等属性
                constraint.transform.rotationY = 180f;
                constraint.transform.rotationX = 0f;
                constraint.transform.scaleY = 2f;
                constraint.transform.scaleX = 2f;
                constraint.propertySet.alpha = 0.1f;
            }
        });
        btnState2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintSet constraintSet = motionLayout.getConstraintSet(R.id.end);
                ConstraintSet.Constraint constraint = constraintSet.getConstraint(R.id.box);
                constraint.layout.topToTop = Constraints.LayoutParams.PARENT_ID;
                constraint.layout.endToEnd = Constraints.LayoutParams.PARENT_ID;
                //去除约束将View 放到右上角
                constraint.layout.bottomToBottom = Constraints.LayoutParams.UNSET;
                constraint.transform.rotationX = 180f;
                constraint.transform.rotationY = 0f;
            }
        });

        /**
         * fix 动画在执行时，点击动画会重头开始问题
         * 1.去掉xml中的<OnClick/>
         * 2.自己编写对应的点击事件控制动画
         * motionLayout 中有currentState、startState、endState
         * startState 就是Transition的motion:constraintSetStart设置的id，endState同理
         * 上述结论 在motionLayout的setTransition(int beginId, int endId)方法中可以看出
         */
        motionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            Log.i(TAG, "currentState: ${binding.motionLayout.currentState}")
//            Log.i(TAG, "startState: ${binding.motionLayout.startState},R.id.start: ${R.id.start}")
//            Log.i(TAG, "startState: ${binding.motionLayout.endState},R.id.end: ${R.id.end}")

                //运动中currentState的值是-1 不做处理
                if (motionLayout.getCurrentState() == -1) {
                    return;
                }

                if (motionLayout.getCurrentState() == motionLayout.getStartState()) {
                    motionLayout.transitionToEnd();
                } else if (motionLayout.getCurrentState() == motionLayout.getEndState()) {
                    motionLayout.transitionToStart();
                }
            }
        });
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


