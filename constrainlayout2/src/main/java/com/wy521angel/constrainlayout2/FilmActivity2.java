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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class FilmActivity2 extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_scene);

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
        ConstraintLayout root = findViewById(R.id.root);
        TransitionManager.beginDelayedTransition(root);
        ConstraintSet constraintSet = new ConstraintSet();
        if (toggle) {
            constraintSet.clone(this, R.layout.activity_end_scene);
        } else {
            constraintSet.clone(this, R.layout.activity_start_scene);
        }
        constraintSet.applyTo(root);
        toggle = !toggle;
    }
}
