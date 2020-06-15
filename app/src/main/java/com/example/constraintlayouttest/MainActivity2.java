package com.example.constraintlayouttest;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {

    Placeholder mainAction;
    ConstraintLayout constraintLayout;

    ImageButton save, delete, cancel, edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mainAction = (Placeholder) findViewById(R.id.template_action);
        constraintLayout = (ConstraintLayout) findViewById(R.id.root);

        save = (ImageButton) findViewById(R.id.save);
        delete = (ImageButton) findViewById(R.id.delete);
        cancel = (ImageButton) findViewById(R.id.cancel);
        edit = (ImageButton) findViewById(R.id.edit);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                mainAction.setContentId(view.getId());
            }
        });
    }
}
