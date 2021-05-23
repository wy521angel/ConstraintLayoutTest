package com.example.constraintlayouttest;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

public class BarrierActivity extends AppCompatActivity {

    private TextView title;
    private TextView desc;
    private CheckBox cb, cb2;
    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barrier);

        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        group = findViewById(R.id.group);
        cb = findViewById(R.id.cb);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    title.setText("This is Title");
                    desc.setText("desc");
                } else {
                    title.setText("Title");
                    desc.setText("This is a descriptive text.");
                }
            }
        });

        cb2 = findViewById(R.id.cb2);

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    group.setVisibility(View.GONE);
                } else {
                    group.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
