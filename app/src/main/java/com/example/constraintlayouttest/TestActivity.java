package com.example.constraintlayouttest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    private int type = 0;
    public static String TYPE = "type";
    public static int BASELINE = 1;
    public static int MARGIN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        type = getIntent().getIntExtra(TYPE, 0);
        if (type <= 0) {
            finish();
        } else {
            switch (type){
                case 1:
                    setContentView(R.layout.activity_baseline);
                    break;
                case 2:
                    setContentView(R.layout.activity_margin);
                    break;
                default:
                    break;
            }
        }
    }
}