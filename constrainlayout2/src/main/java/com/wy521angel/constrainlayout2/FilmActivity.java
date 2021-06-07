package com.wy521angel.constrainlayout2;

import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FilmActivity extends AppCompatActivity implements View.OnClickListener  {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        bindData();
    }

    private void bindData() {
        findViewById(R.id.image_film_cover).setOnClickListener(this);
        ((RatingBar) findViewById(R.id.rating_film_rating)).setRating(4.5f);
        ((TextView) findViewById(R.id.text_film_title)).setText(R.string.film_title);
        ((TextView) findViewById(R.id.text_film_description)).setText(R.string.film_description);
    }

    private boolean toggle = true;

    @Override
    public void onClick(View v) {
        ViewGroup root = findViewById(R.id.root);
        Scene startScene = Scene.getSceneForLayout(root, R.layout.film_start_scene, this);
        Scene endScene = Scene.getSceneForLayout(root, R.layout.film_end_scene, this);
        if (toggle) {
            TransitionManager.go(endScene);
        } else {
            TransitionManager.go(startScene);
        }

        // 需要重新绑定数据，否则点击后会无法切换场景
        // TransitionManager.go()切换场景后会将当前场景的控件全部移除替换为结束场景的控件对象
        // 两个场景的对象不一样，所以需要重新绑定
        // 虽然会重复的创建对象，但不需要过于担心性能问题
        bindData();
        toggle = !toggle;
    }
}
