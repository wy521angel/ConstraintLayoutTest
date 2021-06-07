package com.wy521angel.constrainlayout2;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class FilmActivity3 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion_layout);

        bindData();
    }

    private void bindData() {
        ((RatingBar) findViewById(R.id.rating_film_rating)).setRating(4.5f);
        ((TextView) findViewById(R.id.text_film_title)).setText(R.string.film_title);
        ((TextView) findViewById(R.id.text_film_description)).setText(R.string.film_description);
    }
}
